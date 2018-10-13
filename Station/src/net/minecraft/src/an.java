package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class an
extends ay {
    private int a;

    public an(int n2) {
        this.a = n2;
    }

    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < 64; ++i2) {
            int n5;
            int n6;
            int n7 = n2 + random.nextInt(8) - random.nextInt(8);
            if (dp2.a(n7, n5 = n3 + random.nextInt(4) - random.nextInt(4), n6 = n4 + random.nextInt(8) - random.nextInt(8)) != 0 || !((gb)Block.n[this.a]).f(dp2, n7, n5, n6)) continue;
            dp2.a(n7, n5, n6, this.a);
        }
        return true;
    }
}

