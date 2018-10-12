/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.List;
import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;

public class PlayerListBox
extends JList
implements IUpdatePlayerListBox {
    private MinecraftServer mcServer;
    private int updateCounter = 0;

    public PlayerListBox(MinecraftServer minecraftserver) {
        this.mcServer = minecraftserver;
        minecraftserver.addPlayerListBox(this);
    }

    public void a() {
        if (this.updateCounter++ % 20 == 0) {
            Vector<String> vector = new Vector<String>();
            for (int i2 = 0; i2 < this.mcServer.configManager.playerEntities.size(); ++i2) {
                vector.add(((EntityPlayerMP)this.mcServer.configManager.playerEntities.get((int)i2)).ap);
            }
            this.setListData(vector);
        }
    }
}

