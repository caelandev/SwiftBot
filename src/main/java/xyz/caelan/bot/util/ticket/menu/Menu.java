package xyz.caelan.bot.util.ticket.menu;

import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class Menu {
    public static StringSelectMenu ticketMenu() {
        return StringSelectMenu.create("selectticket")
                .addOption(
                        "purchase",
                        "purchase",
                        "Open a ticket to purchase a product"
                )
                .addOption(
                        "help",
                        "help",
                        "Open a ticket for help or questions"
                )
                .build();
    }
}
