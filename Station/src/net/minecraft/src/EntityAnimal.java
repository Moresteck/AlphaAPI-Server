package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
public abstract class EntityAnimal
extends EntityCreature {
    public EntityAnimal(World dp2) {
        super(dp2);
    }

    protected float a(int n2, int n3, int n4) {
        if (this.g.a(n2, n3 - 1, n4) == Block.u.ba) {
            return 10.0f;
        }
        return this.g.j(n2, n3, n4) - 0.5f;
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
        return this.g.a(n4, (n2 = MathHelper.b(this.u.b)) - 1, n3 = MathHelper.b(this.m)) == Block.u.ba && this.g.h(n4, n2, n3) > 8 && super.a();
    }

    public int b() {
        return 120;
    }
}

