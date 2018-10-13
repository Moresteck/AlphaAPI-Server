/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class PlayerManager {
    private List players = new ArrayList();
    private PlayerHash playerInstances = new PlayerHash();
    private List playerInstancesToUpdate = new ArrayList();
    private MinecraftServer mcServer;

    public PlayerManager(MinecraftServer minecraftserver) {
        this.mcServer = minecraftserver;
    }

    public void a() {
        for (int i2 = 0; i2 < this.playerInstancesToUpdate.size(); ++i2) {
            ((ab)this.playerInstancesToUpdate.get(i2)).a();
        }
        this.playerInstancesToUpdate.clear();
    }

    private ab a(int n2, int n3, boolean bl2) {
        long l2 = (long)n2 + Integer.MAX_VALUE | (long)n3 + Integer.MAX_VALUE << 32;
        ab ab2 = (ab)this.playerInstances.a(l2);
        if (ab2 == null && bl2) {
            ab2 = new ab(this, n2, n3);
            this.playerInstances.a(l2, ab2);
        }
        return ab2;
    }

    public void a(int n2, int n3, int n4) {
        int n5 = n2 >> 4;
        int n6 = n4 >> 4;
        ab ab2 = this.a(n5, n6, false);
        if (ab2 != null) {
            ab2.a(n2 & 15, n3, n4 & 15);
        }
    }

    public void a(EntityPlayerMP entityplayermp) {
        this.mcServer.configManager.a(new Packet3Chat("\u00a7e" + entityplayermp.ap + " joined the game."));
        int n2 = (int)entityplayermp.k >> 4;
        int n3 = (int)entityplayermp.m >> 4;
        entityplayermp.ad = entityplayermp.k;
        entityplayermp.ae = entityplayermp.m;
        for (int i2 = n2 - 10; i2 <= n2 + 10; ++i2) {
            for (int i3 = n3 - 10; i3 <= n3 + 10; ++i3) {
                this.a(i2, i3, true).a(entityplayermp);
            }
        }
        this.players.add(entityplayermp);
    }

    public void b(EntityPlayerMP entityplayermp) {
        this.mcServer.configManager.a(new Packet3Chat("\u00a7e" + entityplayermp.ap + " left the game."));
        int n2 = (int)entityplayermp.k >> 4;
        int n3 = (int)entityplayermp.m >> 4;
        for (int i2 = n2 - 10; i2 <= n2 + 10; ++i2) {
            for (int i3 = n3 - 10; i3 <= n3 + 10; ++i3) {
                ab ab2 = this.a(i2, i3, false);
                if (ab2 == null) continue;
                ab2.b(entityplayermp);
            }
        }
        this.players.remove(entityplayermp);
    }

    private boolean a(int n2, int n3, int n4, int n5) {
        int n6 = n2 - n4;
        int n7 = n3 - n5;
        if (n6 < -10 || n6 > 10) {
            return false;
        }
        if (n7 < -10 || n7 > 10) {
            return false;
        }
        return true;
    }

    public void c(EntityPlayerMP entityplayermp) {
        int n2 = (int)entityplayermp.k >> 4;
        int n3 = (int)entityplayermp.m >> 4;
        double d2 = entityplayermp.ad - entityplayermp.k;
        double d3 = entityplayermp.ae - entityplayermp.m;
        double d4 = d2 * d2 + d3 * d3;
        if (d4 < 64.0) {
            return;
        }
        int n4 = (int)entityplayermp.ad >> 4;
        int n5 = (int)entityplayermp.ae >> 4;
        int n6 = n2 - n4;
        int n7 = n3 - n5;
        if (n6 == 0 && n7 == 0) {
            return;
        }
        for (int i2 = n2 - 10; i2 <= n2 + 10; ++i2) {
            for (int i3 = n3 - 10; i3 <= n3 + 10; ++i3) {
                ab ab2;
                if (!this.a(i2, i3, n4, n5)) {
                    this.a(i2, i3, true).a(entityplayermp);
                }
                if (this.a(i2 - n6, i3 - n7, n2, n3) || (ab2 = this.a(i2 - n6, i3 - n7, false)) == null) continue;
                ab2.b(entityplayermp);
            }
        }
        entityplayermp.ad = entityplayermp.k;
        entityplayermp.ae = entityplayermp.m;
    }

    public int b() {
        return 144;
    }

    static /* synthetic */ MinecraftServer a(PlayerManager playerManager) {
        return playerManager.mcServer;
    }

    static /* synthetic */ PlayerHash b(PlayerManager playerManager) {
        return playerManager.playerInstances;
    }

    static /* synthetic */ List c(PlayerManager playerManager) {
        return playerManager.playerInstancesToUpdate;
    }
}

