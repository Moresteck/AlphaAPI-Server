package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class bx {
    private final a[] b;
    public final int a;
    private int c;

    public bx(a[] arra) {
        this.b = arra;
        this.a = arra.length;
    }

    public void a() {
        ++this.c;
    }

    public boolean b() {
        return this.c >= this.b.length;
    }

    public Vec3D a(Entity db2) {
        double d2 = (double)this.b[this.c].a + (double)((int)(db2.C + 1.0f)) * 0.5;
        double d3 = this.b[this.c].b;
        double d4 = (double)this.b[this.c].c + (double)((int)(db2.C + 1.0f)) * 0.5;
        return Vec3D.b(d2, d3, d4);
    }
}

