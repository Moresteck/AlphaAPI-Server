/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ee
extends ay {
    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < 10; ++i2) {
            int n5;
            int n6;
            int n7 = n2 + random.nextInt(8) - random.nextInt(8);
            if (dp2.a(n7, n5 = n3 + random.nextInt(4) - random.nextInt(4), n6 = n4 + random.nextInt(8) - random.nextInt(8)) != 0) continue;
            int n8 = 1 + random.nextInt(random.nextInt(3) + 1);
            for (int i3 = 0; i3 < n8; ++i3) {
                if (!Block.aV.f(dp2, n7, n5 + i3, n6)) continue;
                dp2.a(n7, n5 + i3, n6, Block.aV.ba);
            }
        }
        return true;
    }
}

