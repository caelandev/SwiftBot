package xyz.caelan.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import xyz.caelan.bot.util.Secret;
import xyz.caelan.bot.listeners.command.SlashCommandListener;
import xyz.caelan.bot.listeners.general.JoinListener;
import xyz.caelan.bot.listeners.general.MessageReceiveEvent;
import xyz.caelan.bot.listeners.ticket.ButtonInteractListener;
import xyz.caelan.bot.listeners.ticket.menu.MenuInteractListener;

public class Swift {

    private static JDA jda;

    public static void main(final String[] args) throws InterruptedException {
        jda = JDABuilder.createDefault(Secret.getToken())
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.STICKER)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("Watching your organization"))
                .addEventListeners(new SlashCommandListener())
                .addEventListeners(new MenuInteractListener())
                .addEventListeners(new ButtonInteractListener())
                .addEventListeners(new MessageReceiveEvent())
                .addEventListeners(new JoinListener())
                .build();

        jda.awaitReady();
        System.out.println("Bot started");
        registerCommands(""); // enter your guild id here
    }

    public static void registerCommands(String guildId) {
        Guild guild = jda.getGuildById(guildId);
        if (guild != null) {
            guild.updateCommands().addCommands(
                    Commands.slash("ticketsetup", "Sets up the ticket panel")
            ).queue(
                    success -> System.out.println("Command reg"),
                    error -> System.err.println("Failed: " + error.getMessage())
            );
        }
    }
}
