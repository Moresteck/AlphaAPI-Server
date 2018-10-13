package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.IOException;
import java.net.Socket;
import net.minecraft.server.MinecraftServer;

class cn
extends Thread {
    final /* synthetic */ MinecraftServer a;
    final /* synthetic */ NetworkListenThread b;

    cn(NetworkListenThread cv2, String string, MinecraftServer minecraftServer) {
    	super(string);
        this.b = cv2;
        this.a = minecraftServer;
    }

    public void run() {
        while (this.b.b) {
            try {
                Socket socket = NetworkListenThread.a(this.b).accept();
                if (socket == null) continue;
                NetLoginHandler ek2 = new NetLoginHandler(this.a, socket, "Connection #" + NetworkListenThread.b(this.b));
                NetworkListenThread.a(this.b, ek2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

