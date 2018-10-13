package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.IOException;

public class hf
implements bf {
    private hv c;
    private bf d;
    private am e;
    private hv[] f = new hv[1024];
    private World g;
    int a = -999999999;
    int b = -999999999;
    private hv h;

    public hf(World dp2, am am2, bf bf2) {
        this.c = new hv(dp2, new byte[32768], 0, 0);
        this.c.q = true;
        this.c.p = true;
        this.g = dp2;
        this.e = am2;
        this.d = bf2;
    }

    public boolean a(int n2, int n3) {
        if (n2 == this.a && n3 == this.b && this.h != null) {
            return true;
        }
        int n4 = n2 & 31;
        int n5 = n3 & 31;
        int n6 = n4 + n5 * 32;
        return this.f[n6] != null && (this.f[n6] == this.c || this.f[n6].a(n2, n3));
    }

    public hv b(int n2, int n3) {
        if (n2 == this.a && n3 == this.b && this.h != null) {
            return this.h;
        }
        int n4 = n2 & 31;
        int n5 = n3 & 31;
        int n6 = n4 + n5 * 32;
        if (!this.a(n2, n3)) {
            hv hv2;
            if (this.f[n6] != null) {
                this.f[n6].d();
                this.b(this.f[n6]);
                this.a(this.f[n6]);
            }
            if ((hv2 = this.c(n2, n3)) == null) {
                hv2 = this.d == null ? this.c : this.d.b(n2, n3);
            }
            this.f[n6] = hv2;
            if (this.f[n6] != null) {
                this.f[n6].c();
            }
            if (!this.f[n6].n && this.a(n2 + 1, n3 + 1) && this.a(n2, n3 + 1) && this.a(n2 + 1, n3)) {
                this.a(this, n2, n3);
            }
            if (this.a(n2 - 1, n3) && !this.b((int)(n2 - 1), (int)n3).n && this.a(n2 - 1, n3 + 1) && this.a(n2, n3 + 1) && this.a(n2 - 1, n3)) {
                this.a(this, n2 - 1, n3);
            }
            if (this.a(n2, n3 - 1) && !this.b((int)n2, (int)(n3 - 1)).n && this.a(n2 + 1, n3 - 1) && this.a(n2, n3 - 1) && this.a(n2 + 1, n3)) {
                this.a(this, n2, n3 - 1);
            }
            if (this.a(n2 - 1, n3 - 1) && !this.b((int)(n2 - 1), (int)(n3 - 1)).n && this.a(n2 - 1, n3 - 1) && this.a(n2, n3 - 1) && this.a(n2 - 1, n3)) {
                this.a(this, n2 - 1, n3 - 1);
            }
        }
        this.a = n2;
        this.b = n3;
        this.h = this.f[n6];
        return this.f[n6];
    }

    private hv c(int n2, int n3) {
        if (this.e == null) {
            return null;
        }
        try {
            hv hv2 = this.e.a(this.g, n2, n3);
            if (hv2 != null) {
                hv2.s = this.g.b;
            }
            return hv2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void a(hv hv2) {
        if (this.e == null) {
            return;
        }
        try {
            this.e.b(this.g, hv2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b(hv hv2) {
        if (this.e == null) {
            return;
        }
        try {
            hv2.s = this.g.b;
            this.e.a(this.g, hv2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(bf bf2, int n2, int n3) {
        hv hv2 = this.b(n2, n3);
        if (!hv2.n) {
            hv2.n = true;
            if (this.d != null) {
                this.d.a(bf2, n2, n3);
                hv2.e();
            }
        }
    }

    public boolean a(boolean bl2, hg hg2) {
        int n2;
        int n3 = 0;
        int n4 = 0;
        if (hg2 != null) {
            for (n2 = 0; n2 < this.f.length; ++n2) {
                if (this.f[n2] == null || !this.f[n2].a(bl2)) continue;
                ++n4;
            }
        }
        n2 = 0;
        for (int i2 = 0; i2 < this.f.length; ++i2) {
            if (this.f[i2] == null) continue;
            if (bl2 && !this.f[i2].p) {
                this.a(this.f[i2]);
            }
            if (!this.f[i2].a(bl2)) continue;
            this.b(this.f[i2]);
            this.f[i2].o = false;
            if (++n3 == 2 && !bl2) {
                return false;
            }
            if (hg2 == null || ++n2 % 10 != 0) continue;
            hg2.a(n2 * 100 / n4);
        }
        if (bl2) {
            if (this.e == null) {
                return true;
            }
            this.e.b();
        }
        return true;
    }

    public boolean a() {
        if (this.e != null) {
            this.e.a();
        }
        return this.d.a();
    }

    public boolean b() {
        return true;
    }
}

