package com.giroux.kevin.network

import com.giroux.kevin.neurone.Neurone
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import reactor.core.publisher.TopicProcessor
import javax.annotation.PostConstruct

@Component
class NeuroneWebSocketHandler : WebSocketHandler {

    private lateinit var session: WebSocketSession

    private val processor = TopicProcessor.share<NeuroneMessage>("shared", 1024)

    private lateinit var message: NeuroneMessage

    @PostConstruct
    fun init(){
        this.message = NeuroneMessage("Neurone")
        this.message.setNeurone(Neurone())
    }


    override fun handle(session: WebSocketSession): Mono<Void> {
       this.session = session

        return session.send(
            processor
                .map { ev -> session.textMessage("${this.message.message}|${this.message.getNeurone()}") }
        ).and(session.receive()
                .map { ev ->
                    val parts = ev.payloadAsText.split(":")
                    NeuroneMessage(message = parts[0])
                }
                .filter { ev -> true }
                .log()
                .doOnNext { ev -> processor.onNext(ev) })
        }

    fun sendMessage(neuroneMessage: NeuroneMessage){
        this.message = neuroneMessage
    }
}