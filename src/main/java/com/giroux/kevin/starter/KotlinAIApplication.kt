package com.giroux.kevin.starter

import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(value = ["com.giroux.kevin"])
class KotlinAIApplication

fun main(args: Array<String>) {
    val app = SpringApplication(KotlinAIApplication::class.java)
    app.webApplicationType = WebApplicationType.REACTIVE
    app.run(*args)
}