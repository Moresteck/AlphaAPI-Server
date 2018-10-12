/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class bp
extends Entity {
    private int ac = 0;
    public int a = 0;
    private int ad;
    private int ae;
    private int af;
    public fx b;

    public bp(World dp2) {
        super(dp2);
        this.B = 0.0f;
        this.a(0.5f, 0.5f);
    }

    public bp(World dp2, int n2, int n3, int n4, int n5) {
        this(dp2);
        this.ad = n2;
        this.ae = n3;
        this.af = n4;
        ArrayList<fx> arrayList = new ArrayList<fx>();
        fx[] arrfx = fx.values();
        int n6 = arrfx.length;
        for (int i2 = 0; i2 < n6; ++i2) {
            fx fx2;
            this.b = fx2 = arrfx[i2];
            this.a(n5);
            if (!this.b()) continue;
            arrayList.add(fx2);
        }
        if (arrayList.size() > 0) {
            this.b = (fx)((Object)arrayList.get(this.Q.nextInt(arrayList.size())));
        }
        this.a(n5);
    }

    public void a(int n2) {
        this.a = n2;
        this.s = this.q = (float)(n2 * 90);
        float f2 = this.b.u;
        float f3 = this.b.v;
        float f4 = this.b.u;
        if (n2 == 0 || n2 == 2) {
            f4 = 0.5f;
        } else {
            f2 = 0.5f;
        }
        f2 /= 32.0f;
        f3 /= 32.0f;
        f4 /= 32.0f;
        float f5 = (float)this.ad + 0.5f;
        float f6 = (float)this.ae + 0.5f;
        float f7 = (float)this.af + 0.5f;
        float f8 = 0.5625f;
        if (n2 == 0) {
            f7 -= f8;
        }
        if (n2 == 1) {
            f5 -= f8;
        }
        if (n2 == 2) {
            f7 += f8;
        }
        if (n2 == 3) {
            f5 += f8;
        }
        if (n2 == 0) {
            f5 -= this.c(this.b.u);
        }
        if (n2 == 1) {
            f7 += this.c(this.b.u);
        }
        if (n2 == 2) {
            f5 += this.c(this.b.u);
        }
        if (n2 == 3) {
            f7 -= this.c(this.b.u);
        }
        this.a((double)f5, (double)(f6 += this.c(this.b.v)), (double)f7);
        float f9 = -0.00625f;
        this.u.c(f5 - f2 - f9, f6 - f3 - f9, f7 - f4 - f9, f5 + f2 + f9, f6 + f3 + f9, f7 + f4 + f9);
    }

    private float c(int n2) {
        if (n2 == 32) {
            return 0.5f;
        }
        if (n2 == 64) {
            return 0.5f;
        }
        return 0.0f;
    }

    public void b_() {
        if (this.ac++ == 100 && !this.b()) {
            this.ac = 0;
            this.i();
            this.g.a(new fa(this.g, this.k, this.l, this.m, new gc(en.aq)));
        }
    }

    public boolean b() {
        int n2;
        if (this.g.a((Entity)this, this.u).size() > 0) {
            return false;
        }
        int n3 = this.b.u / 16;
        int n4 = this.b.v / 16;
        int n5 = this.ad;
        int n6 = this.ae;
        int n7 = this.af;
        if (this.a == 0) {
            n5 = fw.b(this.k - (double)((float)this.b.u / 32.0f));
        }
        if (this.a == 1) {
            n7 = fw.b(this.m - (double)((float)this.b.u / 32.0f));
        }
        if (this.a == 2) {
            n5 = fw.b(this.k - (double)((float)this.b.u / 32.0f));
        }
        if (this.a == 3) {
            n7 = fw.b(this.m - (double)((float)this.b.u / 32.0f));
        }
        n6 = fw.b(this.l - (double)((float)this.b.v / 32.0f));
        for (int i2 = 0; i2 < n3; ++i2) {
            for (n2 = 0; n2 < n4; ++n2) {
                hz hz2 = this.a == 0 || this.a == 2 ? this.g.c(n5 + i2, n6 + n2, this.af) : this.g.c(this.ad, n6 + n2, n7 + i2);
                if (hz2.a()) continue;
                return false;
            }
        }
        List list = this.g.b(this, this.u);
        for (n2 = 0; n2 < list.size(); ++n2) {
            if (!(list.get(n2) instanceof bp)) continue;
            return false;
        }
        return true;
    }

    public boolean c_() {
        return true;
    }

    public boolean a(Entity db2, int n2) {
        this.i();
        this.g.a(new fa(this.g, this.k, this.l, this.m, new gc(en.aq)));
        return true;
    }

    public void a(r r2) {
        r2.a("Dir", (byte)this.a);
        r2.a("Motive", this.b.t);
        r2.a("TileX", this.ad);
        r2.a("TileY", this.ae);
        r2.a("TileZ", this.af);
    }

    public void b(r r2) {
        this.a = r2.b("Dir");
        this.ad = r2.d("TileX");
        this.ae = r2.d("TileY");
        this.af = r2.d("TileZ");
        String string = r2.h("Motive");
        for (fx fx2 : fx.values()) {
            if (!fx2.t.equals(string)) continue;
            this.b = fx2;
        }
        if (this.b == null) {
            this.b = fx.a;
        }
        this.a(this.a);
    }
}

