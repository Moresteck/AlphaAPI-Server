/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class dv
extends ay {
    private int a;
    private int b;

    public dv(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        float f2 = random.nextFloat() * 3.1415927f;
        double d2 = (float)(n2 + 8) + fw.a(f2) * (float)this.b / 8.0f;
        double d3 = (float)(n2 + 8) - fw.a(f2) * (float)this.b / 8.0f;
        double d4 = (float)(n4 + 8) + fw.b(f2) * (float)this.b / 8.0f;
        double d5 = (float)(n4 + 8) - fw.b(f2) * (float)this.b / 8.0f;
        double d6 = n3 + random.nextInt(3) + 2;
        double d7 = n3 + random.nextInt(3) + 2;
        for (int i2 = 0; i2 <= this.b; ++i2) {
            double d8 = d2 + (d3 - d2) * (double)i2 / (double)this.b;
            double d9 = d6 + (d7 - d6) * (double)i2 / (double)this.b;
            double d10 = d4 + (d5 - d4) * (double)i2 / (double)this.b;
            double d11 = random.nextDouble() * (double)this.b / 16.0;
            double d12 = (double)(fw.a((float)i2 * 3.1415927f / (float)this.b) + 1.0f) * d11 + 1.0;
            double d13 = (double)(fw.a((float)i2 * 3.1415927f / (float)this.b) + 1.0f) * d11 + 1.0;
            for (int i3 = (int)(d8 - d12 / 2.0); i3 <= (int)(d8 + d12 / 2.0); ++i3) {
                for (int i4 = (int)(d9 - d13 / 2.0); i4 <= (int)(d9 + d13 / 2.0); ++i4) {
                    for (int i5 = (int)(d10 - d12 / 2.0); i5 <= (int)(d10 + d12 / 2.0); ++i5) {
                        double d14 = ((double)i3 + 0.5 - d8) / (d12 / 2.0);
                        double d15 = ((double)i4 + 0.5 - d9) / (d13 / 2.0);
                        double d16 = ((double)i5 + 0.5 - d10) / (d12 / 2.0);
                        if (d14 * d14 + d15 * d15 + d16 * d16 >= 1.0 || dp2.a(i3, i4, i5) != Block.t.ba) continue;
                        dp2.a(i3, i4, i5, this.a);
                    }
                }
            }
        }
        return true;
    }
}

