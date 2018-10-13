/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.List;
import java.util.Random;

public abstract class Entity {
    private static int a = 0;
    public int c = a++;
    public boolean d = false;
    public Entity e;
    public Entity f;
    protected World g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;
    public double p;
    public float q;
    public float r;
    public float s;
    public float t;
    public final AxisAlignedBB u = AxisAlignedBB.a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    public boolean v = false;
    public boolean w;
    public boolean x;
    public boolean y = false;
    public boolean z = true;
    public boolean A = false;
    public float B = 0.0f;
    public float C = 0.6f;
    public float D = 1.8f;
    public float E = 0.0f;
    public float F = 0.0f;
    protected boolean G = true;
    protected float H = 0.0f;
    private int b = 1;
    public double I;
    public double J;
    public double K;
    public float L = 0.0f;
    public float M = 0.0f;
    public boolean N = false;
    public float O = 0.0f;
    public boolean P = false;
    protected Random Q = new Random();
    public int R = 0;
    public int S = 1;
    public int T = 0;
    protected int U = 300;
    protected boolean V = false;
    public int W = 0;
    public int X = 300;
    private boolean ac = true;
    private double ad;
    private double ae;
    public boolean Y = false;
    public int Z;
    public int aa;
    public int ab;

    public Entity(World dp2) {
        this.g = dp2;
        this.a(0.0, 0.0, 0.0);
    }

    public boolean equals(Object object) {
        if (object instanceof Entity) {
            return ((Entity)object).c == this.c;
        }
        return false;
    }

    public int hashCode() {
        return this.c;
    }

    public void i() {
        this.A = true;
    }

    protected void a(float f2, float f3) {
        this.C = f2;
        this.D = f3;
    }

    protected void b(float f2, float f3) {
        this.q = f2;
        this.r = f3;
    }

    public void a(double d2, double d3, double d4) {
        this.k = d2;
        this.l = d3;
        this.m = d4;
        float f2 = this.C / 2.0f;
        float f3 = this.D;
        this.u.c(d2 - (double)f2, d3 - (double)this.B + (double)this.L, d4 - (double)f2, d2 + (double)f2, d3 - (double)this.B + (double)this.L + (double)f3, d4 + (double)f2);
    }

    public void b_() {
        this.j();
    }

    public void j() {
        if (this.f != null && this.f.A) {
            this.f = null;
        }
        ++this.R;
        this.E = this.F;
        this.h = this.k;
        this.i = this.l;
        this.j = this.m;
        this.t = this.r;
        this.s = this.q;
        if (this.m()) {
            if (!this.V && !this.ac) {
                float f2;
                float f3;
                float f4 = MathHelper.a(this.n * this.n * 0.20000000298023224 + this.o * this.o + this.p * this.p * 0.20000000298023224) * 0.2f;
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                this.g.a(this, "random.splash", f4, 1.0f + (this.Q.nextFloat() - this.Q.nextFloat()) * 0.4f);
                float f5 = MathHelper.b(this.u.b);
                int n2 = 0;
                while ((float)n2 < 1.0f + this.C * 20.0f) {
                    f3 = (this.Q.nextFloat() * 2.0f - 1.0f) * this.C;
                    f2 = (this.Q.nextFloat() * 2.0f - 1.0f) * this.C;
                    this.g.a("bubble", this.k + (double)f3, f5 + 1.0f, this.m + (double)f2, this.n, this.o - (double)(this.Q.nextFloat() * 0.2f), this.p);
                    ++n2;
                }
                n2 = 0;
                while ((float)n2 < 1.0f + this.C * 20.0f) {
                    f3 = (this.Q.nextFloat() * 2.0f - 1.0f) * this.C;
                    f2 = (this.Q.nextFloat() * 2.0f - 1.0f) * this.C;
                    this.g.a("splash", this.k + (double)f3, f5 + 1.0f, this.m + (double)f2, this.n, this.o, this.p);
                    ++n2;
                }
            }
            this.H = 0.0f;
            this.V = true;
            this.T = 0;
        } else {
            this.V = false;
        }
        if (this.T > 0) {
            if (this.T % 20 == 0) {
                this.a(null, 1);
            }
            --this.T;
        }
        if (this.o()) {
            this.a(null, 10);
            this.T = 600;
        }
        if (this.l < -64.0) {
            this.k();
        }
        this.ac = false;
    }

