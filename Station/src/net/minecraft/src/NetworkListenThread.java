/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetworkListenThread {
    public static Logger log = Logger.getLogger("Minecraft");
    private ServerSocket c;
    private Thread d;
    public volatile boolean b = false;
    private int e = 0;
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private MinecraftServer h;

    public NetworkListenThread(MinecraftServer minecraftServer, InetAddress inetAddress, int n2) throws IOException {
        this.h = minecraftServer;
        this.c = new ServerSocket(n2, 0, inetAddress);
        this.c.setPerformancePreferences(0, 2, 1);
        this.b = true;
        this.d = new cn(this, "Listen thread", minecraftServer);
        this.d.start();
    }

    public void a(hm hm2) {
        this.g.add(hm2);
    }

    private void a(NetLoginHandler ek2) {
        if (ek2 == null) {
            throw new IllegalArgumentException("Got null pendingconnection!");
        }
        this.f.add(ek2);
    }

    public void a() {
        for (int i = 0; i < this.f.size(); ++i) {
            NetLoginHandler dy2 = (NetLoginHandler)this.f.get(i);
            dy2.a();
            if (!dy2.c) continue;
            this.f.remove(i--);
        }
        for (int i = 0; i < this.g.size(); ++i) {
            hm dy2 = (hm)this.g.get(i);
            dy2.a();
            if (!dy2.c) continue;
            this.g.remove(i--);
        }
    }

    static /* synthetic */ ServerSocket a(NetworkListenThread cv2) {
        return cv2.c;
    }

    static /* synthetic */ int b(NetworkListenThread cv2) {
        return cv2.e++;
    }

    static /* synthetic */ void a(NetworkListenThread cv2, NetLoginHandler ek2) {
        cv2.a(ek2);
    }
}

