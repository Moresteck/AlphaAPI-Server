package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class m
extends gk {
    public m(int n2, int n3) {
        super(n2, n3, hz.r, false);
        this.bm = 0.98f;
        this.a(true);
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        return super.a(hb2, n2, n3, n4, 1 - n5);
    }

    public void b(World dp2, int n2, int n3, int n4) {
        hz hz2 = dp2.c(n2, n3 - 1, n4);
        if (hz2.c() || hz2.d()) {
            dp2.d(n2, n3, n4, Block.A.ba);
        }
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (dp2.a(cr.b, n2, n3, n4) > 11 - Block.q[this.ba]) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, Block.B.ba);
        }
    }
}

