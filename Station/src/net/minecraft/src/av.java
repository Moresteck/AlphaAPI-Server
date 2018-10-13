package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.List;
import java.util.Random;

// EntitySnowball ?
public class av
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

    public av(World dp2) {
        super(dp2);
        this.a(0.25f, 0.25f);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void b_() {
        int n2;
        float f2;
        super.b_();
        if (this.a > 0) {
            --this.a;
        }
        if (this.af) {
            int n3 = this.g.a(this.b, this.ac, this.ad);
            if (n3 == this.ae) {
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
        for (n2 = 0; n2 < list.size(); ++n2) {
            fe fe3;
            double d3;
            AxisAlignedBB cy2;
            Entity db3 = (Entity)list.get(n2);
            if (!db3.c_() || db3 == this.ag && this.ai < 5 || (fe3 = (cy2 = db3.u.b(f2 = 0.3f, f2, f2)).a(as2, as3)) == null || (d3 = as2.a(fe3.f)) >= d2 && d2 != 0.0) continue;
            db2 = db3;
            d2 = d3;
        }
        if (db2 != null) {
            fe2 = new fe(db2);
        }
        if (fe2 != null) {
            if (fe2.g == null || fe2.g.a(this.ag, 0)) {
                // empty if block
            }
            for (n2 = 0; n2 < 8; ++n2) {
                this.g.a("snowballpoof", this.k, this.l, this.m, 0.0, 0.0, 0.0);
            }
            this.i();
        }
        this.k += this.n;
        this.l += this.o;
        this.m += this.p;
        float f3 = fw.a(this.n * this.n + this.p * this.p);
        this.q = (float)(Math.atan2(this.n, this.p) * 180.0 / 3.1415927410125732);
        this.r = (float)(Math.atan2(this.o, f3) * 180.0 / 3.1415927410125732);
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
        float f4 = 0.99f;
        f2 = 0.03f;
        if (this.m()) {
            for (int i2 = 0; i2 < 4; ++i2) {
                float f5 = 0.25f;
                this.g.a("bubble", this.k - this.n * (double)f5, this.l - this.o * (double)f5, this.m - this.p * (double)f5, this.n, this.o, this.p);
            }
            f4 = 0.8f;
        }
        this.n *= (double)f4;
        this.o *= (double)f4;
        this.p *= (double)f4;
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

