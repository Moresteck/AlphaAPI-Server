package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class fe {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Vec3D f;
    public Entity g;

    public fe(int n2, int n3, int n4, int n5, Vec3D as2) {
        this.a = 0;
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
        this.f = Vec3D.b(as2.a, as2.b, as2.c);
    }

    public fe(Entity db2) {
        this.a = 1;
        this.g = db2;
        this.f = Vec3D.b(db2.k, db2.l, db2.m);
    }
}

