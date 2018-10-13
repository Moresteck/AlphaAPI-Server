/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.ArrayList;
import java.util.List;

public class Vec3D {
    private static List d = new ArrayList();
    private static int e = 0;
    public double a;
    public double b;
    public double c;

    public static Vec3D a(double d2, double d3, double d4) {
        return new Vec3D(d2, d3, d4);
    }

    public static void a() {
        e = 0;
    }

    public static Vec3D b(double d2, double d3, double d4) {
        if (e >= d.size()) {
            d.add(Vec3D.a(0.0, 0.0, 0.0));
        }
        return ((Vec3D)d.get(e++)).e(d2, d3, d4);
    }

    private Vec3D(double d2, double d3, double d4) {
        if (d2 == -0.0) {
            d2 = 0.0;
        }
        if (d3 == -0.0) {
            d3 = 0.0;
        }
        if (d4 == -0.0) {
            d4 = 0.0;
        }
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    private Vec3D e(double d2, double d3, double d4) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
        return this;
    }

    public Vec3D b() {
        double d2 = MathHelper.a(this.a * this.a + this.b * this.b + this.c * this.c);
        if (d2 < 1.0E-4) {
            return Vec3D.b(0.0, 0.0, 0.0);
        }
        return Vec3D.b(this.a / d2, this.b / d2, this.c / d2);
    }

    public Vec3D c(double d2, double d3, double d4) {
        return Vec3D.b(this.a + d2, this.b + d3, this.c + d4);
    }

    public double a(Vec3D as2) {
        double d2 = as2.a - this.a;
        double d3 = as2.b - this.b;
        double d4 = as2.c - this.c;
        return MathHelper.a(d2 * d2 + d3 * d3 + d4 * d4);
    }

    public double b(Vec3D as2) {
        double d2 = as2.a - this.a;
        double d3 = as2.b - this.b;
        double d4 = as2.c - this.c;
        return d2 * d2 + d3 * d3 + d4 * d4;
    }

    public double d(double d2, double d3, double d4) {
        double d5 = d2 - this.a;
        double d6 = d3 - this.b;
        double d7 = d4 - this.c;
        return d5 * d5 + d6 * d6 + d7 * d7;
    }

    public double c() {
        return MathHelper.a(this.a * this.a + this.b * this.b + this.c * this.c);
    }

    public Vec3D a(Vec3D as2, double d2) {
        double d3 = as2.a - this.a;
        double d4 = as2.b - this.b;
        double d5 = as2.c - this.c;
        if (d3 * d3 < 1.0000000116860974E-7) {
            return null;
        }
        double d6 = (d2 - this.a) / d3;
        if (d6 < 0.0 || d6 > 1.0) {
            return null;
        }
        return Vec3D.b(this.a + d3 * d6, this.b + d4 * d6, this.c + d5 * d6);
    }

    public Vec3D b(Vec3D as2, double d2) {
        double d3 = as2.a - this.a;
        double d4 = as2.b - this.b;
        double d5 = as2.c - this.c;
        if (d4 * d4 < 1.0000000116860974E-7) {
            return null;
        }
        double d6 = (d2 - this.b) / d4;
        if (d6 < 0.0 || d6 > 1.0) {
            return null;
        }
        return Vec3D.b(this.a + d3 * d6, this.b + d4 * d6, this.c + d5 * d6);
    }

    public Vec3D c(Vec3D as2, double d2) {
        double d3 = as2.a - this.a;
        double d4 = as2.b - this.b;
        double d5 = as2.c - this.c;
        if (d5 * d5 < 1.0000000116860974E-7) {
            return null;
        }
        double d6 = (d2 - this.c) / d5;
        if (d6 < 0.0 || d6 > 1.0) {
            return null;
        }
        return Vec3D.b(this.a + d3 * d6, this.b + d4 * d6, this.c + d5 * d6);
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ")";
    }
}

