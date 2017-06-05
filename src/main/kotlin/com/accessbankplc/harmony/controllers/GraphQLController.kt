package com.accessbankplc.harmony.controllers

import com.accessbankplc.harmony.graphql.SchemaProvider
import graphql.GraphQL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


/**
 * Created by peace on 5/29/17.
 */

@RestController
@CrossOrigin(origins = arrayOf("*"))
class GraphQLController @Autowired constructor(val schemaProvider: SchemaProvider) {

    @RequestMapping(value = "/graphql", method = arrayOf(RequestMethod.POST), consumes = arrayOf("application/json"))
    fun graphql(@RequestBody q: Mono<GraphQLRequestQuery>, request:ServerHttpRequest): Mono<MutableMap<String, Any?>> {

        //println(request.bodyToFlux(GraphQLRequestQuery::class.java).blockFirst().query)
        return q.flatMap { query ->
            val graphQL = GraphQL.newGraphQL(schemaProvider.schema)
                    //.queryExecutionStrategy(ReactiveExecutionStrategy())
                    //.mutationExecutionStrategy(ReactiveExecutionStrategy())
                    .build()

            //println("${query.operationName}")
            val remoteAddress = request.remoteAddress
            val orElseGet = remoteAddress.orElseGet({ -> null })

            val context = GraphQLContext(ipAddress = orElseGet.address.hostAddress, port = orElseGet.port);
            val result = graphQL.execute(query.query, query.operationName, context, query.variables ?: mapOf())

            val data: Map<*, *>? = result.getData()
            //  val d = result.getData<Publisher<Change>>()


            val responseString = mutableMapOf<String, Any?>()

            responseString.put("data", data ?: null)
            result.errors?.let {
                if (!result.errors.isEmpty())
                    responseString.put("errors", result.errors)
            }

            Mono.just(responseString)
//                Mono.fromDirect(d).takeIf { c-> true }!!.map {
//                    change ->
//                    println(change.data)
//                    val resp = mutableMapOf<String, Any?>()
//                    result.errors?.let {
//                        if (!result.errors.isEmpty())
//                            resp.put("errors", result.errors)
//                    }
//                    resp.put("data", change.data ?: null)
//                    resp
//                }
        }

    }

    companion object {
        class GraphQLRequestQuery(var query: String, var operationName: String?, var variables: MutableMap<String, Any>?)
        data class GraphQLContext(val ipAddress: String, val port: Int)
    }
}