package cib.learning.intergation
//https://coderlessons.com/articles/java/spring-integration-prilozhenie-s-nulia-chast-1
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@EnableIntegration
class IntergationApplication

fun main(args: Array<String>) {
    runApplication<IntergationApplication>(*args)
}
