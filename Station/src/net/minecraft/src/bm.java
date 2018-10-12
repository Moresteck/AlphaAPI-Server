/*
 * Decompiled with CFR 0_132.
 */
import java.util.List;
import java.util.Random;

public class bm
extends TileEntity {
    public int e = 20;
    public String f = "Pig";
    public double g;
    public double h = 0.0;

    public boolean a() {
        return this.a.a((double)this.b + 0.5, (double)this.c + 0.5, (double)this.d + 0.5, 16.0) != null;
    }

    public void b() {
        this.h = this.g;
        if (!this.a()) {
            return;
        }
        double d2 = (float)this.b + this.a.k.nextFloat();
        double d3 = (float)this.c + this.a.k.nextFloat();
        double d4 = (float)this.d + this.a.k.nextFloat();
        this.a.a("smoke", d2, d3, d4, 0.0, 0.0, 0.0);
        this.a.a("flame", d2, d3, d4, 0.0, 0.0, 0.0);
        this.g += (double)(1000.0f / ((float)this.e + 200.0f));
        while (this.g > 360.0) {
            this.g -= 360.0;
            this.h -= 360.0;
        }
        if (this.e == -1) {
            this.c();
        }
        if (this.e > 0) {
            --this.e;
            return;
        }
        int n2 = 4;
        for (int i2 = 0; i2 < n2; ++i2) {
            EntityLiving ic2 = (EntityLiving)ge.a(this.f, this.a);
            if (ic2 == null) {
                return;
            }
            int n3 = this.a.a(ic2.getClass(), AxisAlignedBB.b(this.b, this.c, this.d, this.b + 1, this.c + 1, this.d + 1).b(8.0, 4.0, 8.0)).size();
            if (n3 >= 6) {
                this.c();
                return;
            }
            if (ic2 == null) continue;
            double d5 = (double)this.b + (this.a.k.nextDouble() - this.a.k.nextDouble()) * 4.0;
            double d6 = this.c + this.a.k.nextInt(3) - 1;
            double d7 = (double)this.d + (this.a.k.nextDouble() - this.a.k.nextDouble()) * 4.0;
            ic2.c(d5, d6, d7, this.a.k.nextFloat() * 360.0f, 0.0f);
            if (!ic2.a()) continue;
            this.a.a(ic2);
            for (int i3 = 0; i3 < 20; ++i3) {
                d2 = (double)this.b + 0.5 + ((double)this.a.k.nextFloat() - 0.5) * 2.0;
                d3 = (double)this.c + 0.5 + ((double)this.a.k.nextFloat() - 0.5) * 2.0;
                d4 = (double)this.d + 0.5 + ((double)this.a.k.nextFloat() - 0.5) * 2.0;
                this.a.a("smoke", d2, d3, d4, 0.0, 0.0, 0.0);
                this.a.a("flame", d2, d3, d4, 0.0, 0.0, 0.0);
            }
            ic2.C();
            this.c();
        }
        super.b();
    }

    private void c() {
        this.e = 200 + this.a.k.nextInt(600);
    }

    public void a(r r2) {
        super.a(r2);
        this.f = r2.h("EntityId");
        this.e = r2.c("Delay");
    }

    public void b(r r2) {
        super.b(r2);
        r2.a("EntityId", this.f);
        r2.a("Delay", (short)this.e);
    }
}