    protected void k() {
        this.i();
    }

    public boolean b(double d2, double d3, double d4) {
        AxisAlignedBB cy2 = this.u.c(d2, d3, d4);
        List list = this.g.a(this, cy2);
        if (list.size() > 0) {
            return false;
        }
        if (this.g.b(cy2)) {
            return false;
        }
        return true;
    }

    public void c(double d2, double d3, double d4) {
        int n2;
        int n3;
        int n4;
        double d5;
        int n5;
        if (this.N) {
            this.u.d(d2, d3, d4);
            this.k = (this.u.a + this.u.d) / 2.0;
            this.l = this.u.b + (double)this.B - (double)this.L;
            this.m = (this.u.c + this.u.f) / 2.0;
            return;
        }
        double d6 = this.k;
        double d7 = this.m;
        double d8 = d2;
        double d9 = d3;
        double d10 = d4;
        AxisAlignedBB cy2 = this.u.b();
        List list = this.g.a(this, this.u.a(d2, d3, d4));
        for (n4 = 0; n4 < list.size(); ++n4) {
            d3 = ((AxisAlignedBB)list.get(n4)).b(this.u, d3);
        }
        this.u.d(0.0, d3, 0.0);
        if (!this.z && d9 != d3) {
            d4 = 0.0;
            d3 = 0.0;
            d2 = 0.0;
        }
        n4 = this.v || d9 != d3 && d9 < 0.0 ? 1 : 0;
        for (n2 = 0; n2 < list.size(); ++n2) {
            d2 = ((AxisAlignedBB)list.get(n2)).a(this.u, d2);
        }
        this.u.d(d2, 0.0, 0.0);
        if (!this.z && d8 != d2) {
            d4 = 0.0;
            d3 = 0.0;
            d2 = 0.0;
        }
        for (n2 = 0; n2 < list.size(); ++n2) {
            d4 = ((AxisAlignedBB)list.get(n2)).c(this.u, d4);
        }
        this.u.d(0.0, 0.0, d4);
        if (!this.z && d10 != d4) {
            d4 = 0.0;
            d3 = 0.0;
            d2 = 0.0;
        }
        if (this.M > 0.0f && n4 != 0 && this.L < 0.05f && (d8 != d2 || d10 != d4)) {
            double d11 = d2;
            d5 = d3;
            double d12 = d4;
            d2 = d8;
            d3 = this.M;
            d4 = d10;
            AxisAlignedBB cy3 = this.u.b();
            this.u.b(cy2);
            list = this.g.a(this, this.u.a(d2, d3, d4));
            for (n3 = 0; n3 < list.size(); ++n3) {
                d3 = ((AxisAlignedBB)list.get(n3)).b(this.u, d3);
            }
            this.u.d(0.0, d3, 0.0);
            if (!this.z && d9 != d3) {
                d4 = 0.0;
                d3 = 0.0;
                d2 = 0.0;
            }
            for (n3 = 0; n3 < list.size(); ++n3) {
                d2 = ((AxisAlignedBB)list.get(n3)).a(this.u, d2);
            }
            this.u.d(d2, 0.0, 0.0);
            if (!this.z && d8 != d2) {
                d4 = 0.0;
                d3 = 0.0;
                d2 = 0.0;
            }
            for (n3 = 0; n3 < list.size(); ++n3) {
                d4 = ((AxisAlignedBB)list.get(n3)).c(this.u, d4);
            }
            this.u.d(0.0, 0.0, d4);
            if (!this.z && d10 != d4) {
                d4 = 0.0;
                d3 = 0.0;
                d2 = 0.0;
            }
            if (d11 * d11 + d12 * d12 >= d2 * d2 + d4 * d4) {
                d2 = d11;
                d3 = d5;
                d4 = d12;
                this.u.b(cy3);
            } else {
                this.L = (float)((double)this.L + 0.5);
            }
        }
        this.k = (this.u.a + this.u.d) / 2.0;
        this.l = this.u.b + (double)this.B - (double)this.L;
        this.m = (this.u.c + this.u.f) / 2.0;
        this.w = d8 != d2 || d10 != d4;
        this.x = d9 != d3;
        this.v = d9 != d3 && d9 < 0.0;
        boolean bl2 = this.y = this.w || this.x;
        if (this.v) {
            if (this.H > 0.0f) {
                this.a(this.H);
                this.H = 0.0f;
            }
        } else if (d3 < 0.0) {
            this.H = (float)((double)this.H - d3);
        }
        if (d8 != d2) {
            this.n = 0.0;
        }
        if (d9 != d3) {
            this.o = 0.0;
        }
        if (d10 != d4) {
            this.p = 0.0;
        }
        double d13 = this.k - d6;
        d5 = this.m - d7;
        this.F = (float)((double)this.F + (double)MathHelper.a(d13 * d13 + d5 * d5) * 0.6);
        if (this.G) {
            int n6 = MathHelper.b(this.k);
            n5 = MathHelper.b(this.l - 0.20000000298023224 - (double)this.B);
            int n7 = MathHelper.b(this.m);
            n3 = this.g.a(n6, n5, n7);
            if (this.F > (float)this.b && n3 > 0) {
                ++this.b;
                bl bl3 = Block.n[n3].bj;
                if (this.g.a(n6, n5 + 1, n7) == Block.aS.ba) {
                    bl3 = Block.aS.bj;
                    this.g.a(this, bl3.c(), bl3.a() * 0.15f, bl3.b());
                } else if (!Block.n[n3].bl.d()) {
                    this.g.a(this, bl3.c(), bl3.a() * 0.15f, bl3.b());
                }
                Block.n[n3].b(this.g, n6, n5, n7, this);
            }
        }
        int n8 = MathHelper.b(this.u.a);
        n5 = MathHelper.b(this.u.b);
        int n9 = MathHelper.b(this.u.c);
        n3 = MathHelper.b(this.u.d);
        int n10 = MathHelper.b(this.u.e);
        int n11 = MathHelper.b(this.u.f);
        for (int i2 = n8; i2 <= n3; ++i2) {
            for (int i3 = n5; i3 <= n10; ++i3) {
                for (int i4 = n9; i4 <= n11; ++i4) {
                    int n12 = this.g.a(i2, i3, i4);
                    if (n12 <= 0) continue;
                    Block.n[n12].a(this.g, i2, i3, i4, this);
                }
            }
        }
        this.L *= 0.4f;
        n8 = this.m() ? 1 : 0;
        if (this.g.c(this.u)) {
            this.b(1);
            if (n8 == 0) {
                ++this.T;
                if (this.T == 0) {
                    this.T = 300;
                }
            }
        } else if (this.T <= 0) {
            this.T = - this.S;
        }
        if (n8 != 0 && this.T > 0) {
            this.g.a(this, "random.fizz", 0.7f, 1.6f + (this.Q.nextFloat() - this.Q.nextFloat()) * 0.4f);
            this.T = - this.S;
        }
    }

