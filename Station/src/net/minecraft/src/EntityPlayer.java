package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.util.List;
import java.util.Random;

public class EntityPlayer
extends EntityLiving {
    public InventoryPlayer ai = new InventoryPlayer(this);
    public byte aj = 0;
    public int ak = 0;
    public float al;
    public float am;
    public boolean an = false;
    public int ao = 0;
    public String ap;
    private int a = 0;

    public EntityPlayer(World world) {
        super(world);
        this.B = 1.62f;
        this.c((double)world.l + 0.5, world.m + 1, (double)world.n + 0.5, 0.0f, 0.0f);
        this.aK = 20;
        this.aE = "humanoid";
        this.aD = 180.0f;
        this.S = 20;
        this.aB = "/char.png";
    }

    public void t() {
        super.t();
        this.al = this.am;
        this.am = 0.0f;
    }

    protected void d_() {
        if (this.an) {
            ++this.ao;
            if (this.ao == 8) {
                this.ao = 0;
                this.an = false;
            }
        } else {
            this.ao = 0;
        }
        this.aJ = (float)this.ao / 8.0f;
    }

    public void x() {
        List list;
        if (this.g.j == 0 && this.aK < 20 && this.R % 20 * 4 == 0) {
            this.a(1);
        }
        this.ai.c();
        this.al = this.am;
        super.x();
        float f2 = MathHelper.a(this.n * this.n + this.p * this.p);
        float f3 = (float)Math.atan((- this.o) * 0.20000000298023224) * 15.0f;
        if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        if (!this.v || this.aK <= 0) {
            f2 = 0.0f;
        }
        if (this.v || this.aK <= 0) {
            f3 = 0.0f;
        }
        this.am += (f2 - this.am) * 0.4f;
        this.aS += (f3 - this.aS) * 0.8f;
        if (this.aK > 0 && (list = this.g.b(this, this.u.b(1.0, 0.0, 1.0))) != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                this.h((Entity)list.get(i2));
            }
        }
    }

    private void h(Entity db2) {
        db2.a(this);
    }

    public void f(Entity db2) {
        this.a(0.2f, 0.2f);
        this.a(this.k, this.l, this.m);
        this.o = 0.10000000149011612;
        if (this.ap.equals("Notch")) {
            this.a(new gc(en.h, 1), true);
        }
        this.ai.f();
        if (db2 != null) {
            this.n = (- MathHelper.b((this.aO + this.q) * 3.1415927f / 180.0f)) * 0.1f;
            this.p = (- MathHelper.a((this.aO + this.q) * 3.1415927f / 180.0f)) * 0.1f;
        } else {
            this.p = 0.0;
            this.n = 0.0;
        }
        this.B = 0.1f;
    }

    public void b(Entity db2, int n2) {
        this.ak += n2;
    }

    public void a(gc gc2) {
        this.a(gc2, false);
    }

    public void a(gc gc2, boolean bl2) {
        if (gc2 == null) {
            return;
        }
        fa fa2 = new fa(this.g, this.k, this.l - 0.30000001192092896 + (double)this.n(), this.m, gc2);
        fa2.ac = 40;
        float f2 = 0.1f;
        if (bl2) {
            float f3 = this.Q.nextFloat() * 0.5f;
            float f4 = this.Q.nextFloat() * 3.1415927f * 2.0f;
            fa2.n = (- MathHelper.a(f4)) * f3;
            fa2.p = MathHelper.b(f4) * f3;
            fa2.o = 0.20000000298023224;
        } else {
            f2 = 0.3f;
            fa2.n = (- MathHelper.a(this.q / 180.0f * 3.1415927f)) * MathHelper.b(this.r / 180.0f * 3.1415927f) * f2;
            fa2.p = MathHelper.b(this.q / 180.0f * 3.1415927f) * MathHelper.b(this.r / 180.0f * 3.1415927f) * f2;
            fa2.o = (- MathHelper.a(this.r / 180.0f * 3.1415927f)) * f2 + 0.1f;
            f2 = 0.02f;
            float f5 = this.Q.nextFloat() * 3.1415927f * 2.0f;
            fa2.n += Math.cos(f5) * (double)(f2 *= this.Q.nextFloat());
            fa2.o += (double)((this.Q.nextFloat() - this.Q.nextFloat()) * 0.1f);
            fa2.p += Math.sin(f5) * (double)f2;
        }
        this.a(fa2);
    }

    protected void a(fa fa2) {
        this.g.a(fa2);
    }

    public float a(Block et2) {
        float f2 = this.ai.a(et2);
        if (this.a(Material.f)) {
            f2 /= 5.0f;
        }
        if (!this.v) {
            f2 /= 5.0f;
        }
        return f2;
    }

    public boolean b(Block et2) {
        return this.ai.b(et2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void a(IInventory iinventory) {
    }

    public void z() {
    }

    public void c(Entity db2, int n2) {
    }

    protected float n() {
        return 0.12f;
    }

    public boolean a(Entity db2, int n2) {
        this.aZ = 0;
        if (this.aK <= 0) {
            return false;
        }
        if ((float)this.W > (float)this.aq / 2.0f) {
            return false;
        }
        if (db2 instanceof EntityMonster || db2 instanceof da) {
            if (this.g.j == 0) {
                n2 = 0;
            }
            if (this.g.j == 1) {
                n2 = n2 / 3 + 1;
            }
            if (this.g.j == 3) {
                n2 = n2 * 3 / 2;
            }
        }
        int n3 = 25 - this.ai.e();
        int n4 = n2 * n3 + this.a;
        this.ai.b(n2);
        n2 = n4 / 25;
        this.a = n4 % 25;
        if (n2 == 0) {
            return false;
        }
        return super.a(db2, n2);
    }

    public void a(BlockFurnace cx2) {
    }

    public void a(hp hp2) {
    }

    public gc A() {
        return this.ai.b();
    }

    public void B() {
        this.ai.a(this.ai.d, null);
    }

    public double v() {
        return this.B - 0.5f;
    }

    public void y() {
        this.ao = -1;
        this.an = true;
    }
}

