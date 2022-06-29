package cib.learning.intergation
//https://coderlessons.com/articles/java/spring-integration-prilozhenie-s-nulia-chast-1
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.dsl.MessageChannels

@SpringBootApplication
@EnableIntegration
class IntergationApplication

fun main(args: Array<String>) {
    runApplication<IntergationApplication>(*args)
    @Configuration
    class ChannelsConfiguration {

        @Bean
        fun txt() = MessageChannels.direct().get()

        @Bean
        fun csv() = MessageChannels.direct().get()

        @Bean
        fun errors() = MessageChannels.direct().get()
    }
}
