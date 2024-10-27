package br.com.management.autoparts.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["br.com.management.autoparts"])
class AutoPartsApplication

fun main(args: Array<String>) {
	runApplication<AutoPartsApplication>(*args)
}
