/*
 * Decompiled with CFR 0_132.
 */
public class gq {
    private transient gi[] a = new gi[16];
    private transient int b;
    private int c = 12;
    private final float d = 0.75f;
    private volatile transient int e;

    private static int g(int n2) {
        n2 ^= n2 >>> 20 ^ n2 >>> 12;
        return n2 ^ n2 >>> 7 ^ n2 >>> 4;
    }

    private static int a(int n2, int n3) {
        return n2 & n3 - 1;
    }

    public Object a(int n2) {
        int n3 = gq.g(n2);
        gi gi2 = this.a[gq.a(n3, this.a.length)];
        while (gi2 != null) {
            if (gi2.a == n2) {
                return gi2.b;
            }
            gi2 = gi2.c;
        }
        return null;
    }

    public boolean b(int n2) {
        return this.c(n2) != null;
    }

    final gi c(int n2) {
        int n3 = gq.g(n2);
        gi gi2 = this.a[gq.a(n3, this.a.length)];
        while (gi2 != null) {
            if (gi2.a == n2) {
                return gi2;
            }
            gi2 = gi2.c;
        }
        return null;
    }

    public void a(int n2, Object object) {
        int n3 = gq.g(n2);
        int n4 = gq.a(n3, this.a.length);
        gi gi2 = this.a[n4];
        while (gi2 != null) {
            if (gi2.a == n2) {
                gi2.b = object;
            }
            gi2 = gi2.c;
        }
        ++this.e;
        this.a(n3, n2, object, n4);
    }

    private void h(int n2) {
        gi[] arrgi = this.a;
        int n3 = arrgi.length;
        if (n3 == 1073741824) {
            this.c = Integer.MAX_VALUE;
            return;
        }
        gi[] arrgi2 = new gi[n2];
        this.a(arrgi2);
        this.a = arrgi2;
        this.c = (int)((float)n2 * this.d);
    }

    private void a(gi[] arrgi) {
        gi[] arrgi2 = this.a;
        int n2 = arrgi.length;
        for (int i2 = 0; i2 < arrgi2.length; ++i2) {
            gi gi2;
            gi gi3 = arrgi2[i2];
            if (gi3 == null) continue;
            arrgi2[i2] = null;
            do {
                gi2 = gi3.c;
                int n3 = gq.a(gi3.d, n2);
                gi3.c = arrgi[n3];
                arrgi[n3] = gi3;
            } while ((gi3 = gi2) != null);
        }
    }

    public Object d(int n2) {
        gi gi2 = this.e(n2);
        return gi2 == null ? null : gi2.b;
    }

    final gi e(int n2) {
        gi gi2;
        int n3 = gq.g(n2);
        int n4 = gq.a(n3, this.a.length);
        gi gi3 = gi2 = this.a[n4];
        while (gi3 != null) {
            gi gi4 = gi3.c;
            if (gi3.a == n2) {
                ++this.e;
                --this.b;
                if (gi2 == gi3) {
                    this.a[n4] = gi4;
                } else {
                    gi2.c = gi4;
                }
                return gi3;
            }
            gi2 = gi3;
            gi3 = gi4;
        }
        return gi3;
    }

    public void a() {
        ++this.e;
        gi[] arrgi = this.a;
        for (int i2 = 0; i2 < arrgi.length; ++i2) {
            arrgi[i2] = null;
        }
        this.b = 0;
    }

    private void a(int n2, int n3, Object object, int n4) {
        gi gi2 = this.a[n4];
        this.a[n4] = new gi(n2, n3, object, gi2);
        if (this.b++ >= this.c) {
            this.h(2 * this.a.length);
        }
    }

    static /* synthetic */ int f(int n2) {
        return gq.g(n2);
    }
}

