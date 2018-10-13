package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class gm
extends Block {
    protected gm(int n2, int n3) {
        super(n2, n3, Material.s);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.a(true);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        return dp2.c(n2, n3 - 1, n4).c();
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        this.g(dp2, n2, n3, n4);
    }

    private boolean g(World dp2, int n2, int n3, int n4) {
        if (!this.a(dp2, n2, n3, n4)) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
            return false;
        }
        return true;
    }

    public int a(int n2, Random random) {
        return en.aB.aQ;
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (dp2.a(cr.b, n2, n3, n4) > 11) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        Material hz2 = hb2.c(n2, n3, n4);
        if (n5 == 1) {
            return true;
        }
        if (hz2 == this.bl) {
            return false;
        }
        return super.a(hb2, n2, n3, n4, n5);
    }
}

