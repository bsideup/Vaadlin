package ru.trylogic.vaadlin.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.platform.platformStatic

@SpringBootApplication
public open class VaadlinApplication {
    companion object {
        platformStatic public fun main(args: Array<String>) {
            SpringApplication.run(javaClass<VaadlinApplication>(), *args)
        }
    }
}