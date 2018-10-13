package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class dc
extends ay {
    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        int n5;
        Material hz2;
        int n6;
        int n7;
        int n8 = 3;
        int n9 = random.nextInt(2) + 2;
        int n10 = random.nextInt(2) + 2;
        int n11 = 0;
        for (n7 = n2 - n9 - 1; n7 <= n2 + n9 + 1; ++n7) {
            for (n6 = n3 - 1; n6 <= n3 + n8 + 1; ++n6) {
                for (n5 = n4 - n10 - 1; n5 <= n4 + n10 + 1; ++n5) {
                    hz2 = dp2.c(n7, n6, n5);
                    if (n6 == n3 - 1 && !hz2.a()) {
                        return false;
                    }
                    if (n6 == n3 + n8 + 1 && !hz2.a()) {
                        return false;
                    }
                    if (n7 != n2 - n9 - 1 && n7 != n2 + n9 + 1 && n5 != n4 - n10 - 1 && n5 != n4 + n10 + 1 || n6 != n3 || dp2.a(n7, n6, n5) != 0 || dp2.a(n7, n6 + 1, n5) != 0) continue;
                    ++n11;
                }
            }
        }
        if (n11 < 1 || n11 > 5) {
            return false;
        }
        for (n7 = n2 - n9 - 1; n7 <= n2 + n9 + 1; ++n7) {
            for (n6 = n3 + n8; n6 >= n3 - 1; --n6) {
                for (n5 = n4 - n10 - 1; n5 <= n4 + n10 + 1; ++n5) {
                    if (n7 == n2 - n9 - 1 || n6 == n3 - 1 || n5 == n4 - n10 - 1 || n7 == n2 + n9 + 1 || n6 == n3 + n8 + 1 || n5 == n4 + n10 + 1) {
                        if (n6 >= 0 && !dp2.c(n7, n6 - 1, n5).a()) {
                            dp2.d(n7, n6, n5, 0);
                            continue;
                        }
                        if (!dp2.c(n7, n6, n5).a()) continue;
                        if (n6 == n3 - 1 && random.nextInt(4) != 0) {
                            dp2.d(n7, n6, n5, Block.ao.ba);
                            continue;
                        }
                        dp2.d(n7, n6, n5, Block.w.ba);
                        continue;
                    }
                    dp2.d(n7, n6, n5, 0);
                }
            }
        }
        block6 : for (n7 = 0; n7 < 2; ++n7) {
            for (n6 = 0; n6 < 3; ++n6) {
                int n12;
                n5 = n2 + random.nextInt(n9 * 2 + 1) - n9;
                if (dp2.a(n5, (int)(hz2 = (Material)n3), n12 = n4 + random.nextInt(n10 * 2 + 1) - n10) != 0) continue;
                int n13 = 0;
                if (dp2.c(n5 - 1, (int)hz2, n12).a()) {
                    ++n13;
                }
                if (dp2.c(n5 + 1, (int)hz2, n12).a()) {
                    ++n13;
                }
                if (dp2.c(n5, (int)hz2, n12 - 1).a()) {
                    ++n13;
                }
                if (dp2.c(n5, (int)hz2, n12 + 1).a()) {
                    ++n13;
                }
                if (n13 != 1) continue;
                dp2.d(n5, (int)hz2, n12, Block.au.ba);
                gn gn2 = (gn)dp2.k(n5, (int)hz2, n12);
                for (int i2 = 0; i2 < 8; ++i2) {
                    gc gc2 = this.a(random);
                    if (gc2 == null) continue;
                    gn2.a(random.nextInt(gn2.a()), gc2);
                }
                continue block6;
            }
        }
        dp2.d(n2, n3, n4, Block.as.ba);
        bm bm2 = (bm)dp2.k(n2, n3, n4);
        bm2.f = this.b(random);
        return true;
    }

    private gc a(Random random) {
        int n2 = random.nextInt(11);
        if (n2 == 0) {
            return new gc(en.ay);
        }
        if (n2 == 1) {
            return new gc(en.m, random.nextInt(4) + 1);
        }
        if (n2 == 2) {
            return new gc(en.S);
        }
        if (n2 == 3) {
            return new gc(en.R, random.nextInt(4) + 1);
        }
        if (n2 == 4) {
            return new gc(en.K, random.nextInt(4) + 1);
        }
        if (n2 == 5) {
            return new gc(en.I, random.nextInt(4) + 1);
        }
        if (n2 == 6) {
            return new gc(en.au);
        }
        if (n2 == 7 && random.nextInt(100) == 0) {
            return new gc(en.ar);
        }
        if (n2 == 8 && random.nextInt(2) == 0) {
            return new gc(en.aA, random.nextInt(4) + 1);
        }
        if (n2 == 9 && random.nextInt(10) == 0) {
            return new gc(en.c[en.aO.aQ + random.nextInt(2)]);
        }
        return null;
    }

    private String b(Random random) {
        int n2 = random.nextInt(4);
        if (n2 == 0) {
            return "Skeleton";
        }
        if (n2 == 1) {
            return "Zombie";
        }
        if (n2 == 2) {
            return "Zombie";
        }
        if (n2 == 3) {
            return "Spider";
        }
        return "";
    }
}

