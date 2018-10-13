package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class p
extends EntityMonster {
    public p(World dp2) {
        super(dp2);
        this.aB = "/mob/zombie.png";
        this.bf = 0.5f;
        this.ae = 50;
        this.aK *= 10;
        this.B *= 6.0f;
        this.a(this.C * 6.0f, this.D * 6.0f);
    }

    protected float a(int n2, int n3, int n4) {
        return this.g.j(n2, n3, n4) - 0.5f;
    }
}

