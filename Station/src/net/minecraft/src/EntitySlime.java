
package net.minecraft.src;
/*
=======
package net.minecraft.src;/*
>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/ev.java
 * Decompiled with CFR 0_132.
 */

public class EntitySlime
extends EntityLiving {
    public float a;
    public float b;
    private int ad = 0;
    public int ac = 1;

    public EntitySlime(World dp2) {
        super(dp2);
        this.aB = "/mob/slime.png";
        this.ac = 1 << this.Q.nextInt(3);
        this.B = 0.0f;
        this.ad = this.Q.nextInt(20) + 10;
        this.c(this.ac);
    }

    public void c(int n2) {
        this.ac = n2;
        this.a(0.6f * (float)n2, 0.6f * (float)n2);
        this.aK = n2 * n2;
        this.a(this.k, this.l, this.m);
    }

    public void a(r r2) {
        super.a(r2);
        r2.a("Size", this.ac - 1);
    }

    public void b(r r2) {
        super.b(r2);
        this.ac = r2.d("Size") + 1;
    }

    public void b_() {
        this.b = this.a;
        boolean bl2 = this.v;
        super.b_();
        if (this.v && !bl2) {
            for (int i2 = 0; i2 < this.ac * 8; ++i2) {
                float f2 = this.Q.nextFloat() * 3.1415927f * 2.0f;
                float f3 = this.Q.nextFloat() * 0.5f + 0.5f;
                float f4 = MathHelper.a(f2) * (float)this.ac * 0.5f * f3;
                float f5 = MathHelper.b(f2) * (float)this.ac * 0.5f * f3;
                this.g.a("slime", this.k + (double)f4, this.u.b, this.m + (double)f5, 0.0, 0.0, 0.0);
            }
            if (this.ac > 2) {
                this.g.a(this, "mob.slime", this.f(), ((this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.a = -0.5f;
        }
        this.a *= 0.6f;
    }

    protected void d_() {
        EntityPlayer eq2 = this.g.a((Entity)this, 16.0);
        if (eq2 != null) {
            this.b(eq2, 10.0f);
        }
        if (this.v && this.ad-- <= 0) {
            this.ad = this.Q.nextInt(20) + 10;
            if (eq2 != null) {
                this.ad /= 3;
            }
            this.bd = true;
            if (this.ac > 1) {
                this.g.a(this, "mob.slime", this.f(), ((this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.a = 1.0f;
            this.ba = 1.0f - this.Q.nextFloat() * 2.0f;
            this.bb = 1 * this.ac;
        } else {
            this.bd = false;
            if (this.v) {
                this.bb = 0.0f;
                this.ba = 0.0f;
            }
        }
    }

    public void i() {
        if (this.ac > 1 && this.aK == 0) {
            for (int i2 = 0; i2 < 4; ++i2) {
                float f2 = ((float)(i2 % 2) - 0.5f) * (float)this.ac / 4.0f;
                float f3 = ((float)(i2 / 2) - 0.5f) * (float)this.ac / 4.0f;
                EntitySlime ev2 = new EntitySlime(this.g);
                ev2.c(this.ac / 2);
                ev2.c(this.k + (double)f2, this.l + 0.5, this.m + (double)f3, this.Q.nextFloat() * 360.0f, 0.0f);
                this.g.a(ev2);
            }
        }
        super.i();
    }

    public void a(EntityPlayer eq2) {
        if (this.ac > 1 && this.g(eq2) && (double)this.a((Entity)eq2) < 0.6 * (double)this.ac && eq2.a(this, this.ac)) {
            this.g.a(this, "mob.slimeattack", 1.0f, (this.Q.nextFloat() - this.Q.nextFloat()) * 0.2f + 1.0f);
        }
    }

    protected String d() {
        return "mob.slime";
    }

    protected String e() {
        return "mob.slime";
    }

    protected int g() {
        if (this.ac == 1) {
            return en.aK.aQ;
        }
        return 0;
    }

    public boolean a() {
        Chunk chunk2 = this.g.a(MathHelper.b(this.k), MathHelper.b(this.l));
        return (this.ac == 1 || this.g.j > 0) && this.Q.nextInt(10) == 0 && chunk2.a(987234911L).nextInt(100) == 0 && this.l < 16.0;
    }

    protected float f() {
        return 0.6f;
    }
}