    public AxisAlignedBB l() {
        return null;
    }

    protected void b(int n2) {
        this.a(null, n2);
    }

    protected void a(float f2) {
    }

    public boolean m() {
        return this.g.a(this.u.b(0.0, -0.4000000059604645, 0.0), Material.f, this);
    }

    public boolean a(Material hz2) {
        int n2;
        int n3;
        double d2 = this.l + (double)this.n();
        int n4 = MathHelper.b(this.k);
        int n5 = this.g.a(n4, n3 = MathHelper.d(MathHelper.b(d2)), n2 = MathHelper.b(this.m));
        if (n5 != 0 && Block.n[n5].bl == hz2) {
            float f2 = cg.b(this.g.b(n4, n3, n2)) - 0.11111111f;
            float f3 = (float)(n3 + 1) - f2;
            return d2 < (double)f3;
        }
        return false;
    }

    protected float n() {
        return 0.0f;
    }

    public boolean o() {
        return this.g.a(this.u.b(0.0, -0.4000000059604645, 0.0), Material.f);
    }

    public void a(float f2, float f3, float f4) {
        float f5 = MathHelper.c(f2 * f2 + f3 * f3);
        if (f5 < 0.01f) {
            return;
        }
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        f5 = f4 / f5;
        float f6 = MathHelper.a(this.q * 3.1415927f / 180.0f);
        float f7 = MathHelper.b(this.q * 3.1415927f / 180.0f);
        this.n += (double)((f2 *= f5) * f7 - (f3 *= f5) * f6);
        this.p += (double)(f3 * f7 + f2 * f6);
    }

