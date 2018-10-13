package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class bq
implements Comparable {
    private static long f = 0L;
    public int a;
    public int b;
    public int c;
    public int d;
    public long e;
    private long g = f++;

    public bq(int n2, int n3, int n4, int n5) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = n5;
    }

    public boolean equals(Object object) {
        if (object instanceof bq) {
            bq bq2 = (bq)object;
            return this.a == bq2.a && this.b == bq2.b && this.c == bq2.c && this.d == bq2.d;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 128 * 1024 + this.c * 128 + this.b) * 256 + this.d;
    }

    public bq a(long l2) {
        this.e = l2;
        return this;
    }

    public int a(bq bq2) {
        if (this.e < bq2.e) {
            return -1;
        }
        if (this.e > bq2.e) {
            return 1;
        }
        if (this.g < bq2.g) {
            return -1;
        }
        if (this.g > bq2.g) {
            return 1;
        }
        return 0;
    }
}

