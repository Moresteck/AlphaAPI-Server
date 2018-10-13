package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.List;
import java.util.Random;

public class at
extends Block {
    private ck a;

    protected at(int n2, int n3, ck ck2) {
        super(n2, n3, Material.d);
        this.a = ck2;
        this.a(true);
        float f2 = 0.0625f;
        this.a(f2, 0.0f, f2, 1.0f - f2, 0.03125f, 1.0f - f2);
    }

    public int c() {
        return 20;
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        return dp2.d(n2, n3 - 1, n4);
    }

    public void e(World dp2, int n2, int n3, int n4) {
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        boolean bl2 = false;
        if (!dp2.d(n2, n3 - 1, n4)) {
            bl2 = true;
        }
        if (bl2) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (dp2.b(n2, n3, n4) == 0) {
            return;
        }
        this.g(dp2, n2, n3, n4);
    }

    public void a(World dp2, int n2, int n3, int n4, Entity db2) {
        if (dp2.b(n2, n3, n4) == 1) {
            return;
        }
        this.g(dp2, n2, n3, n4);
    }

    private void g(World dp2, int n2, int n3, int n4) {
        boolean bl2 = dp2.b(n2, n3, n4) == 1;
        boolean bl3 = false;
        float f2 = 0.125f;
        List list = null;
        if (this.a == ck.a) {
            list = dp2.b(null, AxisAlignedBB.b((float)n2 + f2, n3, (float)n4 + f2, (float)(n2 + 1) - f2, (double)n3 + 0.25, (float)(n4 + 1) - f2));
        }
        if (this.a == ck.b) {
            list = dp2.a(EntityLiving.class, AxisAlignedBB.b((float)n2 + f2, n3, (float)n4 + f2, (float)(n2 + 1) - f2, (double)n3 + 0.25, (float)(n4 + 1) - f2));
        }
        if (this.a == ck.c) {
            list = dp2.a(EntityPlayer.class, AxisAlignedBB.b((float)n2 + f2, n3, (float)n4 + f2, (float)(n2 + 1) - f2, (double)n3 + 0.25, (float)(n4 + 1) - f2));
        }
        if (list.size() > 0) {
            bl3 = true;
        }
        if (bl3 && !bl2) {
            dp2.b(n2, n3, n4, 1);
            dp2.g(n2, n3, n4, this.ba);
            dp2.g(n2, n3 - 1, n4, this.ba);
            dp2.b(n2, n3, n4, n2, n3, n4);
            dp2.a((double)n2 + 0.5, (double)n3 + 0.1, (double)n4 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!bl3 && bl2) {
            dp2.b(n2, n3, n4, 0);
            dp2.g(n2, n3, n4, this.ba);
            dp2.g(n2, n3 - 1, n4, this.ba);
            dp2.b(n2, n3, n4, n2, n3, n4);
            dp2.a((double)n2 + 0.5, (double)n3 + 0.1, (double)n4 + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (bl3) {
            dp2.h(n2, n3, n4, this.ba);
        }
    }

    public void b(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        if (n5 > 0) {
            dp2.g(n2, n3, n4, this.ba);
            dp2.g(n2, n3 - 1, n4, this.ba);
        }
        super.b(dp2, n2, n3, n4);
    }

    public void a(IBlockAccess hb2, int n2, int n3, int n4) {
        boolean bl2 = hb2.b(n2, n3, n4) == 1;
        float f2 = 0.0625f;
        if (bl2) {
            this.a(f2, 0.0f, f2, 1.0f - f2, 0.03125f, 1.0f - f2);
        } else {
            this.a(f2, 0.0f, f2, 1.0f - f2, 0.0625f, 1.0f - f2);
        }
    }

    public boolean b(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        return hb2.b(n2, n3, n4) > 0;
    }

    public boolean d(World dp2, int n2, int n3, int n4, int n5) {
        if (dp2.b(n2, n3, n4) == 0) {
            return false;
        }
        return n5 == 1;
    }

    public boolean d() {
        return true;
    }
}

