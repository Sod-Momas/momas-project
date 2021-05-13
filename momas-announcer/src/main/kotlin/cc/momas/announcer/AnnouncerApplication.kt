package cc.momas.announcer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnnouncerApplication

fun main(args: Array<String>) {
	runApplication<AnnouncerApplication>(*args)
}
