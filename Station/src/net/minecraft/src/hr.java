package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class hr
implements bf {
    private Set a = new HashSet();
    private hv b;
    private bf c;
    private am d;
    private Map e = new HashMap();
    private List f = new ArrayList();
    private World g;

    public hr(World dp2, am am2, bf bf2) {
        this.b = new hv(dp2, new byte[32768], 0, 0);
        this.b.q = true;
        this.b.p = true;
        this.g = dp2;
        this.d = am2;
        this.c = bf2;
    }

    public boolean a(int n2, int n3) {
        ia ia2 = new ia(n2, n3);
        return this.e.containsKey(ia2);
    }

    public void c(int n2, int n3) {
        int n4 = n2 * 16 + 8 - this.g.l;
        int n5 = n3 * 16 + 8 - this.g.n;
        int n6 = 20;
        if (n4 < - n6 || n4 > n6 || n5 < - n6 || n5 > n6) {
            this.a.add(new ia(n2, n3));
        }
    }

    public hv d(int n2, int n3) {
        ia ia2 = new ia(n2, n3);
        this.a.remove(new ia(n2, n3));
        hv hv2 = (hv)this.e.get(ia2);
        if (hv2 == null) {
            hv2 = this.e(n2, n3);
            if (hv2 == null) {
                hv2 = this.c == null ? this.b : this.c.b(n2, n3);
            }
            this.e.put(ia2, hv2);
            this.f.add(hv2);
            if (hv2 != null) {
                hv2.c();
            }
            if (!hv2.n && this.a(n2 + 1, n3 + 1) && this.a(n2, n3 + 1) && this.a(n2 + 1, n3)) {
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
        return hv2;
    }

    public hv b(int n2, int n3) {
        ia ia2 = new ia(n2, n3);
        hv hv2 = (hv)this.e.get(ia2);
        if (hv2 == null) {
            if (this.g.s) {
                return this.d(n2, n3);
            }
            return this.b;
        }
        return hv2;
    }

    private hv e(int n2, int n3) {
        if (this.d == null) {
            return null;
        }
        try {
            hv hv2 = this.d.a(this.g, n2, n3);
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
        if (this.d == null) {
            return;
        }
        try {
            this.d.b(this.g, hv2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b(hv hv2) {
        if (this.d == null) {
            return;
        }
        try {
            hv2.s = this.g.b;
            this.d.a(this.g, hv2);
        }
        catch (Exception iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(bf bf2, int n2, int n3) {
        hv hv2 = this.b(n2, n3);
        if (!hv2.n) {
            hv2.n = true;
            if (this.c != null) {
                this.c.a(bf2, n2, n3);
                hv2.e();
            }
        }
    }

    public boolean a(boolean bl2, hg hg2) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            hv hv2 = (hv)this.f.get(i2);
            if (bl2 && !hv2.p) {
                this.a(hv2);
            }
            if (!hv2.a(bl2)) continue;
            this.b(hv2);
            hv2.o = false;
            if (++n2 != 2 || bl2) continue;
            return false;
        }
        if (bl2) {
            if (this.d == null) {
                return true;
            }
            this.d.b();
        }
        return true;
    }

    public boolean a() {
        for (int i2 = 0; i2 < 16; ++i2) {
            if (this.a.isEmpty()) continue;
            ia ia2 = (ia)this.a.iterator().next();
            hv hv2 = this.b(ia2.a, ia2.b);
            hv2.d();
            this.b(hv2);
            this.a(hv2);
            this.a.remove(ia2);
            this.e.remove(ia2);
            this.f.remove(hv2);
        }
        if (this.d != null) {
            this.d.a();
        }
        return this.c.a();
    }

    public boolean b() {
        return true;
    }
}

