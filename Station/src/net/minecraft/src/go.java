package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class go
extends Entity {
    public int a;
    public int b = 0;

    public go(World dp2) {
        super(dp2);
    }

    public go(World dp2, float f2, float f3, float f4, int n2) {
        super(dp2);
        this.a = n2;
        this.d = true;
        this.a(0.98f, 0.98f);
        this.B = this.D / 2.0f;
        this.a((double)f2, (double)f3, (double)f4);
        this.n = 0.0;
        this.o = 0.0;
        this.p = 0.0;
        this.G = false;
        this.h = f2;
        this.i = f3;
        this.j = f4;
    }

    public boolean c_() {
        return !this.A;
    }

    public void b_() {
        if (this.a == 0) {
            this.i();
            return;
        }
        this.h = this.k;
        this.i = this.l;
        this.j = this.m;
        ++this.b;
        this.o -= 0.03999999910593033;
        this.c(this.n, this.o, this.p);
        this.n *= 0.9800000190734863;
        this.o *= 0.9800000190734863;
        this.p *= 0.9800000190734863;
        int n2 = MathHelper.b(this.k);
        int n3 = MathHelper.b(this.l);
        int n4 = MathHelper.b(this.m);
        if (this.g.a(n2, n3, n4) == this.a) {
            this.g.d(n2, n3, n4, 0);
        }
        if (this.v) {
            this.n *= 0.699999988079071;
            this.p *= 0.699999988079071;
            this.o *= -0.5;
            this.i();
            if (!this.g.a(this.a, n2, n3, n4, true) || !this.g.d(n2, n3, n4, this.a)) {
                this.a(this.a, 1);
            }
        } else if (this.b > 100) {
            this.a(this.a, 1);
            this.i();
        }
    }

    protected void a(r r2) {
        r2.a("Tile", (byte)this.a);
    }

    protected void b(r r2) {
        this.a = r2.b("Tile") & 255;
    }
}

