package xyz.caelan.bot.menu.option;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import xyz.caelan.bot.util.ticket.TicketType;
import xyz.caelan.bot.util.ticket.TicketUtil;

public class Purchase {

    public static void execute(StringSelectInteractionEvent event) {
        TicketUtil.open(TicketType.PURCHASE, event);
    }
}
