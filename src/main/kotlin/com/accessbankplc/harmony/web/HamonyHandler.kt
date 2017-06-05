package com.accessbankplc.harmony.web


import com.accessbankplc.harmony.graphql.SchemaProvider
import graphql.GraphQL.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.*

//@Service
//class HamonyHandler @Autowired constructor(val schemaProvider: SchemaProvider) {
//
//    fun graphql(request: ServerRequest): Mono<ServerResponse> {
//
//        //println(request.bodyToFlux(GraphQLRequestQuery::class.java).blockFirst().query)
//        return request.bodyToMono(GraphQLRequestQuery::class.java).flatMap { query ->
//            val graphQL = newGraphQL(schemaProvider.schema).build()
//            val result = graphQL.execute(query.query, query.operationName, null, query.variables ?: mapOf())
//
//            val data: Map<*, *>? = result.getData<Map<*, *>>()
//            println(data)
//
//            val responseString = mutableMapOf<String, Any?>()
//
//            responseString.put("data", data ?: null)
//            result.errors?.let {
//                if (!result.errors.isEmpty())
//                    responseString.put("errors", result.errors)
//            }
//
//            just(ok().body(just(responseString as Map<*, *>), Map::class.java)).flatMap { mono -> mono }
//        }
//
//
//    }
//
//    companion object {
//        class GraphQLRequestQuery(var query: String, var operationName: String?, var variables: MutableMap<String, Any>?)
//    }
//}
