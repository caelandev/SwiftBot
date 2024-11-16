package xyz.caelan.bot.util.ticket;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import xyz.caelan.bot.util.ticket.interact.TicketButton;

import java.awt.*;
import java.util.EnumSet;
import java.util.List;

public class TicketUtil {

    public static void open(final TicketType ticketType, final StringSelectInteractionEvent event) {
        final Guild guild = event.getGuild();
        final Member member = event.getMember();
        final List<Role> roles = member.getRoles();
        final Role ticketRole = guild.getRoleById("1302302864097677404");
        final Category category = guild.getCategoryById("1302157868648103957");
        final EnumSet<Permission> channelPermission = EnumSet.of(Permission.VIEW_CHANNEL);

        if (roles.contains(ticketRole)) {
            event.reply("You cannot open a support ticket").setEphemeral(true).queue();
            return;
        }

        event.reply("Creating a ticket...").setEphemeral(true).queue();

        final String ticketTypeString = (ticketType == TicketType.HELP ? "help" : "purchase");

        final EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Ticket")
                .setColor(Color.GRAY)
                .setFooter("SwiftServicesX")
                .setDescription("Thank you for making a ticket " + "<@" + member.getUser().getId() + ">" + ", The staff will guide you as soon as possible.");

        guild.createTextChannel(ticketTypeString + "-" + member.getId(), category)
                .addPermissionOverride(member, channelPermission, null)
                .addPermissionOverride(guild.getPublicRole(), null, channelPermission)
                .addPermissionOverride(ticketRole, channelPermission, null)
                .complete()
                .sendMessageEmbeds(embedBuilder.build())
                .setActionRow(TicketButton.closeTicket())
                .queue();
        event.getHook().editOriginal("Ticket created.").queue();
    }

}
