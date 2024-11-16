package xyz.caelan.bot.menu;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import xyz.caelan.bot.menu.option.Help;
import xyz.caelan.bot.menu.option.Purchase;

public class TicketSelectMenu {

    public static void execute(StringSelectInteractionEvent event) {
        if (event.getValues().isEmpty()) {
            event.reply("No menu option selected.").setEphemeral(true).queue();
            return;
        }
        String selectedOption = event.getValues().get(0).toLowerCase();

        switch (selectedOption) {
            case "help" -> Help.execute(event);
            case "purchase" -> Purchase.execute(event);
            default -> event.reply("This menu doesn't exist").setEphemeral(true).queue();
        }
    }
}
