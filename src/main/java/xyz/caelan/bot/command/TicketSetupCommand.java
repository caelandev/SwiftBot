package xyz.caelan.bot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import xyz.caelan.bot.util.ticket.menu.Menu;

import java.awt.*;

public class TicketSetupCommand {
    public static void execute(final SlashCommandInteractionEvent event) {
        final Member member = event.getMember();
        assert member != null;

        if (member.getPermissions().contains(Permission.ADMINISTRATOR)) {
            final EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Ticket");
            embedBuilder.setColor(Color.GRAY);
            embedBuilder.setFooter("SwiftServicesX");
            embedBuilder.setDescription("Select any ticket type from the drop down list below to create a ticket.");
            event.getChannel().sendMessageEmbeds(embedBuilder.build()).setActionRow(Menu.ticketMenu()).queue();
            event.reply("Panel sent").setEphemeral(true).queue();
            return;
        }
        event.reply("No permission").setEphemeral(true).queue();
    }

}