    public float b(float f2) {
        int n2 = MathHelper.b(this.k);
        double d2 = (this.u.e - this.u.b) * 0.66;
        int n3 = MathHelper.b(this.l - (double)this.B + d2);
        int n4 = MathHelper.b(this.m);
        return this.g.j(n2, n3, n4);
    }

    public void b(double d2, double d3, double d4, float f2, float f3) {
        this.h = this.k = d2;
        this.i = this.l = d3;
        this.j = this.m = d4;
        this.q = f2;
        this.r = f3;
        this.L = 0.0f;
        double d5 = this.s - f2;
        if (d5 < -180.0) {
            this.s += 360.0f;
        }
        if (d5 >= 180.0) {
            this.s -= 360.0f;
        }
        this.a(this.k, this.l, this.m);
    }

    public void c(double d2, double d3, double d4, float f2, float f3) {
        this.h = this.k = d2;
        this.i = this.l = d3 + (double)this.B;
        this.j = this.m = d4;
        this.q = f2;
        this.r = f3;
        this.a(this.k, this.l, this.m);
    }

    public float a(Entity db2) {
        float f2 = (float)(this.k - db2.k);
        float f3 = (float)(this.l - db2.l);
        float f4 = (float)(this.m - db2.m);
        return MathHelper.c(f2 * f2 + f3 * f3 + f4 * f4);
    }

    public double d(double d2, double d3, double d4) {
        double d5 = this.k - d2;
        double d6 = this.l - d3;
        double d7 = this.m - d4;
        return d5 * d5 + d6 * d6 + d7 * d7;
    }

    public double e(double d2, double d3, double d4) {
        double d5 = this.k - d2;
        double d6 = this.l - d3;
        double d7 = this.m - d4;
        return MathHelper.a(d5 * d5 + d6 * d6 + d7 * d7);
    }

    public double b(Entity db2) {
        double d2 = this.k - db2.k;
        double d3 = this.l - db2.l;
        double d4 = this.m - db2.m;
        return d2 * d2 + d3 * d3 + d4 * d4;
    }

    public void a(EntityPlayer entityplayer) {
    }

    public void c(Entity db2) {
        if (db2.e == this || db2.f == this) {
            return;
        }
        double d2 = db2.k - this.k;
        double d3 = db2.m - this.m;
        double d4 = MathHelper.a(d2, d3);
        if (d4 >= 0.009999999776482582) {
            d4 = MathHelper.a(d4);
            d2 /= d4;
            d3 /= d4;
            double d5 = 1.0 / d4;
            if (d5 > 1.0) {
                d5 = 1.0;
            }
            d2 *= d5;
            d3 *= d5;
            d2 *= 0.05000000074505806;
            d3 *= 0.05000000074505806;
            this.f(- (d2 *= (double)(1.0f - this.O)), 0.0, - (d3 *= (double)(1.0f - this.O)));
            db2.f(d2, 0.0, d3);
        }
    }

    public void f(double d2, double d3, double d4) {
        this.n += d2;
        this.o += d3;
        this.p += d4;
    }

    public boolean a(Entity db2, int n2) {
        return false;
    }

    public boolean c_() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public void b(Entity db2, int n2) {
    }

    public boolean c(r r2) {
        String string = this.q();
        if (this.A || string == null) {
            return false;
        }
        r2.a("id", string);
        this.d(r2);
        return true;
    }

    public void d(r r2) {
        r2.a("Pos", this.a(new double[]{this.k, this.l, this.m}));
        r2.a("Motion", this.a(new double[]{this.n, this.o, this.p}));
        r2.a("Rotation", this.a(new float[]{this.q, this.r}));
        r2.a("FallDistance", this.H);
        r2.a("Fire", (short)this.T);
        r2.a("Air", (short)this.X);
        r2.a("OnGround", this.v);
        this.a(r2);
    }

