package com.springpocs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class SpringpocsApplication

fun main(args: Array<String>) {
	runApplication<SpringpocsApplication>(*args)
}
