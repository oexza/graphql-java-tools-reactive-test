package com.accessbankplc.harmony.web

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RouterFunction

import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

//interface ApplicationRoutes {
//    companion object {
//        fun routes(hamonyHandler: HamonyHandler): RouterFunction<*> {
//            return nest(path("/graphqle"),
//                    nest(accept(MediaType.APPLICATION_JSON),
//                            route(POST("/"), HandlerFunction<ServerResponse>(hamonyHandler::graphql))
//
//                    ))
//        }
//    }
//
//}
