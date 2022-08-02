package dev.sim0n.stressbot.packet.internal.play.serverbound;

import dev.sim0n.stressbot.packet.AbstractPacket;
import dev.sim0n.stressbot.util.PacketBuffer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sim0n
 */
@Getter @Setter
@NoArgsConstructor
public class CConfirmTransaction extends AbstractPacket {
    private int windowId;
    private short uid;
    private boolean accepted;

    @Override
    public void decode(PacketBuffer buffer) {

    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeByte(this.windowId);
        buffer.writeShort(this.uid);
        buffer.writeBoolean(this.accepted);
    }
}
