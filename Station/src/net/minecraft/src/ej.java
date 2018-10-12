/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ej
extends bw {
    private ac[] a;
    private int b;

    public ej(Random random, int n2) {
        this.b = n2;
        this.a = new ac[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2] = new ac(random);
        }
    }

    public double a(double d2, double d3) {
        double d4 = 0.0;
        double d5 = 1.0;
        for (int i2 = 0; i2 < this.b; ++i2) {
            d4 += this.a[i2].a(d2 * d5, d3 * d5) / d5;
            d5 /= 2.0;
        }
        return d4;
    }

    public double[] a(double[] arrd, double d2, double d3, double d4, int n2, int n3, int n4, double d5, double d6, double d7) {
        if (arrd == null) {
            arrd = new double[n2 * n3 * n4];
        } else {
            for (int i2 = 0; i2 < arrd.length; ++i2) {
                arrd[i2] = 0.0;
            }
        }
        double d8 = 1.0;
        for (int i3 = 0; i3 < this.b; ++i3) {
            this.a[i3].a(arrd, d2, d3, d4, n2, n3, n4, d5 * d8, d6 * d8, d7 * d8, d8);
            d8 /= 2.0;
        }
        return arrd;
    }
}

