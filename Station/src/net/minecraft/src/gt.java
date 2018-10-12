/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class gt
extends ao {
    public boolean a = false;
    public float b = 0.0f;
    public float ac = 0.0f;
    public float ad;
    public float ae;
    public float ah = 1.0f;
    public int ai;

    public gt(World dp2) {
        super(dp2);
        this.aB = "/mob/chicken.png";
        this.a(0.3f, 0.4f);
        this.aK = 4;
        this.ai = this.Q.nextInt(6000) + 6000;
    }

    public void x() {
        super.x();
        this.ae = this.b;
        this.ad = this.ac;
        this.ac = (float)((double)this.ac + (double)(this.v ? -1 : 4) * 0.3);
        if (this.ac < 0.0f) {
            this.ac = 0.0f;
        }
        if (this.ac > 1.0f) {
            this.ac = 1.0f;
        }
        if (!this.v && this.ah < 1.0f) {
            this.ah = 1.0f;
        }
        this.ah = (float)((double)this.ah * 0.9);
        if (!this.v && this.o < 0.0) {
            this.o *= 0.6;
        }
        this.b += this.ah * 2.0f;
        if (--this.ai <= 0) {
            this.a(en.aN.aQ, 1);
            this.ai = this.Q.nextInt(6000) + 6000;
        }
    }

    public void a(r r2) {
        super.a(r2);
    }

    public void b(r r2) {
        super.b(r2);
    }

    protected String c() {
        return "mob.chicken";
    }

    protected String d() {
        return "mob.chickenhurt";
    }

    protected String e() {
        return "mob.chickenhurt";
    }

    protected int g() {
        return en.J.aQ;
    }
}

