package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class EntitySheep
extends EntityAnimal {
    public boolean a = false;

    public EntitySheep(World dp2) {
        super(dp2);
        this.aB = "/mob/sheep.png";
        this.a(0.9f, 1.3f);
    }

    public boolean a(Entity db2, int n2) {
        if (!this.a && db2 instanceof EntityLiving) {
            this.a = true;
            int n3 = 1 + this.Q.nextInt(3);
            for (int i2 = 0; i2 < n3; ++i2) {
                fa fa2 = this.a(Block.ab.ba, 1, 1.0f);
                fa2.o += (double)(this.Q.nextFloat() * 0.05f);
                fa2.n += (double)((this.Q.nextFloat() - this.Q.nextFloat()) * 0.1f);
                fa2.p += (double)((this.Q.nextFloat() - this.Q.nextFloat()) * 0.1f);
            }
        }
        return super.a(db2, n2);
    }

    public void a(r r2) {
        super.a(r2);
        r2.a("Sheared", this.a);
    }

    public void b(r r2) {
        super.b(r2);
        this.a = r2.l("Sheared");
    }

    protected String c() {
        return "mob.sheep";
    }

    protected String d() {
        return "mob.sheep";
    }

    protected String e() {
        return "mob.sheep";
    }
}

