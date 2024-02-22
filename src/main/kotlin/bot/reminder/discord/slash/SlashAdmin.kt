package bot.reminder.discord.slash

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

object SlashAdmin: ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        when (event.name) {
            "ping" -> {
                val time = System.currentTimeMillis()
                event.reply("What will the bot say?").setEphemeral(false) // reply or acknowledge
                    .flatMap { event.hook.editOriginalFormat("Pong! : %d ms", System.currentTimeMillis() - time) } // then edit original
                    .queue() // Queue both reply and edit
            }
        }
    }

}