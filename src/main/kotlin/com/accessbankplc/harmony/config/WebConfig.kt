package com.accessbankplc.harmony.config


//import com.accessbankplc.harmony.web.ApplicationRoutes
//import com.accessbankplc.harmony.web.HamonyHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.filter.CorsFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


//@Configuration
//class WebConfig @Autowired
//constructor(private val hamonyHandler: HamonyHandler) {
//
//    //@Bean
//    fun routerFunction(): RouterFunction<*> {
//        return ApplicationRoutes.routes(this.hamonyHandler)
//    }
//
//    @Bean
//    fun corsFilter(): FilterRegistrationBean<*> {
//        val source = UrlBasedCorsConfigurationSource()
//        val config = CorsConfiguration()
//        config.allowCredentials = true
//        config.addAllowedOrigin("*")
//        config.addAllowedHeader("*")
//        config.addAllowedMethod("*")
//        source.registerCorsConfiguration("/**", config)
//        val bean = FilterRegistrationBean(CorsFilter(source))
//        bean.order = 0
//        return bean
//    }
//}
