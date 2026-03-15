package com.nasko.listeners

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.LoggerFactory
import com.nasko.commands.CommandManager

private val logger = LoggerFactory.getLogger("MessageListener")

class MessageListener : ListenerAdapter() {
    private val commandManager = CommandManager()
    
    override fun onMessageReceived(event: MessageReceivedEvent) {
        // Ignore bot messages
        if (event.author.isBot) return
        
        val message = event.message.contentRaw
        
        // Check if message starts with prefix
        if (!message.startsWith(PREFIX)) return
        
        val args = message.substring(PREFIX.length).split(Regex("\\s+"))
        val commandName = args.getOrNull(0)?.lowercase() ?: return
        val commandArgs = args.drop(1)
        
        logger.info("Command received: $commandName from ${'$'}{event.author.name}")
        
        try {
            commandManager.executeCommand(commandName, commandArgs, event)
        } catch (e: Exception) {
            logger.error("Error executing command: $commandName", e)
            event.channel.sendMessage("❌ Error executing command: ${'$'}{e.message}").queue()
        }
    }
    
    companion object {
        const val PREFIX = "!"
    }
}