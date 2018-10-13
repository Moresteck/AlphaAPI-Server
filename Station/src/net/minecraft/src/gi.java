package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
class gi {
    final int a;
    Object b;
    gi c;
    final int d;

    gi(int n2, int n3, Object object, gi gi2) {
        this.b = object;
        this.c = gi2;
        this.a = n3;
        this.d = n2;
    }

    public final int a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final boolean equals(Object object) {
        Object object2;
        Object object3;
        Integer n2;
        if (!(object instanceof gi)) {
            return false;
        }
        gi gi2 = (gi)object;
        Integer n3 = this.a();
        if ((n3 == (n2 = Integer.valueOf(gi2.a())) || n3 != null && n3.equals(n2)) && ((object3 = this.b()) == (object2 = gi2.b()) || object3 != null && object3.equals(object2))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return gq.f(this.a);
    }

    public final String toString() {
        return "" + this.a() + "=" + this.b();
    }
}

