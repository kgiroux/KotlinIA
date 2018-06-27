package com.giroux.kevin.network

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter

@Configuration
@EnableWebFlux
@ComponentScan(value = ["com.giroux.kevin"])
class NeuroneWebSocketConfig(val webSocketHandler: NeuroneWebSocketHandler) {


    @Bean
    fun websocketHandlerAdapter() = WebSocketHandlerAdapter()

    @Bean
    fun handlerMapping() : HandlerMapping {
        val handlerMapping = SimpleUrlHandlerMapping()
        handlerMapping.urlMap = mapOf(
            "/logsComputation" to webSocketHandler
        )
        handlerMapping.order = 1
        return handlerMapping
    }
}