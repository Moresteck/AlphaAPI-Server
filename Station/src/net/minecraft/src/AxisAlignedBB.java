/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.ArrayList;
import java.util.List;

public class AxisAlignedBB {
    private static List g = new ArrayList();
    private static int h = 0;
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;

    public static AxisAlignedBB a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return new AxisAlignedBB(d2, d3, d4, d5, d6, d7);
    }

    public static void a() {
        h = 0;
    }

    public static AxisAlignedBB b(double d2, double d3, double d4, double d5, double d6, double d7) {
        if (h >= g.size()) {
            g.add(AxisAlignedBB.a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        }
        return ((AxisAlignedBB)g.get(h++)).c(d2, d3, d4, d5, d6, d7);
    }

    private AxisAlignedBB(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.e = d6;
        this.f = d7;
    }

    public AxisAlignedBB c(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.e = d6;
        this.f = d7;
        return this;
    }

    public AxisAlignedBB a(double d2, double d3, double d4) {
        double d5 = this.a;
        double d6 = this.b;
        double d7 = this.c;
        double d8 = this.d;
        double d9 = this.e;
        double d10 = this.f;
        if (d2 < 0.0) {
            d5 += d2;
        }
        if (d2 > 0.0) {
            d8 += d2;
        }
        if (d3 < 0.0) {
            d6 += d3;
        }
        if (d3 > 0.0) {
            d9 += d3;
        }
        if (d4 < 0.0) {
            d7 += d4;
        }
        if (d4 > 0.0) {
            d10 += d4;
        }
        return AxisAlignedBB.b(d5, d6, d7, d8, d9, d10);
    }

    public AxisAlignedBB b(double d2, double d3, double d4) {
        double d5 = this.a - d2;
        double d6 = this.b - d3;
        double d7 = this.c - d4;
        double d8 = this.d + d2;
        double d9 = this.e + d3;
        double d10 = this.f + d4;
        return AxisAlignedBB.b(d5, d6, d7, d8, d9, d10);
    }

    public AxisAlignedBB c(double d2, double d3, double d4) {
        return AxisAlignedBB.b(this.a + d2, this.b + d3, this.c + d4, this.d + d2, this.e + d3, this.f + d4);
    }

    public double a(AxisAlignedBB cy2, double d2) {
        double d3;
        if (cy2.e <= this.b || cy2.b >= this.e) {
            return d2;
        }
        if (cy2.f <= this.c || cy2.c >= this.f) {
            return d2;
        }
        if (d2 > 0.0 && cy2.d <= this.a && (d3 = this.a - cy2.d) < d2) {
            d2 = d3;
        }
        if (d2 < 0.0 && cy2.a >= this.d && (d3 = this.d - cy2.a) > d2) {
            d2 = d3;
        }
        return d2;
    }

    public double b(AxisAlignedBB cy2, double d2) {
        double d3;
        if (cy2.d <= this.a || cy2.a >= this.d) {
            return d2;
        }
        if (cy2.f <= this.c || cy2.c >= this.f) {
            return d2;
        }
        if (d2 > 0.0 && cy2.e <= this.b && (d3 = this.b - cy2.e) < d2) {
            d2 = d3;
        }
        if (d2 < 0.0 && cy2.b >= this.e && (d3 = this.e - cy2.b) > d2) {
            d2 = d3;
        }
        return d2;
    }

    public double c(AxisAlignedBB cy2, double d2) {
        double d3;
        if (cy2.d <= this.a || cy2.a >= this.d) {
            return d2;
        }
        if (cy2.e <= this.b || cy2.b >= this.e) {
            return d2;
        }
        if (d2 > 0.0 && cy2.f <= this.c && (d3 = this.c - cy2.f) < d2) {
            d2 = d3;
        }
        if (d2 < 0.0 && cy2.c >= this.f && (d3 = this.f - cy2.c) > d2) {
            d2 = d3;
        }
        return d2;
    }

    public boolean a(AxisAlignedBB cy2) {
        if (cy2.d <= this.a || cy2.a >= this.d) {
            return false;
        }
        if (cy2.e <= this.b || cy2.b >= this.e) {
            return false;
        }
        if (cy2.f <= this.c || cy2.c >= this.f) {
            return false;
        }
        return true;
    }

    public AxisAlignedBB d(double d2, double d3, double d4) {
        this.a += d2;
        this.b += d3;
        this.c += d4;
        this.d += d2;
        this.e += d3;
        this.f += d4;
        return this;
    }

    public AxisAlignedBB e(double d2, double d3, double d4) {
        double d5 = this.a;
        double d6 = this.b;
        double d7 = this.c;
        double d8 = this.d;
        double d9 = this.e;
        double d10 = this.f;
        if (d2 < 0.0) {
            d5 -= d2;
        }
        if (d2 > 0.0) {
            d8 -= d2;
        }
        if (d3 < 0.0) {
            d6 -= d3;
        }
        if (d3 > 0.0) {
            d9 -= d3;
        }
        if (d4 < 0.0) {
            d7 -= d4;
        }
        if (d4 > 0.0) {
            d10 -= d4;
        }
        return AxisAlignedBB.b(d5, d6, d7, d8, d9, d10);
    }

    public AxisAlignedBB b() {
        return AxisAlignedBB.b(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public fe a(Vec3D as2, Vec3D as3) {
        Vec3D as4 = as2.a(as3, this.a);
        Vec3D as5 = as2.a(as3, this.d);
        Vec3D as6 = as2.b(as3, this.b);
        Vec3D as7 = as2.b(as3, this.e);
        Vec3D as8 = as2.c(as3, this.c);
        Vec3D as9 = as2.c(as3, this.f);
        if (!this.a(as4)) {
            as4 = null;
        }
        if (!this.a(as5)) {
            as5 = null;
        }
        if (!this.b(as6)) {
            as6 = null;
        }
        if (!this.b(as7)) {
            as7 = null;
        }
        if (!this.c(as8)) {
            as8 = null;
        }
        if (!this.c(as9)) {
            as9 = null;
        }
        Vec3D as10 = null;
        if (as4 != null && (as10 == null || as2.b(as4) < as2.b(as10))) {
            as10 = as4;
        }
        if (as5 != null && (as10 == null || as2.b(as5) < as2.b(as10))) {
            as10 = as5;
        }
        if (as6 != null && (as10 == null || as2.b(as6) < as2.b(as10))) {
            as10 = as6;
        }
        if (as7 != null && (as10 == null || as2.b(as7) < as2.b(as10))) {
            as10 = as7;
        }
        if (as8 != null && (as10 == null || as2.b(as8) < as2.b(as10))) {
            as10 = as8;
        }
        if (as9 != null && (as10 == null || as2.b(as9) < as2.b(as10))) {
            as10 = as9;
        }
        if (as10 == null) {
            return null;
        }
        int n2 = -1;
        if (as10 == as4) {
            n2 = 4;
        }
        if (as10 == as5) {
            n2 = 5;
        }
        if (as10 == as6) {
            n2 = 0;
        }
        if (as10 == as7) {
            n2 = 1;
        }
        if (as10 == as8) {
            n2 = 2;
        }
        if (as10 == as9) {
            n2 = 3;
        }
        return new fe(0, 0, 0, n2, as10);
    }

    private boolean a(Vec3D as2) {
        if (as2 == null) {
            return false;
        }
        return as2.b >= this.b && as2.b <= this.e && as2.c >= this.c && as2.c <= this.f;
    }

    private boolean b(Vec3D as2) {
        if (as2 == null) {
            return false;
        }
        return as2.a >= this.a && as2.a <= this.d && as2.c >= this.c && as2.c <= this.f;
    }

    private boolean c(Vec3D as2) {
        if (as2 == null) {
            return false;
        }
        return as2.a >= this.a && as2.a <= this.d && as2.b >= this.b && as2.b <= this.e;
    }

    public void b(AxisAlignedBB cy2) {
        this.a = cy2.a;
        this.b = cy2.b;
        this.c = cy2.c;
        this.d = cy2.d;
        this.e = cy2.e;
        this.f = cy2.f;
    }
}

