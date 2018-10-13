package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.PrintStream;
import java.util.Random;

public class l
extends gb {
    protected l(int n2, int n3) {
        super(n2, n3);
        this.aZ = n3;
        this.a(true);
        float f2 = 0.5f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 0.25f, 0.5f + f2);
    }

    protected boolean b(int n2) {
        return n2 == Block.aA.ba;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        int n5;
        float f2;
        super.a(dp2, n2, n3, n4, random);
        if (dp2.h(n2, n3 + 1, n4) >= 9 && (n5 = dp2.b(n2, n3, n4)) < 7 && random.nextInt((int)(100.0f / (f2 = this.h(dp2, n2, n3, n4)))) == 0) {
            dp2.b(n2, n3, n4, ++n5);
        }
    }

    private float h(World dp2, int n2, int n3, int n4) {
        float f2 = 1.0f;
        int n5 = dp2.a(n2, n3, n4 - 1);
        int n6 = dp2.a(n2, n3, n4 + 1);
        int n7 = dp2.a(n2 - 1, n3, n4);
        int n8 = dp2.a(n2 + 1, n3, n4);
        int n9 = dp2.a(n2 - 1, n3, n4 - 1);
        int n10 = dp2.a(n2 + 1, n3, n4 - 1);
        int n11 = dp2.a(n2 + 1, n3, n4 + 1);
        int n12 = dp2.a(n2 - 1, n3, n4 + 1);
        boolean bl2 = n7 == this.ba || n8 == this.ba;
        boolean bl3 = n5 == this.ba || n6 == this.ba;
        boolean bl4 = n9 == this.ba || n10 == this.ba || n11 == this.ba || n12 == this.ba;
        for (int i2 = n2 - 1; i2 <= n2 + 1; ++i2) {
            for (int i3 = n4 - 1; i3 <= n4 + 1; ++i3) {
                int n13 = dp2.a(i2, n3 - 1, i3);
                float f3 = 0.0f;
                if (n13 == Block.aA.ba) {
                    f3 = 1.0f;
                    if (dp2.b(i2, n3 - 1, i3) > 0) {
                        f3 = 3.0f;
                    }
                }
                if (i2 != n2 || i3 != n4) {
                    f3 /= 4.0f;
                }
                f2 += f3;
            }
        }
        if (bl4 || bl2 && bl3) {
            f2 /= 2.0f;
        }
        return f2;
    }

    public int a() {
        return 6;
    }

    public void a(World dp2, int n2, int n3, int n4, int n5) {
        super.a(dp2, n2, n3, n4, n5);
        for (int i2 = 0; i2 < 3; ++i2) {
            if (dp2.k.nextInt(15) > n5) continue;
            float f2 = 0.7f;
            float f3 = dp2.k.nextFloat() * f2 + (1.0f - f2) * 0.5f;
            float f4 = dp2.k.nextFloat() * f2 + (1.0f - f2) * 0.5f;
            float f5 = dp2.k.nextFloat() * f2 + (1.0f - f2) * 0.5f;
            fa fa2 = new fa(dp2, (float)n2 + f3, (float)n3 + f4, (float)n4 + f5, new gc(en.Q));
            fa2.ac = 10;
            dp2.a(fa2);
        }
    }

    public int a(int n2, Random random) {
        System.out.println("Get resource: " + n2);
        if (n2 == 7) {
            return en.R.aQ;
        }
        return -1;
    }

    public int a(Random random) {
        return 1;
    }
}

