/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import net.minecraft.server.MinecraftServer;

public class dr
implements ba {
    private MinecraftServer a;

    public dr(MinecraftServer minecraftServer) {
        this.a = minecraftServer;
    }

    public void a(String string, double d2, double d3, double d4, double d5, double d6, double d7) {
    }

    public void a(Entity db2) {
        this.a.entityTracker.a(db2);
    }

    public void b(Entity db2) {
        this.a.entityTracker.b(db2);
    }

    public void a(String string, double d2, double d3, double d4, float f2, float f3) {
    }

    public void a(int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    public void a() {
    }

    public void a(int n2, int n3, int n4) {
        this.a.configManager.a(n2, n3, n4);
    }

    public void a(String string, int n2, int n3, int n4) {
    }
}

