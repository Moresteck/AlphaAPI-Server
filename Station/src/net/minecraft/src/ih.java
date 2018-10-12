/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
public class ih {
    public int a;
    public int b;

    public ih(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public int hashCode() {
        return this.a << 8 | this.b;
    }

    public boolean equals(Object object) {
        ih ih2 = (ih)object;
        return ih2.a == this.a && ih2.b == this.b;
    }

    public double a(Entity entity) {
        double d2 = this.a * 16 + 8;
        double d3 = this.b * 16 + 8;
        double d4 = d2 - entity.k;
        double d5 = d3 - entity.m;
        return d4 * d4 + d5 * d5;
    }
}

