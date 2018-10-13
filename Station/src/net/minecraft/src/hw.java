package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class hw {
    private World b;
    public EntityPlayer a;
    private float c;
    private float d = 0.0f;
    private int e = 0;
    private float f = 0.0f;
    private int g;
    private int h;
    private int i;

    public hw(World dp2) {
        this.b = dp2;
    }

    public void a(int n2, int n3, int n4) {
        int n5 = this.b.a(n2, n3, n4);
        if (n5 > 0 && this.d == 0.0f) {
            Block.n[n5].b(this.b, n2, n3, n4, this.a);
        }
        if (n5 > 0 && Block.n[n5].a(this.a) >= 1.0f) {
            this.c(n2, n3, n4);
        }
    }

    public void a() {
        this.d = 0.0f;
        this.e = 0;
    }

    public void a(int n2, int n3, int n4, int n5) {
        if (this.e > 0) {
            --this.e;
            return;
        }
        if (n2 == this.g && n3 == this.h && n4 == this.i) {
            int n6 = this.b.a(n2, n3, n4);
            if (n6 == 0) {
                return;
            }
            Block et2 = Block.n[n6];
            this.d += et2.a(this.a);
            this.f += 1.0f;
            if (this.d >= 1.0f) {
                this.c(n2, n3, n4);
                this.d = 0.0f;
                this.c = 0.0f;
                this.f = 0.0f;
                this.e = 5;
            }
        } else {
            this.d = 0.0f;
            this.c = 0.0f;
            this.f = 0.0f;
            this.g = n2;
            this.h = n3;
            this.i = n4;
        }
    }

    public boolean b(int n2, int n3, int n4) {
        Block et2 = Block.n[this.b.a(n2, n3, n4)];
        int n5 = this.b.b(n2, n3, n4);
        boolean bl2 = this.b.d(n2, n3, n4, 0);
        if (et2 != null && bl2) {
            et2.a(this.b, n2, n3, n4, n5);
        }
        return bl2;
    }

    public boolean c(int n2, int n3, int n4) {
        int n5 = this.b.a(n2, n3, n4);
        int n6 = this.b.b(n2, n3, n4);
        boolean bl2 = this.b(n2, n3, n4);
        gc gc2 = this.a.A();
        if (gc2 != null) {
            gc2.a(n5, n2, n3, n4);
            if (gc2.a == 0) {
                gc2.a(this.a);
                this.a.B();
            }
        }
        if (bl2 && this.a.b(Block.n[n5])) {
            Block.n[n5].a_(this.b, n2, n3, n4, n6);
        }
        return bl2;
    }

    public boolean a(EntityPlayer entityplayer2, World dp2, gc gc2, int n2, int n3, int n4, int n5) {
        return gc2.a(entityplayer2, dp2, n2, n3, n4, n5);
    }
}

