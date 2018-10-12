/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hl
extends ay {
    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10 = random.nextInt(3) + 4;
        boolean bl2 = true;
        if (n3 < 1 || n3 + n10 + 1 > 128) {
            return false;
        }
        for (n5 = n3; n5 <= n3 + 1 + n10; ++n5) {
            n8 = 1;
            if (n5 == n3) {
                n8 = 0;
            }
            if (n5 >= n3 + 1 + n10 - 2) {
                n8 = 2;
            }
            for (n7 = n2 - n8; n7 <= n2 + n8 && bl2; ++n7) {
                for (n9 = n4 - n8; n9 <= n4 + n8 && bl2; ++n9) {
                    if (n5 >= 0 && n5 < 128) {
                        n6 = dp2.a(n7, n5, n9);
                        if (n6 == 0 || n6 == Block.K.ba) continue;
                        bl2 = false;
                        continue;
                    }
                    bl2 = false;
                }
            }
        }
        if (!bl2) {
            return false;
        }
        n5 = dp2.a(n2, n3 - 1, n4);
        if (n5 != Block.u.ba && n5 != Block.v.ba || n3 >= 128 - n10 - 1) {
            return false;
        }
        dp2.a(n2, n3 - 1, n4, Block.v.ba);
        for (n8 = n3 - 3 + n10; n8 <= n3 + n10; ++n8) {
            n7 = n8 - (n3 + n10);
            n9 = 1 - n7 / 2;
            for (n6 = n2 - n9; n6 <= n2 + n9; ++n6) {
                int n11 = n6 - n2;
                for (int i2 = n4 - n9; i2 <= n4 + n9; ++i2) {
                    int n12 = i2 - n4;
                    if (Math.abs(n11) == n9 && Math.abs(n12) == n9 && (random.nextInt(2) == 0 || n7 == 0) || Block.p[dp2.a(n6, n8, i2)]) continue;
                    dp2.a(n6, n8, i2, Block.K.ba);
                }
            }
        }
        for (n8 = 0; n8 < n10; ++n8) {
            n7 = dp2.a(n2, n3 + n8, n4);
            if (n7 != 0 && n7 != Block.K.ba) continue;
            dp2.a(n2, n3 + n8, n4, Block.J.ba);
        }
        return true;
    }
}

