package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class dm
extends cl {
    private final boolean a;

    protected dm(int n2, boolean bl2) {
        super(n2, hz.d);
        this.a = bl2;
        this.aZ = 45;
    }

    public int a(int n2, Random random) {
        return Block.aB.ba;
    }

    public void e(World dp2, int n2, int n3, int n4) {
        super.e(dp2, n2, n3, n4);
        this.g(dp2, n2, n3, n4);
    }

    private void g(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.a(n2, n3, n4 - 1);
        int n6 = dp2.a(n2, n3, n4 + 1);
        int n7 = dp2.a(n2 - 1, n3, n4);
        int n8 = dp2.a(n2 + 1, n3, n4);
        int n9 = 3;
        if (Block.p[n5] && !Block.p[n6]) {
            n9 = 3;
        }
        if (Block.p[n6] && !Block.p[n5]) {
            n9 = 2;
        }
        if (Block.p[n7] && !Block.p[n8]) {
            n9 = 5;
        }
        if (Block.p[n8] && !Block.p[n7]) {
            n9 = 4;
        }
        dp2.b(n2, n3, n4, n9);
    }

    public int a(int n2) {
        if (n2 == 1) {
            return Block.t.ba;
        }
        if (n2 == 0) {
            return Block.t.ba;
        }
        if (n2 == 3) {
            return this.aZ - 1;
        }
        return this.aZ;
    }

    public boolean a(World dp2, int n2, int n3, int n4, EntityPlayer eq2) {
        BlockFurnace cx2 = (BlockFurnace)dp2.k(n2, n3, n4);
        eq2.a(cx2);
        return true;
    }

    public static void a(boolean bl2, World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        TileEntity ap2 = dp2.k(n2, n3, n4);
        if (bl2) {
            dp2.d(n2, n3, n4, Block.aC.ba);
        } else {
            dp2.d(n2, n3, n4, Block.aB.ba);
        }
        dp2.b(n2, n3, n4, n5);
        dp2.a(n2, n3, n4, ap2);
    }

    protected TileEntity a_() {
        return new BlockFurnace();
    }
}

