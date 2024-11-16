package xyz.caelan.bot.util.ticket.interact;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;

public class ConfirmCloseButton {
    public static void execute(ButtonInteractionEvent event) {
        event.deferReply().queue();

        TextChannel textChannel = event.getChannel().asTextChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Ticket");
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setFooter("SwiftServicesX");
        embedBuilder.setDescription("Closing the ticket...");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();

        String channelOwner = textChannel.getName().split("-")[1];
        textChannel.getMemberPermissionOverrides().forEach(permissionOverride -> permissionOverride.delete().queue());
        textChannel.getManager().setName("closed-ticket-" + channelOwner).queue();
        event.getHook().sendMessage("The ticket has been closed.").queue();
    }
}
