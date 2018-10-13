package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ar
extends Block {
    protected ar(int n2, int n3) {
        super(n2, n3, hz.Packet18ArmAnimation);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public fe a(World dp2, int n2, int n3, int n4, Vec3D as2, Vec3D as3) {
        this.a((IBlockAccess)dp2, n2, n3, n4);
        return super.a(dp2, n2, n3, n4, as2, as3);
    }

    public void a(IBlockAccess hb2, int n2, int n3, int n4) {
        int n5 = hb2.b(n2, n3, n4);
        if (n5 >= 2 && n5 <= 5) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    public int a() {
        return 9;
    }

    public int a(Random random) {
        return 1;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        if (dp2.d(n2, n3 - 1, n4)) {
            return true;
        }
        return false;
    }

    public void e(World dp2, int n2, int n3, int n4) {
        dp2.b(n2, n3, n4, 15);
        this.g(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        boolean bl2 = false;
        if (!dp2.d(n2, n3 - 1, n4)) {
            bl2 = true;
        }
        if (n6 == 2 && !dp2.d(n2 + 1, n3, n4)) {
            bl2 = true;
        }
        if (n6 == 3 && !dp2.d(n2 - 1, n3, n4)) {
            bl2 = true;
        }
        if (n6 == 4 && !dp2.d(n2, n3, n4 - 1)) {
            bl2 = true;
        }
        if (n6 == 5 && !dp2.d(n2, n3, n4 + 1)) {
            bl2 = true;
        }
        if (bl2) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        } else if (n5 > 0 && Block.n[n5].d() && fq.a(new fq(this, dp2, n2, n3, n4)) == 3) {
            this.g(dp2, n2, n3, n4);
        }
    }

    private void g(World dp2, int n2, int n3, int n4) {
        new fq(this, dp2, n2, n3, n4).a(dp2.o(n2, n3, n4));
    }
}

