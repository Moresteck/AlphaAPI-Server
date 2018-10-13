package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class gf {
    public final int a;
    public final int b;
    public final int c;

    public gf(int n2, int n3, int n4) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    public boolean equals(Object object) {
        if (object instanceof gf) {
            gf gf2 = (gf)object;
            return gf2.a == this.a && gf2.b == this.b && gf2.c == this.c;
        }
        return false;
    }

    public int hashCode() {
        return this.a * 8976890 + this.b * 981131 + this.c;
    }
}

