package com.accessbankplc.harmony.graphql

import com.accessbankplc.harmony.graphql.classes.Query
import com.accessbankplc.harmony.graphql.classes.ViewerResolver
import com.accessbankplc.harmony.graphql.types.ADUser
import com.accessbankplc.harmony.graphql.types.Viewer
import com.coxautodev.graphql.tools.SchemaParser
import graphql.schema.GraphQLSchema
import org.springframework.stereotype.Service

/**
 * Created by peace on 5/27/17.
 */
@Service
class SchemaProvider{

    val schema: GraphQLSchema

    constructor(){
        schema = createSchema()
    }

    private fun createSchema() : GraphQLSchema {
        val parser = SchemaParser.newParser()
                .files("Schema.graphqls")
                .resolvers(Query(), ViewerResolver())
                //.dictionary(ADUser::class.java)
                .build()
        return parser.makeExecutableSchema()
    }
}
