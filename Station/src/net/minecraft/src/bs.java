package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class bs
extends Entity {
    public int a = 0;

    public bs(World dp2) {
        super(dp2);
        this.d = true;
        this.a(0.98f, 0.98f);
        this.B = this.D / 2.0f;
    }

    public bs(World dp2, float f2, float f3, float f4) {
        this(dp2);
        this.a((double)f2, (double)f3, (double)f4);
        float f5 = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.n = (- MathHelper.a(f5 * 3.1415927f / 180.0f)) * 0.02f;
        this.o = 0.20000000298023224;
        this.p = (- MathHelper.b(f5 * 3.1415927f / 180.0f)) * 0.02f;
        this.G = false;
        this.a = 80;
        this.h = f2;
        this.i = f3;
        this.j = f4;
    }

    public boolean c_() {
        return !this.A;
    }

    public void b_() {
        this.h = this.k;
        this.i = this.l;
        this.j = this.m;
        this.o -= 0.03999999910593033;
        this.c(this.n, this.o, this.p);
        this.n *= 0.9800000190734863;
        this.o *= 0.9800000190734863;
        this.p *= 0.9800000190734863;
        if (this.v) {
            this.n *= 0.699999988079071;
            this.p *= 0.699999988079071;
            this.o *= -0.5;
        }
        if (this.a-- <= 0) {
            this.i();
            this.b();
        } else {
            this.g.a("smoke", this.k, this.l + 0.5, this.m, 0.0, 0.0, 0.0);
        }
    }

    private void b() {
        float f2 = 4.0f;
        this.g.a(null, this.k, this.l, this.m, f2);
    }

    protected void a(r r2) {
        r2.a("Fuse", (byte)this.a);
    }

    protected void b(r r2) {
        this.a = r2.b("Fuse");
    }
}

