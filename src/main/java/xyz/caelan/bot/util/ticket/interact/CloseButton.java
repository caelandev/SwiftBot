package xyz.caelan.bot.util.ticket.interact;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;

public class CloseButton {
    public static void execute(ButtonInteractionEvent event) {
        event.deferReply().queue();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Close Ticket Confirmation");
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setFooter("SwiftServicesX");
        embedBuilder.setDescription("Are you sure you want to close this ticket?");

        event.getChannel().sendMessageEmbeds(embedBuilder.build())
                .setActionRow(TicketButton.confirmClose())
                .queue();
    }
}
