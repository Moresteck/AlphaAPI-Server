package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class ed {
    private IBlockAccess a;
    private ho b = new ho();
    private gq c = new gq();
    private a[] d = new a[32];

    public ed(IBlockAccess hb2) {
        this.a = hb2;
    }

    public bx a(Entity db2, Entity db3, float f2) {
        return this.a(db2, db3.k, db3.u.b, db3.m, f2);
    }

    public bx a(Entity db2, int n2, int n3, int n4, float f2) {
        return this.a(db2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, f2);
    }

    private bx a(Entity db2, double d2, double d3, double d4, float f2) {
        this.b.a();
        this.c.a();
        a a2 = this.a(fw.b(db2.u.a), fw.b(db2.u.b), fw.b(db2.u.c));
        a a3 = this.a(fw.b(d2 - (double)(db2.C / 2.0f)), fw.b(d3), fw.b(d4 - (double)(db2.C / 2.0f)));
        a a4 = new a(fw.d(db2.C + 1.0f), fw.d(db2.D + 1.0f), fw.d(db2.C + 1.0f));
        bx bx2 = this.a(db2, a2, a3, a4, f2);
        return bx2;
    }

    private bx a(Entity db2, a a2, a a3, a a4, float f2) {
        a2.f = 0.0f;
        a2.h = a2.g = a2.a(a3);
        this.b.a();
        this.b.a(a2);
        a a5 = a2;
        while (!this.b.c()) {
            a a6 = this.b.b();
            if (a6.d == a3.d) {
                return this.a(a2, a3);
            }
            if (a6.a(a3) < a5.a(a3)) {
                a5 = a6;
            }
            a6.j = true;
            int n2 = this.b(db2, a6, a4, a3, f2);
            for (int i2 = 0; i2 < n2; ++i2) {
                a a7 = this.d[i2];
                float f3 = a6.f + a6.a(a7);
                if (a7.a() && f3 >= a7.f) continue;
                a7.i = a6;
                a7.f = f3;
                a7.g = a7.a(a3);
                if (a7.a()) {
                    this.b.a(a7, a7.f + a7.g);
                    continue;
                }
                a7.h = a7.f + a7.g;
                this.b.a(a7);
            }
        }
        if (a5 == a2) {
            return null;
        }
        return this.a(a2, a5);
    }

    private int b(Entity db2, a a2, a a3, a a4, float f2) {
        int n2 = 0;
        int n3 = 0;
        if (this.a(db2, a2.a, a2.b + 1, a2.c, a3) > 0) {
            n3 = 1;
        }
        a a5 = this.a(db2, a2.a, a2.b, a2.c + 1, a3, n3);
        a a6 = this.a(db2, a2.a - 1, a2.b, a2.c, a3, n3);
        a a7 = this.a(db2, a2.a + 1, a2.b, a2.c, a3, n3);
        a a8 = this.a(db2, a2.a, a2.b, a2.c - 1, a3, n3);
        if (a5 != null && !a5.j && a5.a(a4) < f2) {
            this.d[n2++] = a5;
        }
        if (a6 != null && !a6.j && a6.a(a4) < f2) {
            this.d[n2++] = a6;
        }
        if (a7 != null && !a7.j && a7.a(a4) < f2) {
            this.d[n2++] = a7;
        }
        if (a8 != null && !a8.j && a8.a(a4) < f2) {
            this.d[n2++] = a8;
        }
        return n2;
    }

    private a a(Entity db2, int n2, int n3, int n4, a a2, int n5) {
        a a3 = null;
        if (this.a(db2, n2, n3, n4, a2) > 0) {
            a3 = this.a(n2, n3, n4);
        }
        if (a3 == null && this.a(db2, n2, n3 + n5, n4, a2) > 0) {
            a3 = this.a(n2, n3 + n5, n4);
            n3 += n5;
        }
        if (a3 != null) {
            int n6 = 0;
            int n7 = 0;
            while (n3 > 0 && (n7 = this.a(db2, n2, n3 - 1, n4, a2)) > 0) {
                if (n7 < 0) {
                    return null;
                }
                if (++n6 >= 4) {
                    return null;
                }
                --n3;
            }
            if (n3 > 0) {
                a3 = this.a(n2, n3, n4);
            }
        }
        return a3;
    }

    private final a a(int n2, int n3, int n4) {
        int n5 = n2 | n3 << 10 | n4 << 20;
        a a2 = (a)this.c.a(n5);
        if (a2 == null) {
            a2 = new a(n2, n3, n4);
            this.c.a(n5, a2);
        }
        return a2;
    }

    private int a(Entity db2, int n2, int n3, int n4, a a2) {
        for (int i2 = n2; i2 < n2 + a2.a; ++i2) {
            for (int i3 = n3; i3 < n3 + a2.b; ++i3) {
                for (int i4 = n4; i4 < n4 + a2.c; ++i4) {
                    hz hz2 = this.a.c(n2, n3, n4);
                    if (hz2.c()) {
                        return 0;
                    }
                    if (hz2 != hz.f && hz2 != hz.PlayerListBox) continue;
                    return -1;
                }
            }
        }
        return 1;
    }

    private bx a(a a2, a a3) {
        int n2 = 1;
        a a4 = a3;
        while (a4.i != null) {
            ++n2;
            a4 = a4.i;
        }
        a[] arra = new a[n2];
        a4 = a3;
        arra[--n2] = a4;
        while (a4.i != null) {
            a4 = a4.i;
            arra[--n2] = a4;
        }
        return new bx(arra);
    }
}