    public void e(r r2) {
        de de2 = r2.k("Pos");
        de de3 = r2.k("Motion");
        de de4 = r2.k("Rotation");
        this.a(0.0, 0.0, 0.0);
        this.n = ((dk)de3.a((int)0)).a;
        this.o = ((dk)de3.a((int)1)).a;
        this.p = ((dk)de3.a((int)2)).a;
        this.I = this.k = ((dk)de2.a((int)0)).a;
        this.h = this.k;
        this.J = this.l = ((dk)de2.a((int)1)).a;
        this.i = this.l;
        this.K = this.m = ((dk)de2.a((int)2)).a;
        this.j = this.m;
        this.s = this.q = ((k)de4.a((int)0)).a;
        this.t = this.r = ((k)de4.a((int)1)).a;
        this.H = r2.f("FallDistance");
        this.T = r2.c("Fire");
        this.X = r2.c("Air");
        this.v = r2.l("OnGround");
        this.a(this.k, this.l, this.m);
        this.b(r2);
    }

    protected final String q() {
        return EntityTypes.a(this);
    }

    protected abstract void b(r var1);

    protected abstract void a(r var1);

    protected /* varargs */ de a(double ... arrd) {
        de de2 = new de();
        for (double d2 : arrd) {
            de2.a(new dk(d2));
        }
        return de2;
    }

    protected /* varargs */ de a(float ... arrf) {
        de de2 = new de();
        for (float f2 : arrf) {
            de2.a(new k(f2));
        }
        return de2;
    }

    public fa a(int n2, int n3) {
        return this.a(n2, n3, 0.0f);
    }

    public fa a(int n2, int n3, float f2) {
        fa fa2 = new fa(this.g, this.k, this.l + (double)f2, this.m, new gc(n2, n3));
        fa2.ac = 10;
        this.g.a(fa2);
        return fa2;
    }

    public boolean r() {
        return !this.A;
    }

    public boolean s() {
        int n2 = MathHelper.b(this.k);
        int n3 = MathHelper.b(this.l + (double)this.n());
        int n4 = MathHelper.b(this.m);
        return this.g.d(n2, n3, n4);
    }

    public AxisAlignedBB d(Entity db2) {
        return null;
    }

    public void t() {
        if (this.f.A) {
            this.f = null;
            return;
        }
        this.n = 0.0;
        this.o = 0.0;
        this.p = 0.0;
        this.b_();
        this.f.u();
        this.ae += (double)(this.f.q - this.f.s);
        this.ad += (double)(this.f.r - this.f.t);
        while (this.ae >= 180.0) {
            this.ae -= 360.0;
        }
        while (this.ae < -180.0) {
            this.ae += 360.0;
        }
        while (this.ad >= 180.0) {
            this.ad -= 360.0;
        }
        while (this.ad < -180.0) {
            this.ad += 360.0;
        }
        double d2 = this.ae * 0.5;
        double d3 = this.ad * 0.5;
        float f2 = 10.0f;
        if (d2 > (double)f2) {
            d2 = f2;
        }
        if (d2 < (double)(- f2)) {
            d2 = - f2;
        }
        if (d3 > (double)f2) {
            d3 = f2;
        }
        if (d3 < (double)(- f2)) {
            d3 = - f2;
        }
        this.ae -= d2;
        this.ad -= d3;
        this.q = (float)((double)this.q + d2);
        this.r = (float)((double)this.r + d3);
    }

    protected void u() {
        this.e.a(this.k, this.l + this.w() + this.e.v(), this.m);
    }

    public double v() {
        return this.B;
    }

    public double w() {
        return (double)this.D * 0.75;
    }

    public void e(Entity db2) {
        this.ad = 0.0;
        this.ae = 0.0;
        if (this.f == db2) {
            this.f.e = null;
            this.f = null;
            this.c(db2.k, db2.u.b + (double)db2.D, db2.m, this.q, this.r);
            return;
        }
        if (this.f != null) {
            this.f.e = null;
        }
        if (db2.e != null) {
            db2.e.f = null;
        }
        this.f = db2;
        db2.e = this;
    }
}

