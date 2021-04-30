package com.strategypoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class StrategypocApplication

fun main(args: Array<String>) {
	runApplication<StrategypocApplication>(*args)
}
