
package net.minecraft.src;
/*
=======
package net.minecraft.src;/*
>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/eu.java
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class EntityMonster
extends EntityCreature {
    protected int ae = 2;

    public EntityMonster(World dp2) {
        super(dp2);
        this.aK = 20;
    }

    public void x() {
        float f2 = this.b(1.0f);
        if (f2 > 0.5f) {
            this.aZ += 2;
        }
        super.x();
    }

    public void b_() {
        super.b_();
        if (this.g.j == 0) {
            this.i();
        }
    }

    protected Entity h() {
        EntityPlayer eq2 = this.g.a((Entity)this, 16.0);
        if (eq2 != null && this.g(eq2)) {
            return eq2;
        }
        return null;
    }

    public boolean a(Entity db2, int n2) {
        if (super.a(db2, n2)) {
            if (db2 != this) {
                this.af = db2;
            }
            return true;
        }
        return false;
    }

    protected void a(Entity db2, float f2) {
        if ((double)f2 < 2.5 && db2.u.e > this.u.b && db2.u.b < this.u.e) {
            this.aQ = 20;
            db2.a(this, this.ae);
        }
    }

    protected float a(int n2, int n3, int n4) {
        return 0.5f - this.g.j(n2, n3, n4);
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    public boolean a() {
        int n2;
        int n3;
        int n4 = MathHelper.b(this.k);
        if (this.g.a(cr.a, n4, n2 = MathHelper.b(this.u.b), n3 = MathHelper.b(this.m)) > this.Q.nextInt(32)) {
            return false;
        }
        int n5 = this.g.h(n4, n2, n3);
        return n5 <= this.Q.nextInt(8) && super.a();
    }
}

