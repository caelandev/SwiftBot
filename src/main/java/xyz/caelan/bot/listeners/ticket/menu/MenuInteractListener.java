package xyz.caelan.bot.listeners.ticket.menu;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import xyz.caelan.bot.menu.TicketSelectMenu;

public class MenuInteractListener extends ListenerAdapter {
    @Override
    public void onStringSelectInteraction(@NotNull final StringSelectInteractionEvent event) {
        switch (event.getSelectMenu().getId().toLowerCase()) {
            case "selectticket" -> TicketSelectMenu.execute(event);
            default -> event.reply("This menu doesn't exist").setEphemeral(true).queue();

        }
    }
}
