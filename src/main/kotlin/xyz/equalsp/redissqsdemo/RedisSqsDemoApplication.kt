package xyz.equalsp.redissqsdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RedisSqsDemoApplication

fun main(args: Array<String>) {
	runApplication<RedisSqsDemoApplication>(*args)
}
