/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ServerConfigurationManager {
    public static Logger log = Logger.getLogger("Minecraft");
    public List playerEntities = new ArrayList();
    private MinecraftServer mcServer;
    private PlayerManager playerManager;
    private int maxPlayers = 20;

    public ServerConfigurationManager(MinecraftServer minecraftServer) {
        this.mcServer = minecraftServer;
        this.playerManager = new PlayerManager(minecraftServer);
    }

    public int a() {
        return this.playerManager.b();
    }

    public void a(EntityPlayerMP entityplayermp) {
        this.playerEntities.add(entityplayermp);
        this.mcServer.WorldMngr.a(entityplayermp);
        this.playerManager.a(entityplayermp);
    }

    public void b(EntityPlayerMP entityplayermp) {
        this.playerManager.c(entityplayermp);
    }

    public void c(EntityPlayerMP entityplayermp) {
        this.mcServer.WorldMngr.d(entityplayermp);
        this.playerEntities.remove(entityplayermp);
        this.playerManager.b(entityplayermp);
    }

    public EntityPlayerMP a(NetLoginHandler ek2, String string, String string2) {
        if (this.playerEntities.size() >= this.maxPlayers) {
            ek2.b("The server is full!");
            return null;
        }
        for (int i2 = 0; i2 < this.playerEntities.size(); ++i2) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntities.get(i2);
            if (!entityplayermp.ap.equalsIgnoreCase(string)) continue;
            entityplayermp.a.b("You logged in from another location");
        }
        return new EntityPlayerMP(this.mcServer, this.mcServer.WorldMngr, string, new hw(this.mcServer.WorldMngr));
    }

    public void b() {
        this.playerManager.a();
    }

    public void a(int n2, int n3, int n4) {
        this.playerManager.a(n2, n3, n4);
    }

    public void a(Packet ha2) {
        for (int i2 = 0; i2 < this.playerEntities.size(); ++i2) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntities.get(i2);
            entityplayermp.a.b(ha2);
        }
    }

    public String c() {
        String string = "";
        for (int i2 = 0; i2 < this.playerEntities.size(); ++i2) {
            if (i2 > 0) {
                string = string + ", ";
            }
            string = string + ((EntityPlayerMP)this.playerEntities.get((int)i2)).ap;
        }
        return string;
    }
}

