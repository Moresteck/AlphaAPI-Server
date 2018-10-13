package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
final class ia {
    public final int a;
    public final int b;

    public ia(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public boolean equals(Object object) {
        if (object instanceof ia) {
            ia ia2 = (ia)object;
            return this.a == ia2.a && this.b == ia2.b;
        }
        return false;
    }

    public int hashCode() {
        return this.a << 16 ^ this.b;
    }
}

