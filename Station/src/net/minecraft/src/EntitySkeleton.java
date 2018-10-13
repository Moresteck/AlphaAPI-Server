<<<<<<< HEAD:Station/src/net/minecraft/src/EntitySkeleton.java
package net.minecraft.src;
/*
=======
package net.minecraft.src;/*
>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/dz.java
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class EntitySkeleton
extends EntityMonster {
    public EntitySkeleton(World dp2) {
        super(dp2);
        this.aB = "/mob/skeleton.png";
    }

    protected String c() {
        return "mob.skeleton";
    }

    protected String d() {
        return "mob.skeletonhurt";
    }

    protected String e() {
        return "mob.skeletonhurt";
    }

    public void x() {
        float f2;
        if (this.g.a() && (f2 = this.b(1.0f)) > 0.5f && this.g.g(MathHelper.b(this.k), MathHelper.b(this.l), MathHelper.b(this.m)) && this.Q.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
            this.T = 300;
        }
        super.x();
    }

    protected void a(Entity db2, float f2) {
        if (f2 < 10.0f) {
            double d2 = db2.k - this.k;
            double d3 = db2.m - this.m;
            if (this.aQ == 0) {
                da da2 = new da(this.g, this);
                da2.l += 1.399999976158142;
                double d4 = db2.l - 0.20000000298023224 - da2.l;
                float f3 = MathHelper.a(d2 * d2 + d3 * d3) * 0.2f;
                this.g.a(this, "random.bow", 1.0f, 1.0f / (this.Q.nextFloat() * 0.4f + 0.8f));
                this.g.a(da2);
                da2.a(d2, d4 + (double)f3, d3, 0.6f, 12.0f);
                this.aQ = 30;
            }
            this.q = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            this.ag = true;
        }
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    protected int g() {
        return en.j.aQ;
    }
}

