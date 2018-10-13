package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hk
extends en {
    public hk(int n2, int n3) {
        super(n2);
        this.aR = 1;
        this.aS = 32 << n3;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.a(n2, n3, n4);
        hz hz2 = dp2.c(n2, n3 + 1, n4);
        if (!hz2.a() && n6 == Block.u.ba || n6 == Block.v.ba) {
            Block et2 = Block.aA;
            dp2.a((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, et2.bj.c(), (et2.bj.a() + 1.0f) / 2.0f, et2.bj.b() * 0.8f);
            dp2.d(n2, n3, n4, et2.ba);
            gc2.a(1);
            if (dp2.k.nextInt(8) == 0 && n6 == Block.u.ba) {
                int n7 = 1;
                for (int i2 = 0; i2 < n7; ++i2) {
                    float f2 = 0.7f;
                    float f3 = dp2.k.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                    float f4 = 1.2f;
                    float f5 = dp2.k.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                    fa fa2 = new fa(dp2, (float)n2 + f3, (float)n3 + f4, (float)n4 + f5, new gc(en.Q));
                    fa2.ac = 10;
                    dp2.a(fa2);
                }
            }
            return true;
        }
        return false;
    }
}

