/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class br {
    public void a(World dp2, Entity db2, double d2, double d3, double d4, float f2) {
        float f3;
        int n2;
        float f4;
        double d5;
        double d6;
        Object object;
        int n3;
        int n4;
        double d7;
        int n5;
        int n6;
        dp2.a(d2, d3, d4, "random.explode", 4.0f, (1.0f + (dp2.k.nextFloat() - dp2.k.nextFloat()) * 0.2f) * 0.7f);
        HashSet<gf> hashSet = new HashSet<gf>();
        float f5 = f2;
        int n7 = 16;
        for (n4 = 0; n4 < n7; ++n4) {
            for (n2 = 0; n2 < n7; ++n2) {
                for (n5 = 0; n5 < n7; ++n5) {
                    if (n4 != 0 && n4 != n7 - 1 && n2 != 0 && n2 != n7 - 1 && n5 != 0 && n5 != n7 - 1) continue;
                    double d8 = (float)n4 / ((float)n7 - 1.0f) * 2.0f - 1.0f;
                    double d9 = (float)n2 / ((float)n7 - 1.0f) * 2.0f - 1.0f;
                    double d10 = (float)n5 / ((float)n7 - 1.0f) * 2.0f - 1.0f;
                    object = Math.sqrt(d8 * d8 + d9 * d9 + d10 * d10);
                    d8 /= object;
                    d9 /= object;
                    d10 /= object;
                    d6 = d2;
                    d5 = d3;
                    d7 = d4;
                    f4 = 0.3f;
                    for (float f6 = f2 * (0.7f + dp2.k.nextFloat() * 0.6f); f6 > 0.0f; f6 -= f4 * 0.75f) {
                        int n8;
                        int n9 = MathHelper.b(d6);
                        n3 = dp2.a(n9, n6 = MathHelper.b(d5), n8 = MathHelper.b(d7));
                        if (n3 > 0) {
                            f6 -= (Block.n[n3].a(db2) + 0.3f) * f4;
                        }
                        if (f6 > 0.0f) {
                            hashSet.add(new gf(n9, n6, n8));
                        }
                        d6 += d8 * (double)f4;
                        d5 += d9 * (double)f4;
                        d7 += d10 * (double)f4;
                    }
                }
            }
        }
        n4 = MathHelper.b(d2 - (double)(f2 *= 2.0f) - 1.0);
        n2 = MathHelper.b(d2 + (double)f2 + 1.0);
        n5 = MathHelper.b(d3 - (double)f2 - 1.0);
        int n10 = MathHelper.b(d3 + (double)f2 + 1.0);
        int n11 = MathHelper.b(d4 - (double)f2 - 1.0);
        int n12 = MathHelper.b(d4 + (double)f2 + 1.0);
        List list = dp2.b(db2, AxisAlignedBB.b(n4, n5, n11, n2, n10, n12));
        Vec3D as2 = Vec3D.b(d2, d3, d4);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            object = (Entity)list.get(i2);
            double d11 = object.e(d2, d3, d4) / (double)f2;
            if (d11 > 1.0) continue;
            d6 = object.k - d2;
            d5 = object.l - d3;
            d7 = object.m - d4;
            f4 = MathHelper.a(d6 * d6 + d5 * d5 + d7 * d7);
            n6 = (int)dp2.a(as2, object.u);
            n3 = (int)((1.0 - d11) * n6);
            object.a(db2, (n3 * n3 + n3) / 2.0 * 8.0 * (double)f2 + 1.0);
            f3 = n3;
            object.n += (d6 /= f4) * f3;
            object.o += (d5 /= f4) * f3;
            object.p += (d7 /= f4) * f3;
        }
        f2 = f5;
        ArrayList<gf> arrayList = new ArrayList<gf>();
        arrayList.addAll(hashSet);
        for (int i3 = arrayList.size() - 1; i3 >= 0; --i3) {
            gf gf2 = (gf)arrayList.get(i3);
            int n13 = gf2.a;
            int n14 = gf2.b;
            int n15 = gf2.c;
            int n16 = dp2.a(n13, n14, n15);
            for (int i4 = 0; i4 < 1; ++i4) {
                d7 = (float)n13 + dp2.k.nextFloat();
                f4 = (float)n14 + dp2.k.nextFloat();
                n6 = (int)((float)n15 + dp2.k.nextFloat());
                n3 = (int)(d7 - d2);
                f3 = f4 - d3;
                int n17 = n6 - d4;
                double d12 = MathHelper.a((double)(n3 * n3 + f3 * f3 + n17 * n17));
                n3 /= d12;
                f3 /= d12;
                n17 /= d12;
                double d13 = 0.5 / (d12 / (double)f2 + 0.1);
                dp2.a("explode", (d7 + d2 * 1.0) / 2.0, (f4 + d3 * 1.0) / 2.0, (double)((n6 + d4 * 1.0) / 2.0), (double)(n3 *= (d13 *= (double)(dp2.k.nextFloat() * dp2.k.nextFloat() + 0.3f))), f3 *= d13, (double)(n17 *= d13));
                dp2.a("smoke", d7, f4, (double)n6, (double)n3, f3, (double)n17);
            }
            if (n16 <= 0) continue;
            Block.n[n16].a(dp2, n13, n14, n15, dp2.b(n13, n14, n15), 0.3f);
            dp2.d(n13, n14, n15, 0);
            Block.n[n16].c(dp2, n13, n14, n15);
        }
    }
}

