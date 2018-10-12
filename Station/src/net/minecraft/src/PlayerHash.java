/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
public class PlayerHash {
    private transient bo[] a = new bo[16];
    private transient int b;
    private int c = 12;
    private final float d = 0.75f;
    private volatile transient int e;

    private static int e(long l2) {
        return PlayerHash.a((int)(l2 ^ l2 >>> 32));
    }

    private static int a(int n2) {
        n2 ^= n2 >>> 20 ^ n2 >>> 12;
        return n2 ^ n2 >>> 7 ^ n2 >>> 4;
    }

    private static int a(int n2, int n3) {
        return n2 & n3 - 1;
    }

    public Object a(long l2) {
        int n2 = PlayerHash.e(l2);
        bo bo2 = this.a[PlayerHash.a(n2, this.a.length)];
        while (bo2 != null) {
            if (bo2.a == l2) {
                return bo2.b;
            }
            bo2 = bo2.c;
        }
        return null;
    }

    public void a(long l2, Object object) {
        int n2 = PlayerHash.e(l2);
        int n3 = PlayerHash.a(n2, this.a.length);
        bo bo2 = this.a[n3];
        while (bo2 != null) {
            if (bo2.a == l2) {
                bo2.b = object;
            }
            bo2 = bo2.c;
        }
        ++this.e;
        this.a(n2, l2, object, n3);
    }

    private void b(int n2) {
        bo[] arrbo = this.a;
        int n3 = arrbo.length;
        if (n3 == 1073741824) {
            this.c = Integer.MAX_VALUE;
            return;
        }
        bo[] arrbo2 = new bo[n2];
        this.a(arrbo2);
        this.a = arrbo2;
        this.c = (int)((float)n2 * this.d);
    }

    private void a(bo[] arrbo) {
        bo[] arrbo2 = this.a;
        int n2 = arrbo.length;
        for (int i2 = 0; i2 < arrbo2.length; ++i2) {
            bo bo2;
            bo bo3 = arrbo2[i2];
            if (bo3 == null) continue;
            arrbo2[i2] = null;
            do {
                bo2 = bo3.c;
                int n3 = PlayerHash.a(bo3.d, n2);
                bo3.c = arrbo[n3];
                arrbo[n3] = bo3;
            } while ((bo3 = bo2) != null);
        }
    }

    public Object b(long l2) {
        bo bo2 = this.c(l2);
        return bo2 == null ? null : bo2.b;
    }

    final bo c(long l2) {
        bo bo2;
        int n2 = PlayerHash.e(l2);
        int n3 = PlayerHash.a(n2, this.a.length);
        bo bo3 = bo2 = this.a[n3];
        while (bo3 != null) {
            bo bo4 = bo3.c;
            if (bo3.a == l2) {
                ++this.e;
                --this.b;
                if (bo2 == bo3) {
                    this.a[n3] = bo4;
                } else {
                    bo2.c = bo4;
                }
                return bo3;
            }
            bo2 = bo3;
            bo3 = bo4;
        }
        return bo3;
    }

    private void a(int n2, long l2, Object object, int n3) {
        bo bo2 = this.a[n3];
        this.a[n3] = new bo(n2, l2, object, bo2);
        if (this.b++ >= this.c) {
            this.b(2 * this.a.length);
        }
    }

    static /* synthetic */ int d(long l2) {
        return PlayerHash.e(l2);
    }
}

