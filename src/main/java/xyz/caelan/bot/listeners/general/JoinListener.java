package xyz.caelan.bot.listeners.general;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        User user = event.getUser();
        String username = user.getGlobalName();
        String avatarUrl = user.getAvatarUrl();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Welcome " + username + "!")
                .setColor(Color.GRAY)
                .setThumbnail(avatarUrl)
                .setDescription("We're happy to have you here! 🎉")
                .addField("Name:", username, false)
                .addField("Total Members:", String.valueOf(event.getGuild().getMemberCount()), true)
                .appendDescription("\n\n:wave: Welcome aboard! :smile:")
                .setFooter("Joined the server", avatarUrl);

        String channelId = "1276853290604171360";
        if (event.getGuild().getTextChannelById(channelId) != null) {
            event.getGuild().getTextChannelById(channelId)
                    .sendMessageEmbeds(embed.build())
                    .queue(
                            success -> System.out.println("Welcome message sent successfully!"),
                            error -> System.err.println("Failed to send welcome message: " + error.getMessage())
                    );
        } else {
            System.err.println("Channel not found with ID: " + channelId);
        }
    }
}
