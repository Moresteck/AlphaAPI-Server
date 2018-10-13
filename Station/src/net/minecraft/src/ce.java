package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class ce
extends en {
    public int a;

    public ce(int n2, int n3) {
        super(n2);
        this.aR = 1;
        this.a = n3;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.a(n2, n3, n4);
        if (n6 == Block.aG.ba) {
            dp2.a(new EntityMinecart(dp2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, this.a));
            --gc2.a;
            return true;
        }
        return false;
    }
}

