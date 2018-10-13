package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class gb
extends Block {
    protected gb(int n2, int n3) {
        super(n2, Material.i);
        this.aZ = n3;
        this.a(true);
        float f2 = 0.2f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 3.0f, 0.5f + f2);
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        return this.b(dp2.a(n2, n3 - 1, n4));
    }

    protected boolean b(int n2) {
        return n2 == Block.u.ba || n2 == Block.v.ba || n2 == Block.aA.ba;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        super.b(dp2, n2, n3, n4, n5);
        this.g(dp2, n2, n3, n4);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        this.g(dp2, n2, n3, n4);
    }

    protected final void g(World dp2, int n2, int n3, int n4) {
        if (!this.f(dp2, n2, n3, n4)) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
    }

    public boolean f(World dp2, int n2, int n3, int n4) {
        return (dp2.h(n2, n3, n4) >= 8 || dp2.g(n2, n3, n4)) && this.b(dp2.a(n2, n3 - 1, n4));
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 1;
    }
}

