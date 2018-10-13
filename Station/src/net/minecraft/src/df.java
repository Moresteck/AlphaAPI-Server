package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.Random;

public class df
extends Block {
    private Block a;

    protected df(int n2, Block et2) {
        super(n2, et2.aZ, et2.bl);
        this.a = et2;
        this.c(et2.bb);
        this.b(et2.bc / 3.0f);
        this.a(et2.bj);
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 10;
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        return super.a(hb2, n2, n3, n4, n5);
    }

    public void a(World dp2, int n2, int n3, int n4, AxisAlignedBB cy2, ArrayList arrayList) {
        int n5 = dp2.b(n2, n3, n4);
        if (n5 == 0) {
            this.a(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
            this.a(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
        } else if (n5 == 1) {
            this.a(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
            this.a(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
        } else if (n5 == 2) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
            this.a(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
        } else if (n5 == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
            this.a(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
            super.a(dp2, n2, n3, n4, cy2, arrayList);
        }
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (dp2.c(n2, n3 + 1, n4).a()) {
            dp2.d(n2, n3, n4, this.a.ba);
        } else {
            this.g(dp2, n2, n3, n4);
            this.g(dp2, n2 + 1, n3 - 1, n4);
            this.g(dp2, n2 - 1, n3 - 1, n4);
            this.g(dp2, n2, n3 - 1, n4 - 1);
            this.g(dp2, n2, n3 - 1, n4 + 1);
            this.g(dp2, n2 + 1, n3 + 1, n4);
            this.g(dp2, n2 - 1, n3 + 1, n4);
            this.g(dp2, n2, n3 + 1, n4 - 1);
            this.g(dp2, n2, n3 + 1, n4 + 1);
        }
        this.a.b(dp2, n2, n3, n4, n5);
    }

    private void g(World dp2, int n2, int n3, int n4) {
        if (!this.i(dp2, n2, n3, n4)) {
            return;
        }
        int n5 = -1;
        if (this.i(dp2, n2 + 1, n3 + 1, n4)) {
            n5 = 0;
        }
        if (this.i(dp2, n2 - 1, n3 + 1, n4)) {
            n5 = 1;
        }
        if (this.i(dp2, n2, n3 + 1, n4 + 1)) {
            n5 = 2;
        }
        if (this.i(dp2, n2, n3 + 1, n4 - 1)) {
            n5 = 3;
        }
        if (n5 < 0) {
            if (this.h(dp2, n2 + 1, n3, n4) && !this.h(dp2, n2 - 1, n3, n4)) {
                n5 = 0;
            }
            if (this.h(dp2, n2 - 1, n3, n4) && !this.h(dp2, n2 + 1, n3, n4)) {
                n5 = 1;
            }
            if (this.h(dp2, n2, n3, n4 + 1) && !this.h(dp2, n2, n3, n4 - 1)) {
                n5 = 2;
            }
            if (this.h(dp2, n2, n3, n4 - 1) && !this.h(dp2, n2, n3, n4 + 1)) {
                n5 = 3;
            }
        }
        if (n5 < 0) {
            if (this.i(dp2, n2 - 1, n3 - 1, n4)) {
                n5 = 0;
            }
            if (this.i(dp2, n2 + 1, n3 - 1, n4)) {
                n5 = 1;
            }
            if (this.i(dp2, n2, n3 - 1, n4 - 1)) {
                n5 = 2;
            }
            if (this.i(dp2, n2, n3 - 1, n4 + 1)) {
                n5 = 3;
            }
        }
        if (n5 >= 0) {
            dp2.b(n2, n3, n4, n5);
        }
    }

    private boolean h(World dp2, int n2, int n3, int n4) {
        return dp2.c(n2, n3, n4).a();
    }

    private boolean i(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.a(n2, n3, n4);
        if (n5 == 0) {
            return false;
        }
        return Block.n[n5].a() == 10;
    }

    public void b(World dp2, int n2, int n3, int n4, eq eq2) {
        this.a.b(dp2, n2, n3, n4, eq2);
    }

    public void a(World dp2, int n2, int n3, int n4, int n5) {
        this.a.a(dp2, n2, n3, n4, n5);
    }

    public float a(Entity db2) {
        return this.a.a(db2);
    }

    public int a(int n2, Random random) {
        return this.a.a(n2, random);
    }

    public int a(Random random) {
        return this.a.a(random);
    }

    public int a(int n2) {
        return this.a.a(n2);
    }

    public int c() {
        return this.a.c();
    }

    public void a(World dp2, int n2, int n3, int n4, Entity db2, Vec3D as2) {
        this.a.a(dp2, n2, n3, n4, db2, as2);
    }

    public boolean e() {
        return this.a.e();
    }

    public boolean a(int n2, boolean bl2) {
        return this.a.a(n2, bl2);
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        return this.a.a(dp2, n2, n3, n4);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        this.b(dp2, n2, n3, n4, 0);
        this.a.e(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4) {
        this.a.b(dp2, n2, n3, n4);
    }

    public void a(World dp2, int n2, int n3, int n4, int n5, float f2) {
        this.a.a(dp2, n2, n3, n4, n5, f2);
    }

    public void a_(World dp2, int n2, int n3, int n4, int n5) {
        this.a.a_(dp2, n2, n3, n4, n5);
    }

    public void b(World dp2, int n2, int n3, int n4, Entity db2) {
        this.a.b(dp2, n2, n3, n4, db2);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        this.a.a(dp2, n2, n3, n4, random);
    }

    public boolean a(World dp2, int n2, int n3, int n4, eq eq2) {
        return this.a.a(dp2, n2, n3, n4, eq2);
    }

    public void c(World dp2, int n2, int n3, int n4) {
        this.a.c(dp2, n2, n3, n4);
    }
}

