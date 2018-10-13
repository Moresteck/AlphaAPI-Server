package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class fa
extends Entity {
    public gc a;
    private int ae;
    public int b = 0;
    public int ac;
    private int af = 5;
    public float ad = (float)(Math.random() * 3.141592653589793 * 2.0);

    public fa(World dp2, double d2, double d3, double d4, gc gc2) {
        super(dp2);
        this.a(0.25f, 0.25f);
        this.B = this.D / 2.0f;
        this.a(d2, d3, d4);
        this.a = gc2;
        this.q = (float)(Math.random() * 360.0);
        this.n = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612);
        this.o = 0.20000000298023224;
        this.p = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612);
        this.G = false;
    }

    public fa(World dp2) {
        super(dp2);
        this.a(0.25f, 0.25f);
        this.B = this.D / 2.0f;
    }

    public void b_() {
        super.b_();
        if (this.ac > 0) {
            --this.ac;
        }
        this.h = this.k;
        this.i = this.l;
        this.j = this.m;
        this.o -= 0.03999999910593033;
        if (this.g.c(MathHelper.b(this.k), MathHelper.b(this.l), MathHelper.b(this.m)) == Material.PlayerListBox) {
            this.o = 0.20000000298023224;
            this.n = (this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f;
            this.p = (this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f;
            this.g.a(this, "random.fizz", 0.4f, 2.0f + this.Q.nextFloat() * 0.4f);
        }
        this.g(this.k, this.l, this.m);
        this.m();
        this.c(this.n, this.o, this.p);
        float f2 = 0.98f;
        if (this.v) {
            f2 = 0.58800006f;
            int n2 = this.g.a(MathHelper.b(this.k), MathHelper.b(this.u.b) - 1, MathHelper.b(this.m));
            if (n2 > 0) {
                f2 = Block.n[n2].bm * 0.98f;
            }
        }
        this.n *= (double)f2;
        this.o *= 0.9800000190734863;
        this.p *= (double)f2;
        if (this.v) {
            this.o *= -0.5;
        }
        ++this.ae;
        ++this.b;
        if (this.b >= 6000) {
            this.i();
        }
    }

    public boolean m() {
        return this.g.a(this.u, Material.f, this);
    }

    private boolean g(double d2, double d3, double d4) {
        int n2 = MathHelper.b(d2);
        int n3 = MathHelper.b(d3);
        int n4 = MathHelper.b(d4);
        double d5 = d2 - (double)n2;
        double d6 = d3 - (double)n3;
        double d7 = d4 - (double)n4;
        if (Block.p[this.g.a(n2, n3, n4)]) {
            boolean bl2 = !Block.p[this.g.a(n2 - 1, n3, n4)];
            boolean bl3 = !Block.p[this.g.a(n2 + 1, n3, n4)];
            boolean bl4 = !Block.p[this.g.a(n2, n3 - 1, n4)];
            boolean bl5 = !Block.p[this.g.a(n2, n3 + 1, n4)];
            boolean bl6 = !Block.p[this.g.a(n2, n3, n4 - 1)];
            boolean bl7 = !Block.p[this.g.a(n2, n3, n4 + 1)];
            int n5 = -1;
            double d8 = 9999.0;
            if (bl2 && d5 < d8) {
                d8 = d5;
                n5 = 0;
            }
            if (bl3 && 1.0 - d5 < d8) {
                d8 = 1.0 - d5;
                n5 = 1;
            }
            if (bl4 && d6 < d8) {
                d8 = d6;
                n5 = 2;
            }
            if (bl5 && 1.0 - d6 < d8) {
                d8 = 1.0 - d6;
                n5 = 3;
            }
            if (bl6 && d7 < d8) {
                d8 = d7;
                n5 = 4;
            }
            if (bl7 && 1.0 - d7 < d8) {
                d8 = 1.0 - d7;
                n5 = 5;
            }
            float f2 = this.Q.nextFloat() * 0.2f + 0.1f;
            if (n5 == 0) {
                this.n = - f2;
            }
            if (n5 == 1) {
                this.n = f2;
            }
            if (n5 == 2) {
                this.o = - f2;
            }
            if (n5 == 3) {
                this.o = f2;
            }
            if (n5 == 4) {
                this.p = - f2;
            }
            if (n5 == 5) {
                this.p = f2;
            }
        }
        return false;
    }

    protected void b(int n2) {
        this.a(null, n2);
    }

    public boolean a(Entity db2, int n2) {
        this.af -= n2;
        if (this.af <= 0) {
            this.i();
        }
        return false;
    }

    public void a(r r2) {
        r2.a("Health", (short)((byte)this.af));
        r2.a("Age", (short)this.b);
        r2.a("Item", this.a.a(new r()));
    }

    public void b(r r2) {
        this.af = r2.c("Health") & 255;
        this.b = r2.c("Age");
        r r3 = r2.j("Item");
        this.a = new gc(r3);
    }

    public void a(EntityPlayer eq2) {
        if (this.g.t) {
            return;
        }
        int n2 = this.a.a;
        if (this.ac == 0 && eq2.ai.a(this.a)) {
            this.g.a(this, "random.pop", 0.2f, ((this.Q.nextFloat() - this.Q.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            eq2.c(this, n2);
            this.i();
        }
    }
}

