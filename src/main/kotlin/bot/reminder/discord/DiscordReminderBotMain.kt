package bot.reminder.discord

import bot.reminder.discord.slash.SlashAdmin
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.build.Commands

fun main() {
    val jda = JDABuilder.createDefault("")
        .setActivity(Activity.playing("열심히 일"))
        .build()

    jda.presence.setStatus(OnlineStatus.ONLINE)
    jda.addEventListener(SlashAdmin)

    jda.updateCommands().addCommands(
        Commands.slash("ping", "What will the bot say?"),
    ).queue();
}
