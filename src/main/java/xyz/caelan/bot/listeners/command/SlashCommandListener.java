package xyz.caelan.bot.listeners.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import xyz.caelan.bot.command.TicketSetupCommand;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName().toLowerCase()) {
            case "ticketsetup" -> TicketSetupCommand.execute(event);
            default -> event.reply("This command doesn't exist.").setEphemeral(true).queue();
        }
    }
}
