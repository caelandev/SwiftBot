package xyz.caelan.bot.util.ticket.interact;

import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class TicketButton {

    public static Button closeTicket() {
        return Button.danger("closeticket", "Close the ticket");
    }

    public static Button confirmClose() {
        return Button.danger("confirmCloseTicket", "Confirm closing the ticket");
    }
}
