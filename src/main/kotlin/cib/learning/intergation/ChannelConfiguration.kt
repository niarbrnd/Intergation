package cib.learning.intergation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.MessageChannels

@Configuration
class ChannelsConfiguration {

    @Bean
    fun txt() = MessageChannels.direct().get()

    @Bean
    fun csv() = MessageChannels.direct().get()

    @Bean
    fun errors() = MessageChannels.direct().get()
}