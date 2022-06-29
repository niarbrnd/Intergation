package cib.learning.intergation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.integrationFlow
import org.springframework.integration.file.dsl.Files.inboundAdapter
import org.springframework.web.servlet.function.RouterFunctions.route
import java.io.File
import java.nio.file.Files

@Configuration
class FileConfiguration(private val channels: ChannelsConfiguration) {

    private val input = File("${System.getenv("HOME")}/Desktop/in")
    private val output = File("${System.getenv("HOME")}/Desktop/out")
    private val csv = File(output, "csv")
    private val txt = File(output, "txt")

    @Bean
    fun filesFlow() = integrationFlow(
        Files.inboundAdapter(this.input).autoCreateDirectory(true),
        { poller { it.fixedDelay(500).maxMessagesPerPoll(1) } }
    ) {

        filter<File> { it.isFile }
        route<File> {
            when (it.extension.toLowerCase()) {
                "csv" -> channels.csv()
                "txt" -> channels.txt()
                else -> channels.errors()
            }
        }
    }

    private fun poller(any: Any) {
        TODO("Not yet implemented")
    }
}