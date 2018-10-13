package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class gg
extends ao {
    public boolean a = false;

    public gg(World dp2) {
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

