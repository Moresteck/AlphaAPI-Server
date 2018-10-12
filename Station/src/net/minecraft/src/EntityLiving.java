/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.List;
import java.util.Random;

public class EntityLiving
extends Entity {
    public int aq = 20;
    public float ar;
    public float as;
    public float at;
    public float au = 0.0f;
    public float av = 0.0f;
    protected float aw;
    protected float ax;
    protected float ay;
    protected float az;
    protected boolean aA = true;
    protected String aB = "/char.png";
    protected boolean aC = true;
    protected float aD = 0.0f;
    protected String aE = null;
    protected float aF = 1.0f;
    protected int aG = 0;
    protected float aH = 0.0f;
    public float aI;
    public float aJ;
    public int aK = 10;
    public int aL;
    private int a;
    public int aM;
    public int aN;
    public float aO = 0.0f;
    public int aP = 0;
    public int aQ = 0;
    public float aR;
    public float aS;
    protected boolean aT = false;
    public int aU = -1;
    public float aV = (float)(Math.random() * 0.8999999761581421 + 0.10000000149011612);
    public float aW;
    public float aX;
    public float aY;
    protected int aZ = 0;
    protected float ba;
    protected float bb;
    protected float bc;
    protected boolean bd = false;
    protected float be = 0.0f;
    protected float bf = 0.7f;
    private Entity b;
    private int ac = 0;

    public EntityLiving(World dp2) {
        super(dp2);
        this.d = true;
        this.at = (float)(Math.random() + 1.0) * 0.01f;
        this.a(this.k, this.l, this.m);
        this.ar = (float)Math.random() * 12398.0f;
        this.q = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.as = 1.0f;
        this.M = 0.5f;
    }

    protected boolean g(Entity entity) {
        return this.g.a(Vec3D.b(this.k, this.l + (double)this.n(), this.m), Vec3D.b(entity.k, entity.l + (double)entity.n(), entity.m)) == null;
    }

    public boolean c_() {
        return !this.A;
    }

    public boolean p() {
        return !this.A;
    }

    protected float n() {
        return this.D * 0.85f;
    }

    public int b() {
        return 80;
    }

    public void j() {
        this.aI = this.aJ;
        super.j();
        if (this.Q.nextInt(1000) < this.a++) {
            this.a = - this.b();
            String string = this.c();
            if (string != null) {
                this.g.a(this, string, this.f(), (this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f + 1.0f);
            }
        }
        if (this.r() && this.s()) {
            this.a(null, 1);
        }
        if (this.r() && this.a(hz.f)) {
            --this.X;
            if (this.X == -20) {
                this.X = 0;
                for (int i2 = 0; i2 < 8; ++i2) {
                    float f2 = this.Q.nextFloat() - this.Q.nextFloat();
                    float f3 = this.Q.nextFloat() - this.Q.nextFloat();
                    float f4 = this.Q.nextFloat() - this.Q.nextFloat();
                    this.g.a("bubble", this.k + (double)f2, this.l + (double)f3, this.m + (double)f4, this.n, this.o, this.p);
                }
                this.a(null, 2);
            }
            this.T = 0;
        } else {
            this.X = this.U;
        }
        this.aR = this.aS;
        if (this.aQ > 0) {
            --this.aQ;
        }
        if (this.aM > 0) {
            --this.aM;
        }
        if (this.W > 0) {
            --this.W;
        }
        if (this.aK <= 0) {
            ++this.aP;
            if (this.aP > 20) {
                this.F();
                this.i();
                for (int i3 = 0; i3 < 20; ++i3) {
                    double d2 = this.Q.nextGaussian() * 0.02;
                    double d3 = this.Q.nextGaussian() * 0.02;
                    double d4 = this.Q.nextGaussian() * 0.02;
                    this.g.a("explode", this.k + (double)(this.Q.nextFloat() * this.C * 2.0f) - (double)this.C, this.l + (double)(this.Q.nextFloat() * this.D), this.m + (double)(this.Q.nextFloat() * this.C * 2.0f) - (double)this.C, d2, d3, d4);
                }
            }
        }
        this.az = this.ay;
        this.av = this.au;
        this.s = this.q;
        this.t = this.r;
    }

    public void C() {
        for (int i2 = 0; i2 < 20; ++i2) {
            double d2 = this.Q.nextGaussian() * 0.02;
            double d3 = this.Q.nextGaussian() * 0.02;
            double d4 = this.Q.nextGaussian() * 0.02;
            double d5 = 10.0;
            this.g.a("explode", this.k + (double)(this.Q.nextFloat() * this.C * 2.0f) - (double)this.C - d2 * d5, this.l + (double)(this.Q.nextFloat() * this.D) - d3 * d5, this.m + (double)(this.Q.nextFloat() * this.C * 2.0f) - (double)this.C - d4 * d5, d2, d3, d4);
        }
    }

    public void t() {
        super.t();
        this.aw = this.ax;
        this.ax = 0.0f;
    }

    public void b_() {
        boolean bl2;
        float f2;
        float f3;
        super.b_();
        this.x();
        double d2 = this.k - this.h;
        double d3 = this.m - this.j;
        float f4 = fw.a(d2 * d2 + d3 * d3);
        float f5 = this.au;
        float f6 = 0.0f;
        this.aw = this.ax;
        float f7 = 0.0f;
        if (f4 > 0.05f) {
            f7 = 1.0f;
            f6 = f4 * 3.0f;
            f5 = (float)Math.atan2(d3, d2) * 180.0f / 3.1415927f - 90.0f;
        }
        if (this.aJ > 0.0f) {
            f5 = this.q;
        }
        if (!this.v) {
            f7 = 0.0f;
        }
        this.ax += (f7 - this.ax) * 0.3f;
        for (f3 = f5 - this.au; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        this.au += f3 * 0.3f;
        for (f2 = this.q - this.au; f2 < -180.0f; f2 += 360.0f) {
        }
        while (f2 >= 180.0f) {
            f2 -= 360.0f;
        }
        boolean bl3 = bl2 = f2 < -90.0f || f2 >= 90.0f;
        if (f2 < -75.0f) {
            f2 = -75.0f;
        }
        if (f2 >= 75.0f) {
            f2 = 75.0f;
        }
        this.au = this.q - f2;
        if (f2 * f2 > 2500.0f) {
            this.au += f2 * 0.2f;
        }
        if (bl2) {
            f6 *= -1.0f;
        }
        while (this.q - this.s < -180.0f) {
            this.s -= 360.0f;
        }
        while (this.q - this.s >= 180.0f) {
            this.s += 360.0f;
        }
        while (this.au - this.av < -180.0f) {
            this.av -= 360.0f;
        }
        while (this.au - this.av >= 180.0f) {
            this.av += 360.0f;
        }
        while (this.r - this.t < -180.0f) {
            this.t -= 360.0f;
        }
        while (this.r - this.t >= 180.0f) {
            this.t += 360.0f;
        }
        this.ay += f6;
    }

    protected void a(float f2, float f3) {
        super.a(f2, f3);
    }

    public void a(int n2) {
        if (this.aK <= 0) {
            return;
        }
        this.aK += n2;
        if (this.aK > 20) {
            this.aK = 20;
        }
        this.W = this.aq / 2;
    }

    public boolean a(Entity db2, int n2) {
        this.aZ = 0;
        if (this.aK <= 0) {
            return false;
        }
        this.aX = 1.5f;
        if ((float)this.W > (float)this.aq / 2.0f) {
            if (this.aL - n2 >= this.aK) {
                return false;
            }
            this.aK = this.aL - n2;
        } else {
            this.aL = this.aK;
            this.W = this.aq;
            this.aK -= n2;
            this.aN = 10;
            this.aM = 10;
        }
        this.aO = 0.0f;
        if (db2 != null) {
            double d2 = db2.k - this.k;
            double d3 = db2.m - this.m;
            while (d2 * d2 + d3 * d3 < 1.0E-4) {
                d2 = (Math.random() - Math.random()) * 0.01;
                d3 = (Math.random() - Math.random()) * 0.01;
            }
            this.aO = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - this.q;
            this.a(db2, n2, d2, d3);
        } else {
            this.aO = (int)(Math.random() * 2.0) * 180;
        }
        if (this.aK <= 0) {
            this.g.a(this, this.e(), this.f(), (this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f + 1.0f);
            this.f(db2);
        } else {
            this.g.a(this, this.d(), this.f(), (this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f + 1.0f);
        }
        return true;
    }

    protected float f() {
        return 1.0f;
    }

    protected String c() {
        return null;
    }

    protected String d() {
        return "random.hurt";
    }

    protected String e() {
        return "random.hurt";
    }

    public void a(Entity db2, int n2, double d2, double d3) {
        float f2 = fw.a(d2 * d2 + d3 * d3);
        float f3 = 0.4f;
        this.n /= 2.0;
        this.o /= 2.0;
        this.p /= 2.0;
        this.n -= d2 / (double)f2 * (double)f3;
        this.o += 0.4000000059604645;
        this.p -= d3 / (double)f2 * (double)f3;
        if (this.o > 0.4000000059604645) {
            this.o = 0.4000000059604645;
        }
    }

    public void f(Entity db2) {
        if (this.aG > 0 && db2 != null) {
            db2.b(this, this.aG);
        }
        this.aT = true;
        int n2 = this.g();
        if (n2 > 0) {
            int n3 = this.Q.nextInt(3);
            for (int i2 = 0; i2 < n3; ++i2) {
                this.a(n2, 1);
            }
        }
    }

    protected int g() {
        return 0;
    }

    protected void a(float f2) {
        int n2 = (int)Math.ceil(f2 - 3.0f);
        if (n2 > 0) {
            this.a(null, n2);
            int n3 = this.g.a(fw.b(this.k), fw.b(this.l - 0.20000000298023224 - (double)this.B), fw.b(this.m));
            if (n3 > 0) {
                bl bl2 = Block.n[n3].bj;
                this.g.a(this, bl2.c(), bl2.a() * 0.5f, bl2.b() * 0.75f);
            }
        }
    }

    public void c(float f2, float f3) {
        double d2;
        if (this.m()) {
            d2 = this.l;
            this.a(f2, f3, 0.02f);
            this.c(this.n, this.o, this.p);
            this.n *= 0.800000011920929;
            this.o *= 0.800000011920929;
            this.p *= 0.800000011920929;
            this.o -= 0.02;
            if (this.w && this.b(this.n, this.o + 0.6000000238418579 - this.l + d2, this.p)) {
                this.o = 0.30000001192092896;
            }
        } else if (this.o()) {
            double d3 = this.l;
            this.a(f2, f3, 0.02f);
            this.c(this.n, this.o, this.p);
            this.n *= 0.5;
            this.o *= 0.5;
            this.p *= 0.5;
            this.o -= 0.02;
            if (this.w && this.b(this.n, this.o + 0.6000000238418579 - this.l + d3, this.p)) {
                this.o = 0.30000001192092896;
            }
        } else {
            float f4 = 0.91f;
            if (this.v) {
                f4 = 0.54600006f;
                int n2 = this.g.a(fw.b(this.k), fw.b(this.u.b) - 1, fw.b(this.m));
                if (n2 > 0) {
                    f4 = Block.n[n2].bm * 0.91f;
                }
            }
            float f5 = 0.16277136f / (f4 * f4 * f4);
            this.a(f2, f3, this.v ? 0.1f * f5 : 0.02f);
            f4 = 0.91f;
            if (this.v) {
                f4 = 0.54600006f;
                int n3 = this.g.a(fw.b(this.k), fw.b(this.u.b) - 1, fw.b(this.m));
                if (n3 > 0) {
                    f4 = Block.n[n3].bm * 0.91f;
                }
            }
            if (this.D()) {
                this.H = 0.0f;
                if (this.o < -0.15) {
                    this.o = -0.15;
                }
            }
            this.c(this.n, this.o, this.p);
            if (this.w && this.D()) {
                this.o = 0.2;
            }
            this.o -= 0.08;
            this.o *= 0.9800000190734863;
            this.n *= (double)f4;
            this.p *= (double)f4;
        }
        this.aW = this.aX;
        d2 = this.k - this.h;
        double d4 = this.m - this.j;
        float f6 = fw.a(d2 * d2 + d4 * d4) * 4.0f;
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.aX += (f6 - this.aX) * 0.4f;
        this.aY += this.aX;
    }

    public boolean D() {
        int n2;
        int n3;
        int n4 = fw.b(this.k);
        return this.g.a(n4, n2 = fw.b(this.u.b), n3 = fw.b(this.m)) == Block.aF.ba || this.g.a(n4, n2 + 1, n3) == Block.aF.ba;
    }

    public void a(r r2) {
        r2.a("Health", (short)this.aK);
        r2.a("HurtTime", (short)this.aM);
        r2.a("DeathTime", (short)this.aP);
        r2.a("AttackTime", (short)this.aQ);
    }

    public void b(r r2) {
        this.aK = r2.c("Health");
        if (!r2.a("Health")) {
            this.aK = 10;
        }
        this.aM = r2.c("HurtTime");
        this.aP = r2.c("DeathTime");
        this.aQ = r2.c("AttackTime");
    }

    public boolean r() {
        return !this.A && this.aK > 0;
    }

    public void x() {
        if (this.aK <= 0) {
            this.bd = false;
            this.ba = 0.0f;
            this.bb = 0.0f;
            this.bc = 0.0f;
        } else {
            this.d_();
        }
        boolean bl2 = this.m();
        boolean bl3 = this.o();
        if (this.bd) {
            if (bl2) {
                this.o += 0.03999999910593033;
            } else if (bl3) {
                this.o += 0.03999999910593033;
            } else if (this.v) {
                this.E();
            }
        }
        this.ba *= 0.98f;
        this.bb *= 0.98f;
        this.bc *= 0.9f;
        this.c(this.ba, this.bb);
        List list = this.g.b(this, this.u.b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                Entity db2 = (Entity)list.get(i2);
                if (!db2.p()) continue;
                db2.c(this);
            }
        }
    }

    protected void E() {
        this.o = 0.41999998688697815;
    }

    protected void d_() {
        ++this.aZ;
        EntityPlayer entityplayer = this.g.a((Entity)this, -1.0);
        if (entityplayer != null) {
            double d2 = entityplayer.k - this.k;
            double d3 = entityplayer.l - this.l;
            double d4 = entityplayer.m - this.m;
            double d5 = d2 * d2 + d3 * d3 + d4 * d4;
            if (d5 > 16384.0) {
                this.i();
            }
            if (this.aZ > 600 && this.Q.nextInt(800) == 0) {
                if (d5 < 1024.0) {
                    this.aZ = 0;
                } else {
                    this.i();
                }
            }
        }
        this.ba = 0.0f;
        this.bb = 0.0f;
        float f2 = 8.0f;
        if (this.Q.nextFloat() < 0.02f) {
            entityplayer = this.g.a((Entity)this, f2);
            if (entityplayer != null) {
                this.b = entityplayer;
                this.ac = 10 + this.Q.nextInt(20);
            } else {
                this.bc = (this.Q.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.b != null) {
            this.b(this.b, 10.0f);
            if (this.ac-- <= 0 || this.b.A || this.b.b(this) > (double)(f2 * f2)) {
                this.b = null;
            }
        } else {
            if (this.Q.nextFloat() < 0.05f) {
                this.bc = (this.Q.nextFloat() - 0.5f) * 20.0f;
            }
            this.q += this.bc;
            this.r = this.be;
        }
        boolean bl2 = this.m();
        boolean bl3 = this.o();
        if (bl2 || bl3) {
            this.bd = this.Q.nextFloat() < 0.8f;
        }
    }

    public void b(Entity db2, float f2) {
        double d2;
        double d3 = db2.k - this.k;
        double d4 = db2.m - this.m;
        if (db2 instanceof EntityLiving) {
            EntityLiving ic2 = (EntityLiving)db2;
            d2 = ic2.l + (double)ic2.n() - (this.l + (double)this.n());
        } else {
            d2 = (db2.u.b + db2.u.e) / 2.0 - (this.l + (double)this.n());
        }
        double d5 = fw.a(d3 * d3 + d4 * d4);
        float f3 = (float)(Math.atan2(d4, d3) * 180.0 / 3.1415927410125732) - 90.0f;
        float f4 = (float)(Math.atan2(d2, d5) * 180.0 / 3.1415927410125732);
        this.r = this.b(this.r, f4, f2);
        this.q = this.b(this.q, f3, f2);
    }

    private float b(float f2, float f3, float f4) {
        float f5;
        for (f5 = f3 - f2; f5 < -180.0f; f5 += 360.0f) {
        }
        while (f5 >= 180.0f) {
            f5 -= 360.0f;
        }
        if (f5 > f4) {
            f5 = f4;
        }
        if (f5 < - f4) {
            f5 = - f4;
        }
        return f2 + f5;
    }

    public void F() {
    }

    public boolean a() {
        return this.g.a(this.u) && this.g.a((Entity)this, this.u).size() == 0 && !this.g.b(this.u);
    }

    protected void k() {
        this.a(null, 4);
    }

    public Vec3D c(float f2) {
        if (f2 == 1.0f) {
            return Vec3D.b(this.k, this.l, this.m);
        }
        double d2 = this.h + (this.k - this.h) * (double)f2;
        double d3 = this.i + (this.l - this.i) * (double)f2;
        double d4 = this.j + (this.m - this.j) * (double)f2;
        return Vec3D.b(d2, d3, d4);
    }

    public Vec3D d(float f2) {
        if (f2 == 1.0f) {
            float f3 = fw.b((- this.q) * 0.017453292f - 3.1415927f);
            float f4 = fw.a((- this.q) * 0.017453292f - 3.1415927f);
            float f5 = - fw.b((- this.r) * 0.017453292f);
            float f6 = fw.a((- this.r) * 0.017453292f);
            return Vec3D.b(f4 * f5, f6, f3 * f5);
        }
        float f7 = this.t + (this.r - this.t) * f2;
        float f8 = this.s + (this.q - this.s) * f2;
        float f9 = fw.b((- f8) * 0.017453292f - 3.1415927f);
        float f10 = fw.a((- f8) * 0.017453292f - 3.1415927f);
        float f11 = - fw.b((- f7) * 0.017453292f);
        float f12 = fw.a((- f7) * 0.017453292f);
        return Vec3D.b(f10 * f11, f12, f9 * f11);
    }

    public fe a(double d2, float f2) {
        Vec3D as2 = this.c(f2);
        Vec3D as3 = this.d(f2);
        Vec3D as4 = as2.c(as3.a * d2, as3.b * d2, as3.c * d2);
        return this.g.a(as2, as4);
    }
}

