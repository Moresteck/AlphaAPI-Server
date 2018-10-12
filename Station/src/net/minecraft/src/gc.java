/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
public final class gc {
    public int a = 0;
    public int b;
    public int c;
    public int d;

    public gc(Block et2) {
        this(et2, 1);
    }

    public gc(Block et2, int n2) {
        this(et2.ba, n2);
    }

    public gc(en en2) {
        this(en2, 1);
    }

    public gc(en en2, int n2) {
        this(en2.aQ, n2);
    }

    public gc(int n2) {
        this(n2, 1);
    }

    public gc(int n2, int n3) {
        this.c = n2;
        this.a = n3;
    }

    public gc(int n2, int n3, int n4) {
        this.c = n2;
        this.a = n3;
        this.d = n4;
    }

    public gc(r r2) {
        this.b(r2);
    }

    public en a() {
        return en.c[this.c];
    }

    public boolean a(EntityPlayer entityplayer2, World dp2, int n2, int n3, int n4, int n5) {
        return this.a().a(this, entityplayer2, dp2, n2, n3, n4, n5);
    }

    public float a(Block et2) {
        return this.a().a(this, et2);
    }

    public r a(r r2) {
        r2.a("id", (short)this.c);
        r2.a("Count", (byte)this.a);
        r2.a("Damage", (short)this.d);
        return r2;
    }

    public void b(r r2) {
        this.c = r2.c("id");
        this.a = r2.b("Count");
        this.d = r2.c("Damage");
    }

    public int b() {
        return this.a().a();
    }

    public int c() {
        return en.c[this.c].b();
    }

    public void a(int n2) {
        this.d += n2;
        if (this.d > this.c()) {
            --this.a;
            if (this.a < 0) {
                this.a = 0;
            }
            this.d = 0;
        }
    }

    public void a(int n2, int n3, int n4, int n5) {
        en.c[this.c].a(this, n2, n3, n4, n5);
    }

    public boolean b(Block et2) {
        return en.c[this.c].a(et2);
    }

    public void a(EntityPlayer entityplayer) {
    }
}

