/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ThreadShutdown
extends Thread {
    final MinecraftServer mcServer;

    public ThreadShutdown(MinecraftServer minecraftserver) {
        this.mcServer = minecraftserver;
    }

    public void run() {
        if (MinecraftServer.a(this.mcServer)) {
            MinecraftServer.log.info("Shutdown intercepted");
            MinecraftServer.a(this.mcServer, false);
            do {
                try {
                    Thread.sleep(10000L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } while (!this.mcServer.serverStopped);
        }
    }
}

