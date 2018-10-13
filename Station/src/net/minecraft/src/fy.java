package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class fy
extends ay {
    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < 20; ++i2) {
            int n5;
            int n6;
            int n7 = n2 + random.nextInt(4) - random.nextInt(4);
            if (dp2.a(n7, n5 = n3, n6 = n4 + random.nextInt(4) - random.nextInt(4)) != 0 || dp2.c(n7 - 1, n5 - 1, n6) != hz.f && dp2.c(n7 + 1, n5 - 1, n6) != hz.f && dp2.c(n7, n5 - 1, n6 - 1) != hz.f && dp2.c(n7, n5 - 1, n6 + 1) != hz.f) continue;
            int n8 = 2 + random.nextInt(random.nextInt(3) + 1);
            for (int i3 = 0; i3 < n8; ++i3) {
                if (!Block.aX.f(dp2, n7, n5 + i3, n6)) continue;
                dp2.a(n7, n5 + i3, n6, Block.aX.ba);
            }
        }
        return true;
    }
}

