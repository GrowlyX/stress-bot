package dev.sim0n.stressbot.bot;

import dev.sim0n.stressbot.bot.internal.PlayerBot;
import dev.sim0n.stressbot.util.PacketBuffer;
import io.netty.channel.ChannelHandlerContext;

import java.util.function.Consumer;

/**
 * @author sim0n
 */
public enum SimpleBotFactory implements BotFactory<PacketBuffer> {
    INSTANCE;

    private final BotFactory<PacketBuffer> innerBotFactory;

    SimpleBotFactory() {
        this.innerBotFactory = new PartitioningBotFactory<>(PlayerBot::new);
    }

    @Override
    public Bot makeBot(Consumer<ChannelHandlerContext> connectAction, Consumer<ChannelHandlerContext> disconnectAction, BotRepository repo) {
        return this.innerBotFactory.makeBot(connectAction, disconnectAction, repo);
    }
}
