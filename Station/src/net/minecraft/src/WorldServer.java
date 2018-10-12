/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.File;

public class WorldServer
extends World {
    public hr u;

    public WorldServer(File file, String string) {
        super(file, string);
        this.c = false;
    }

    protected bf a(File file) {
        this.u = new hr(this, new ec(file, true), new hi(this, this.p));
        return this.u;
    }

    public boolean b(int n2, int n3, int n4, int n5, int n6) {
        int n7 = n2 - this.l;
        int n8 = n4 - this.n;
        if (n7 < 0) {
            n7 = - n7;
        }
        if (n8 < 0) {
            n8 = - n8;
        }
        if (n7 > n8) {
            n8 = n7;
        }
        if (n8 < 16) {
            return false;
        }
        return super.b(n2, n3, n4, n5, n6);
    }

    public boolean d(int n2, int n3, int n4, int n5) {
        int n6 = n2 - this.l;
        int n7 = n4 - this.n;
        if (n6 < 0) {
            n6 = - n6;
        }
        if (n7 < 0) {
            n7 = - n7;
        }
        if (n6 > n7) {
            n7 = n6;
        }
        if (n7 < 16) {
            return false;
        }
        return super.d(n2, n3, n4, n5);
    }
}

