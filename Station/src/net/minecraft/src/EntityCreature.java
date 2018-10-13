
package net.minecraft.src;
/*
=======
package net.minecraft.src;/*
>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/fu.java
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class EntityCreature
extends EntityLiving {
    private bx a;
    protected Entity af;
    protected boolean ag = false;

    public EntityCreature(World dp2) {
        super(dp2);
    }

    protected void d_() {
        int n2;
        int n3;
        this.ag = false;
        float f2 = 16.0f;
        if (this.af == null) {
            this.af = this.h();
            if (this.af != null) {
                this.a = this.g.a(this, this.af, f2);
            }
        } else if (!this.af.r()) {
            this.af = null;
        } else {
            float f3 = this.af.a(this);
            if (this.g(this.af)) {
                this.a(this.af, f3);
            }
        }
        if (!(this.ag || this.af == null || this.a != null && this.Q.nextInt(20) != 0)) {
            this.a = this.g.a(this, this.af, f2);
        } else if (this.a == null && this.Q.nextInt(80) == 0 || this.Q.nextInt(80) == 0) {
            boolean bl2 = false;
            n2 = -1;
            n3 = -1;
            int n4 = -1;
            float f4 = -99999.0f;
            for (int i2 = 0; i2 < 10; ++i2) {
                int n5;
                int n6;
                int n7 = MathHelper.b(this.k + (double)this.Q.nextInt(13) - 6.0);
                float f5 = this.a(n7, n6 = MathHelper.b(this.l + (double)this.Q.nextInt(7) - 3.0), n5 = MathHelper.b(this.m + (double)this.Q.nextInt(13) - 6.0));
                if (f5 <= f4) continue;
                f4 = f5;
                n2 = n7;
                n3 = n6;
                n4 = n5;
                bl2 = true;
            }
            if (bl2) {
                this.a = this.g.a((Entity)this, n2, n3, n4, 10.0f);
            }
        }
        int n8 = MathHelper.b(this.u.b);
        n2 = this.m() ? 1 : 0;
        n3 = this.o() ? 1 : 0;
        this.r = 0.0f;
        if (this.a == null || this.Q.nextInt(100) == 0) {
            super.d_();
            this.a = null;
            return;
        }
        Vec3D as2 = this.a.a(this);
        double d2 = this.C * 2.0f;
        while (as2 != null && as2.d(this.k, as2.b, this.m) < d2 * d2) {
            this.a.a();
            if (this.a.b()) {
                as2 = null;
                this.a = null;
                continue;
            }
            as2 = this.a.a(this);
        }
        this.bd = false;
        if (as2 != null) {
            float f6;
            double d3 = as2.a - this.k;
            double d4 = as2.c - this.m;
            double d5 = as2.b - (double)n8;
            float f7 = (float)(Math.atan2(d4, d3) * 180.0 / 3.1415927410125732) - 90.0f;
            this.bb = this.bf;
            for (f6 = f7 - this.q; f6 < -180.0f; f6 += 360.0f) {
            }
            while (f6 >= 180.0f) {
                f6 -= 360.0f;
            }
            if (f6 > 30.0f) {
                f6 = 30.0f;
            }
            if (f6 < -30.0f) {
                f6 = -30.0f;
            }
            this.q += f6;
            if (this.ag && this.af != null) {
                double d6 = this.af.k - this.k;
                double d7 = this.af.m - this.m;
                float f8 = this.q;
                this.q = (float)(Math.atan2(d7, d6) * 180.0 / 3.1415927410125732) - 90.0f;
                f6 = (f8 - this.q + 90.0f) * 3.1415927f / 180.0f;
                this.ba = (- MathHelper.a(f6)) * this.bb * 1.0f;
                this.bb = MathHelper.b(f6) * this.bb * 1.0f;
            }
            if (d5 > 0.0) {
                this.bd = true;
            }
        }
        if (this.af != null) {
            this.b(this.af, 30.0f);
        }
        if (this.w) {
            this.bd = true;
        }
        if (this.Q.nextFloat() < 0.8f && (n2 != 0 || n3 != 0)) {
            this.bd = true;
        }
    }

    protected void a(Entity db2, float f2) {
    }

    protected float a(int n2, int n3, int n4) {
        return 0.0f;
    }

    protected Entity h() {
        return null;
    }

    public boolean a() {
        int n2 = MathHelper.b(this.k);
        int n3 = MathHelper.b(this.u.b);
        int n4 = MathHelper.b(this.m);
        return super.a() && this.a(n2, n3, n4) >= 0.0f;
    }
}

