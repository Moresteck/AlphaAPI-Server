package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hy
extends Block {
    private boolean a;

    public hy(int n2, boolean bl2) {
        super(n2, 6, hz.d);
        this.a = bl2;
        if (!bl2) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        this.c(255);
    }

    public int a(int n2) {
        if (n2 <= 1) {
            return 6;
        }
        return 5;
    }

    public boolean b() {
        return this.a;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (this != Block.ak) {
            return;
        }
    }

    public void e(World dp2, int n2, int n3, int n4) {
        int n5;
        if (this != Block.ak) {
            super.e(dp2, n2, n3, n4);
        }
        if ((n5 = dp2.a(n2, n3 - 1, n4)) == hy.ak.ba) {
            dp2.d(n2, n3, n4, 0);
            dp2.d(n2, n3 - 1, n4, Block.aj.ba);
        }
    }

    public int a(int n2, Random random) {
        return Block.ak.ba;
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        if (this != Block.ak) {
            super.a(hb2, n2, n3, n4, n5);
        }
        if (n5 == 1) {
            return true;
        }
        if (!super.a(hb2, n2, n3, n4, n5)) {
            return false;
        }
        if (n5 == 0) {
            return true;
        }
        return hb2.a(n2, n3, n4) != this.ba;
    }
}

