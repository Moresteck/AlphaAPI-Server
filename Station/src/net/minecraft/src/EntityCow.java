package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class EntityCow
extends EntityAnimal {
    public boolean a = false;

    public EntityCow(World dp2) {
        super(dp2);
        this.aB = "/mob/cow.png";
        this.a(0.9f, 1.3f);
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    protected String c() {
        return "mob.cow";
    }

    protected String d() {
        return "mob.cowhurt";
    }

    protected String e() {
        return "mob.cowhurt";
    }

    protected float f() {
        return 0.4f;
    }

    protected int g() {
        return en.aD.aQ;
    }
}

