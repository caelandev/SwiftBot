package xyz.caelan.bot.listeners.general;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import xyz.caelan.bot.command.DownloadCommand;

public class MessageReceiveEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.TEXT) && !event.getAuthor().isBot()) {
            Message message = event.getMessage();
            Member member = event.getMember();
            TextChannel channel = (TextChannel) event.getChannel();

            DownloadCommand.execute(message.getContentRaw(), channel, member);
        }
    }
}
