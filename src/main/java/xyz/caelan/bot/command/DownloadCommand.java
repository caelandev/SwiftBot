package xyz.caelan.bot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.utils.FileUpload;

import java.awt.*;
import java.io.File;

public class DownloadCommand {

    /*
    * This is something i wrote for my product which used to fetch the file from the path
    * and send it to the the sender. Since i am releasing this you can modify this according
    * to your needs.
     */

    private static final String PATH = "your download path";
    private static final long ROLE = 14556505103913012L; // your role id

    public static void execute(String messageContent, TextChannel channel, Member member) {
        if (messageContent == null || channel == null || member == null) {
            System.out.println("null fine");
            return;
        }

        if (member.getRoles().stream().noneMatch(role -> role.getIdLong() == ROLE)) {
            channel.sendMessage("No permission").queue();
            return;
        }

        if (messageContent.startsWith("!download")) {

            String[] args = messageContent.split(" ");
            if (args.length > 1 && "PratSpigot".equalsIgnoreCase(args[1])) {

                File file = new File(PATH);

                if (file.exists()) {
                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("Something Download")
                            .setDescription("You requested something:")
                            .addField("Product", "Something", false)
                            .addField("File Name", "Something", false)
                            .setColor(Color.MAGENTA)
                            .setFooter("YourOrganization | Product Download", null);

                    channel.sendMessageEmbeds(embedBuilder.build())
                            .addFiles(FileUpload.fromData(file, "something.zip"))
                            .queue();
                } else {
                    channel.sendMessage("The file could not be found at the specified path " + PATH)
                            .queue();
                }
            } else {
                System.out.println("Unknown product or wrong command");
                channel.sendMessage("Unknown product. Please try again with a valid product.")
                        .queue();
            }
        }
    }
}
