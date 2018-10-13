package net.minecraft.src;
<<<<<<< HEAD:Station/src/net/minecraft/src/EntityPig.java
=======

>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/gg.java
/*
 * Decompiled with CFR 0_132.
 */
public class EntityPig
extends EntityAnimal {
    public boolean a = false;

    public EntityPig(World dp2) {
        super(dp2);
        this.aB = "/mob/pig.png";
        this.a(0.9f, 0.9f);
        this.a = false;
    }

    public void a(r r2) {
        super.a(r2);
        r2.a("Saddle", this.a);
    }

    public void b(r r2) {
        super.b(r2);
        this.a = r2.l("Saddle");
    }

    protected String c() {
        return "mob.pig";
    }

    protected String d() {
        return "mob.pig";
    }

    protected String e() {
        return "mob.pigdeath";
    }

    protected int g() {
        return en.ao.aQ;
    }
}

