/*
 * Decompiled with CFR 0_132.
 */
class bo {
    final long a;
    Object b;
    bo c;
    final int d;

    bo(int n2, long l2, Object object, bo bo2) {
        this.b = object;
        this.c = bo2;
        this.a = l2;
        this.d = n2;
    }

    public final long a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final boolean equals(Object object) {
        Long l2;
        Object object2;
        Object object3;
        if (!(object instanceof bo)) {
            return false;
        }
        bo bo2 = (bo)object;
        Long l3 = this.a();
        if ((l3 == (l2 = Long.valueOf(bo2.a())) || l3 != null && l3.equals(l2)) && ((object3 = this.b()) == (object2 = bo2.b()) || object3 != null && object3.equals(object2))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return PlayerHash.d(this.a);
    }

    public final String toString() {
        return "" + this.a() + "=" + this.b();
    }
}

