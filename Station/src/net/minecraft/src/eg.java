/*
 * Decompiled with CFR 0_132.
 */
import java.util.List;
import java.util.Random;

public class eg
extends Entity {
    public int a = 0;
    public int b = 0;
    public int ac = 1;

    public eg(World dp2) {
        super(dp2);
        this.d = true;
        this.a(1.5f, 0.6f);
        this.B = this.D / 2.0f;
        this.G = false;
    }

    public AxisAlignedBB d(Entity db2) {
        return db2.u;
    }

    public AxisAlignedBB l() {
        return this.u;
    }

    public boolean p() {
        return true;
    }

    public double w() {
        return (double)this.D * 0.0 - 0.30000001192092896;
    }

    public boolean a(Entity db2, int n2) {
        this.ac = - this.ac;
        this.b = 10;
        this.a += n2 * 10;
        if (this.a > 40) {
            int n3;
            for (n3 = 0; n3 < 3; ++n3) {
                this.a(Block.x.ba, 1, 0.0f);
            }
            for (n3 = 0; n3 < 2; ++n3) {
                this.a(en.B.aQ, 1, 0.0f);
            }
            this.i();
        }
        return true;
    }

    public boolean c_() {
        return !this.A;
    }

    public void b_() {
        double d2;
        double d3;
        double d4;
        super.b_();
        if (this.b > 0) {
            --this.b;
        }
        if (this.a > 0) {
            --this.a;
        }
        this.h = this.k;
        this.i = this.l;
        this.j = this.m;
        int n2 = 5;
        double d5 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d6 = this.u.b + (this.u.e - this.u.b) * (double)(i2 + 0) / (double)n2 - 0.125;
            double d7 = this.u.b + (this.u.e - this.u.b) * (double)(i2 + 1) / (double)n2 - 0.125;
            AxisAlignedBB cy2 = AxisAlignedBB.b(this.u.a, d6, this.u.c, this.u.d, d7, this.u.f);
            if (!this.g.b(cy2, hz.f)) continue;
            d5 += 1.0 / (double)n2;
        }
        double d8 = d5 * 2.0 - 1.0;
        this.o += 0.03999999910593033 * d8;
        if (this.e != null) {
            this.n += this.e.n * 0.2;
            this.p += this.e.p * 0.2;
        }
        if (this.n < - (d4 = 0.4)) {
            this.n = - d4;
        }
        if (this.n > d4) {
            this.n = d4;
        }
        if (this.p < - d4) {
            this.p = - d4;
        }
        if (this.p > d4) {
            this.p = d4;
        }
        if (this.v) {
            this.n *= 0.5;
            this.o *= 0.5;
            this.p *= 0.5;
        }
        this.c(this.n, this.o, this.p);
        double d9 = Math.sqrt(this.n * this.n + this.p * this.p);
        if (d9 > 0.15) {
            double d10 = Math.cos((double)this.q * 3.141592653589793 / 180.0);
            d2 = Math.sin((double)this.q * 3.141592653589793 / 180.0);
            int n3 = 0;
            while ((double)n3 < 1.0 + d9 * 60.0) {
                double d11;
                double d12;
                double d13 = this.Q.nextFloat() * 2.0f - 1.0f;
                double d14 = (double)(this.Q.nextInt(2) * 2 - 1) * 0.7;
                if (this.Q.nextBoolean()) {
                    d12 = this.k - d10 * d13 * 0.8 + d2 * d14;
                    d11 = this.m - d2 * d13 * 0.8 - d10 * d14;
                    this.g.a("splash", d12, this.l - 0.125, d11, this.n, this.o, this.p);
                } else {
                    d12 = this.k + d10 + d2 * d13 * 0.7;
                    d11 = this.m + d2 - d10 * d13 * 0.7;
                    this.g.a("splash", d12, this.l - 0.125, d11, this.n, this.o, this.p);
                }
                ++n3;
            }
        }
        if (this.w && d9 > 0.15) {
            int n4;
            this.i();
            for (n4 = 0; n4 < 3; ++n4) {
                this.a(Block.x.ba, 1, 0.0f);
            }
            for (n4 = 0; n4 < 2; ++n4) {
                this.a(en.B.aQ, 1, 0.0f);
            }
        } else {
            this.n *= 0.9900000095367432;
            this.o *= 0.949999988079071;
            this.p *= 0.9900000095367432;
        }
        this.r = 0.0f;
        double d15 = this.q;
        d2 = this.h - this.k;
        double d16 = this.j - this.m;
        if (d2 * d2 + d16 * d16 > 0.001) {
            d15 = (float)(Math.atan2(d16, d2) * 180.0 / 3.141592653589793);
        }
        for (d3 = d15 - (double)this.q; d3 >= 180.0; d3 -= 360.0) {
        }
        while (d3 < -180.0) {
            d3 += 360.0;
        }
        if (d3 > 20.0) {
            d3 = 20.0;
        }
        if (d3 < -20.0) {
            d3 = -20.0;
        }
        this.q = (float)((double)this.q + d3);
        this.b(this.q, this.r);
        List list = this.g.b(this, this.u.b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); ++i3) {
                Entity db2 = (Entity)list.get(i3);
                if (db2 == this.e || !db2.p() || !(db2 instanceof eg)) continue;
                db2.c(this);
            }
        }
        if (this.e != null && this.e.A) {
            this.e = null;
        }
    }

    protected void u() {
        double d2 = Math.cos((double)this.q * 3.141592653589793 / 180.0) * 0.4;
        double d3 = Math.sin((double)this.q * 3.141592653589793 / 180.0) * 0.4;
        this.e.a(this.k + d2, this.l + this.w() + this.e.v(), this.m + d3);
    }

    protected void a(r r2) {
    }

    protected void b(r r2) {
    }
}

