package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.server.MinecraftServer;

final class q
extends WindowAdapter {
    final /* synthetic */ MinecraftServer a;

    q(MinecraftServer minecraftServer) {
        this.a = minecraftServer;
    }

    public void windowClosing(WindowEvent windowEvent) {
        this.a.a();
        while (!this.a.g) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        System.exit(0);
    }
}

