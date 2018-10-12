/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import net.minecraft.server.MinecraftServer;

public final class ThreadServerApplication
extends Thread {
    final /* synthetic */ MinecraftServer mcServer;

    public ThreadServerApplication(String string, MinecraftServer minecraftServer) {
        super(string);
        this.mcServer = minecraftServer;
    }

    public void run() {
        this.mcServer.run();
    }
}

