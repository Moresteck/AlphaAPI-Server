/*
 * Decompiled with CFR 0_132.
 */
import java.util.List;
import java.util.Random;

// EntityArrow ?
public class da
extends Entity {
    private int b = -1;
    private int ac = -1;
    private int ad = -1;
    private int ae = 0;
    private boolean af = false;
    public int a = 0;
    private EntityLiving ag;
    private int ah;
    private int ai = 0;

    public da(World dp2) {
        super(dp2);
        this.a(0.5f, 0.5f);
    }

    public da(World dp2, EntityLiving ic2) {
        super(dp2);
        this.ag = ic2;
        this.a(0.5f, 0.5f);
        this.c(ic2.k, ic2.l, ic2.m, ic2.q, ic2.r);
        this.k -= (double)(fw.b(this.q / 180.0f * 3.1415927f) * 0.16f);
        this.l -= 0.10000000149011612;
        this.m -= (double)(fw.a(this.q / 180.0f * 3.1415927f) * 0.16f);
        this.a(this.k, this.l, this.m);
        this.B = 0.0f;
        this.n = (- fw.a(this.q / 180.0f * 3.1415927f)) * fw.b(this.r / 180.0f * 3.1415927f);
        this.p = fw.b(this.q / 180.0f * 3.1415927f) * fw.b(this.r / 180.0f * 3.1415927f);
        this.o = - fw.a(this.r / 180.0f * 3.1415927f);
        this.a(this.n, this.o, this.p, 1.5f, 1.0f);
    }

    public void a(double d2, double d3, double d4, float f2, float f3) {
        float f4 = fw.a(d2 * d2 + d3 * d3 + d4 * d4);
        d2 /= (double)f4;
        d3 /= (double)f4;
        d4 /= (double)f4;
        d2 += this.Q.nextGaussian() * 0.007499999832361937 * (double)f3;
        d3 += this.Q.nextGaussian() * 0.007499999832361937 * (double)f3;
        d4 += this.Q.nextGaussian() * 0.007499999832361937 * (double)f3;
        this.n = d2 *= (double)f2;
        this.o = d3 *= (double)f2;
        this.p = d4 *= (double)f2;
        float f5 = fw.a(d2 * d2 + d4 * d4);
        this.s = this.q = (float)(Math.atan2(d2, d4) * 180.0 / 3.1415927410125732);
        this.t = this.r = (float)(Math.atan2(d3, f5) * 180.0 / 3.1415927410125732);
        this.ah = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void b_() {
        float f2;
        super.b_();
        if (this.a > 0) {
            --this.a;
        }
        if (this.af) {
            int n2 = this.g.a(this.b, this.ac, this.ad);
            if (n2 == this.ae) {
                ++this.ah;
                if (this.ah != 1200) return;
                this.i();
                return;
            }
            this.af = false;
            this.n *= (double)(this.Q.nextFloat() * 0.2f);
            this.o *= (double)(this.Q.nextFloat() * 0.2f);
            this.p *= (double)(this.Q.nextFloat() * 0.2f);
            this.ah = 0;
            this.ai = 0;
        } else {
            ++this.ai;
        }
        Vec3D as2 = Vec3D.b(this.k, this.l, this.m);
        Vec3D as3 = Vec3D.b(this.k + this.n, this.l + this.o, this.m + this.p);
        fe fe2 = this.g.a(as2, as3);
        as2 = Vec3D.b(this.k, this.l, this.m);
        as3 = Vec3D.b(this.k + this.n, this.l + this.o, this.m + this.p);
        if (fe2 != null) {
            as3 = Vec3D.b(fe2.f.a, fe2.f.b, fe2.f.c);
        }
        Entity db2 = null;
        List list = this.g.b(this, this.u.a(this.n, this.o, this.p).b(1.0, 1.0, 1.0));
        double d2 = 0.0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            double d3;
            fe fe3;
            AxisAlignedBB cy2;
            Entity db3 = (Entity)list.get(i2);
            if (!db3.c_() || db3 == this.ag && this.ai < 5 || (fe3 = (cy2 = db3.u.b(f2 = 0.3f, f2, f2)).a(as2, as3)) == null || (d3 = as2.a(fe3.f)) >= d2 && d2 != 0.0) continue;
            db2 = db3;
            d2 = d3;
        }
        if (db2 != null) {
            fe2 = new fe(db2);
        }
        if (fe2 != null) {
            if (fe2.g != null) {
                if (fe2.g.a(this.ag, 4)) {
                    this.g.a(this, "random.drr", 1.0f, 1.2f / (this.Q.nextFloat() * 0.2f + 0.9f));
                    this.i();
                } else {
                    this.n *= -0.10000000149011612;
                    this.o *= -0.10000000149011612;
                    this.p *= -0.10000000149011612;
                    this.q += 180.0f;
                    this.s += 180.0f;
                    this.ai = 0;
                }
            } else {
                this.b = fe2.b;
                this.ac = fe2.c;
                this.ad = fe2.d;
                this.ae = this.g.a(this.b, this.ac, this.ad);
                this.n = (float)(fe2.f.a - this.k);
                this.o = (float)(fe2.f.b - this.l);
                this.p = (float)(fe2.f.c - this.m);
                float f3 = fw.a(this.n * this.n + this.o * this.o + this.p * this.p);
                this.k -= this.n / (double)f3 * 0.05000000074505806;
                this.l -= this.o / (double)f3 * 0.05000000074505806;
                this.m -= this.p / (double)f3 * 0.05000000074505806;
                this.g.a(this, "random.drr", 1.0f, 1.2f / (this.Q.nextFloat() * 0.2f + 0.9f));
                this.af = true;
                this.a = 7;
            }
        }
        this.k += this.n;
        this.l += this.o;
        this.m += this.p;
        float f4 = fw.a(this.n * this.n + this.p * this.p);
        this.q = (float)(Math.atan2(this.n, this.p) * 180.0 / 3.1415927410125732);
        this.r = (float)(Math.atan2(this.o, f4) * 180.0 / 3.1415927410125732);
        while (this.r - this.t < -180.0f) {
            this.t -= 360.0f;
        }
        while (this.r - this.t >= 180.0f) {
            this.t += 360.0f;
        }
        while (this.q - this.s < -180.0f) {
            this.s -= 360.0f;
        }
        while (this.q - this.s >= 180.0f) {
            this.s += 360.0f;
        }
        this.r = this.t + (this.r - this.t) * 0.2f;
        this.q = this.s + (this.q - this.s) * 0.2f;
        float f5 = 0.99f;
        f2 = 0.03f;
        if (this.m()) {
            for (int i3 = 0; i3 < 4; ++i3) {
                float f6 = 0.25f;
                this.g.a("bubble", this.k - this.n * (double)f6, this.l - this.o * (double)f6, this.m - this.p * (double)f6, this.n, this.o, this.p);
            }
            f5 = 0.8f;
        }
        this.n *= (double)f5;
        this.o *= (double)f5;
        this.p *= (double)f5;
        this.o -= (double)f2;
        this.a(this.k, this.l, this.m);
    }

    public void a(r r2) {
        r2.a("xTile", (short)this.b);
        r2.a("yTile", (short)this.ac);
        r2.a("zTile", (short)this.ad);
        r2.a("inTile", (byte)this.ae);
        r2.a("shake", (byte)this.a);
        r2.a("inGround", (byte)(this.af ? 1 : 0));
    }

    public void b(r r2) {
        this.b = r2.c("xTile");
        this.ac = r2.c("yTile");
        this.ad = r2.c("zTile");
        this.ae = r2.b("inTile") & 255;
        this.a = r2.b("shake") & 255;
        this.af = r2.b("inGround") == 1;
    }

    public void a(eq eq2) {
        if (this.af && this.ag == eq2 && this.a <= 0 && eq2.ai.a(new gc(en.j.aQ, 1))) {
            this.g.a(this, "random.pop", 0.2f, ((this.Q.nextFloat() - this.Q.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            eq2.c(this, 1);
            this.i();
        }
    }
}

