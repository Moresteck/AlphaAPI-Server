package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class fr
extends en {
    public fr(int n2) {
        super(n2);
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            --n3;
        }
        if (n5 == 1) {
            ++n3;
        }
        if (n5 == 2) {
            --n4;
        }
        if (n5 == 3) {
            ++n4;
        }
        if (n5 == 4) {
            --n2;
        }
        if (n5 == 5) {
            ++n2;
        }
        if (dp2.a(n2, n3, n4) != 0) {
            return false;
        }
        if (Block.av.a(dp2, n2, n3, n4)) {
            --gc2.a;
            dp2.d(n2, n3, n4, Block.av.ba);
        }
        return true;
    }
}

