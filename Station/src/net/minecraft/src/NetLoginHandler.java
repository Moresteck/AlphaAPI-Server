/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetLoginHandler
extends NetHandler {
    public static Logger log = Logger.getLogger("Minecraft");
    public aw b;
    public boolean c = false;
    private MinecraftServer mcServer;
    private int e = 0;
    private String f = null;

    public NetLoginHandler(MinecraftServer minecraftServer, Socket socket, String string) {
        this.mcServer = minecraftServer;
        this.b = new aw(socket, string, this);
    }

    public void a() {
        if (this.e++ == 100) {
            this.b("Took too long to log in");
        } else {
            this.b.a();
        }
    }

    public void b(String string) {
        log.info("Disconnecting " + this.b() + ": " + string);
        this.b.a(new Packet255KickDisconnect(string));
        this.b.c();
        this.c = true;
    }

    public void a(Packet1Login x2) {
        this.f = x2.b;
        if (x2.a != 13) {
            this.b("Outdated client!");
            return;
        }
        EntityPlayerMP dq2 = this.mcServer.configManager.a(this, x2.b, x2.c);
        if (dq2 != null) {
            log.info(this.b() + " logged in");
            hm hm2 = new hm(this.mcServer, this.b, dq2);
            hm2.b(new Packet1Login("", "", 0));
            this.mcServer.configManager.a(dq2);
            hm2.a(dq2.k, dq2.l, dq2.m, dq2.q, dq2.r);
            this.mcServer.networkListener.a(hm2);
        }
        this.c = true;
    }

    public void a(String string) {
        log.info(this.b() + " lost connection");
        this.c = true;
    }

    public void a(Packet ha2) {
        this.b("Protocol error");
    }

    public String b() {
        if (this.f != null) {
            return this.f + " [" + this.b.b().toString() + "]";
        }
        return this.b.b().toString();
    }
}

