package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class EntityZombie
extends EntityMonster {
    public EntityZombie(World dp2) {
        super(dp2);
        this.aB = "/mob/zombie.png";
        this.bf = 0.5f;
        this.ae = 5;
    }

    public void x() {
        float f2;
        if (this.g.a() && (f2 = this.b(1.0f)) > 0.5f && this.g.g(MathHelper.b(this.k), MathHelper.b(this.l), MathHelper.b(this.m)) && this.Q.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
            this.T = 300;
        }
        super.x();
    }

    protected String c() {
        return "mob.zombie";
    }

    protected String d() {
        return "mob.zombiehurt";
    }

    protected String e() {
        return "mob.zombiedeath";
    }

    protected int g() {
        return en.J.aQ;
    }
}

