
package net.minecraft.src;
/*
=======
package net.minecraft.src;/*
>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/ei.java
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class EntityCreeper
extends EntityMonster {
    int a;
    int b;
    int ac = 30;
    int ad = -1;

    public EntityCreeper(World dp2) {
        super(dp2);
        this.aB = "/mob/creeper.png";
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    protected void d_() {
        this.b = this.a;
        if (this.a > 0 && this.ad < 0) {
            --this.a;
        }
        if (this.ad >= 0) {
            this.ad = 2;
        }
        super.d_();
        if (this.ad != 1) {
            this.ad = -1;
        }
    }

    protected String d() {
        return "mob.creeper";
    }

    protected String e() {
        return "mob.creeperdeath";
    }

    public void f(Entity db2) {
        super.f(db2);
        if (db2 instanceof EntitySkeleton) {
            this.a(en.aO.aQ + this.Q.nextInt(2), 1);
        }
    }

    protected void a(Entity db2, float f2) {
        if (this.ad <= 0 && f2 < 3.0f || this.ad > 0 && f2 < 7.0f) {
            if (this.a == 0) {
                this.g.a(this, "random.fuse", 1.0f, 0.5f);
            }
            this.ad = 1;
            ++this.a;
            if (this.a == this.ac) {
                this.g.a((Entity)this, this.k, this.l, this.m, 3.0f);
                this.i();
            }
            this.ag = true;
        }
    }

    protected int g() {
        return en.K.aQ;
    }
}

