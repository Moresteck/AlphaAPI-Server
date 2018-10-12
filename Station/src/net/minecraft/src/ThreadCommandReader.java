/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import net.minecraft.server.MinecraftServer;

public class ThreadCommandReader
extends Thread {
    final MinecraftServer mcServer;

    public ThreadCommandReader(MinecraftServer minecraftserver) {
        this.mcServer = minecraftserver;
    }

    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            while (!this.mcServer.serverStopped && MinecraftServer.a(this.mcServer) && (string = bufferedReader.readLine()) != null) {
                this.mcServer.a(string);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

