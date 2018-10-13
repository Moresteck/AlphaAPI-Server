package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class bg
extends eu {
    public bg(World dp2) {
        super(dp2);
        this.aB = "/mob/spider.png";
        this.a(1.4f, 0.9f);
        this.bf = 0.8f;
    }

    protected Entity h() {
        float f2 = this.b(1.0f);
        if (f2 < 0.5f) {
            double d2 = 16.0;
            return this.g.a((Entity)this, d2);
        }
        return null;
    }

    protected String c() {
        return "mob.spider";
    }

    protected String d() {
        return "mob.spider";
    }

    protected String e() {
        return "mob.spiderdeath";
    }

    protected void a(Entity db2, float f2) {
        float f3 = this.b(1.0f);
        if (f3 > 0.5f && this.Q.nextInt(100) == 0) {
            this.af = null;
            return;
        }
        if (f2 > 2.0f && f2 < 6.0f && this.Q.nextInt(10) == 0) {
            if (this.v) {
                double d2 = db2.k - this.k;
                double d3 = db2.m - this.m;
                float f4 = fw.a(d2 * d2 + d3 * d3);
                this.n = d2 / (double)f4 * 0.5 * 0.800000011920929 + this.n * 0.20000000298023224;
                this.p = d3 / (double)f4 * 0.5 * 0.800000011920929 + this.p * 0.20000000298023224;
                this.o = 0.4000000059604645;
            }
        } else {
            super.a(db2, f2);
        }
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    protected int g() {
        return en.I.aQ;
    }
}

