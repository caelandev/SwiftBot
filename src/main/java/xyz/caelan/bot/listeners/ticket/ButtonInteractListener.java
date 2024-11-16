package xyz.caelan.bot.listeners.ticket;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import xyz.caelan.bot.util.ticket.interact.CloseButton;
import xyz.caelan.bot.util.ticket.interact.ConfirmCloseButton;

public class ButtonInteractListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        switch (event.getButton().getId()) {
            case "closeticket":
                CloseButton.execute(event);
                break;
            case "confirmCloseTicket":
                ConfirmCloseButton.execute(event);
                break;
            default:
                event.reply("This button does not exist.").setEphemeral(true).queue();
                break;
        }
    }
}
