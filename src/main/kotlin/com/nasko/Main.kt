package com.nasko

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import com.nasko.listeners.MessageListener
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("Nasko")

fun main() {
    val token = System.getenv("DISCORD_TOKEN") 
        ?: throw IllegalArgumentException("DISCORD_TOKEN environment variable not set")
    
    logger.info("Starting Nasko bot...")
    
    val jda = JDABuilder.createDefault(token)
        .enableIntents(GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
        .addEventManager(net.dv8tion.jda.api.hooks.AnnotatedEventManager())
        .addEventListeners(MessageListener())
        .build()
    
    jda.awaitReady()
    logger.info("Nasko bot is ready!")
}