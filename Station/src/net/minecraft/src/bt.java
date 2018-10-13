package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class bt
extends BlockTorch {
    private boolean a = false;
    private static List b = new ArrayList();

    private boolean a(World dp2, int n2, int n3, int n4, boolean bl2) {
        if (bl2) {
            b.add(new he(n2, n3, n4, dp2.b));
        }
        int n5 = 0;
        for (int i2 = 0; i2 < b.size(); ++i2) {
            he he2 = (he)b.get(i2);
            if (he2.a != n2 || he2.b != n3 || he2.c != n4 || ++n5 < 8) continue;
            return true;
        }
        return false;
    }

    protected bt(int n2, int n3, boolean bl2) {
        super(n2, n3);
        this.a = bl2;
        this.a(true);
    }

    public int c() {
        return 2;
    }

    public void e(World dp2, int n2, int n3, int n4) {
        if (dp2.b(n2, n3, n4) == 0) {
            super.e(dp2, n2, n3, n4);
        }
        if (this.a) {
            dp2.g(n2, n3 - 1, n4, this.ba);
            dp2.g(n2, n3 + 1, n4, this.ba);
            dp2.g(n2 - 1, n3, n4, this.ba);
            dp2.g(n2 + 1, n3, n4, this.ba);
            dp2.g(n2, n3, n4 - 1, this.ba);
            dp2.g(n2, n3, n4 + 1, this.ba);
        }
    }

    public void b(World dp2, int n2, int n3, int n4) {
        if (this.a) {
            dp2.g(n2, n3 - 1, n4, this.ba);
            dp2.g(n2, n3 + 1, n4, this.ba);
            dp2.g(n2 - 1, n3, n4, this.ba);
            dp2.g(n2 + 1, n3, n4, this.ba);
            dp2.g(n2, n3, n4 - 1, this.ba);
            dp2.g(n2, n3, n4 + 1, this.ba);
        }
    }

    public boolean b(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        if (!this.a) {
            return false;
        }
        int n6 = hb2.b(n2, n3, n4);
        if (n6 == 5 && n5 == 1) {
            return false;
        }
        if (n6 == 3 && n5 == 3) {
            return false;
        }
        if (n6 == 4 && n5 == 2) {
            return false;
        }
        if (n6 == 1 && n5 == 5) {
            return false;
        }
        if (n6 == 2 && n5 == 4) {
            return false;
        }
        return true;
    }

    private boolean g(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        if (n5 == 5 && dp2.j(n2, n3 - 1, n4, 0)) {
            return true;
        }
        if (n5 == 3 && dp2.j(n2, n3, n4 - 1, 2)) {
            return true;
        }
        if (n5 == 4 && dp2.j(n2, n3, n4 + 1, 3)) {
            return true;
        }
        if (n5 == 1 && dp2.j(n2 - 1, n3, n4, 4)) {
            return true;
        }
        if (n5 == 2 && dp2.j(n2 + 1, n3, n4, 5)) {
            return true;
        }
        return false;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        boolean bl2 = this.g(dp2, n2, n3, n4);
        while (b.size() > 0 && dp2.b - ((he)bt.b.get((int)0)).d > 100L) {
            b.remove(0);
        }
        if (this.a) {
            if (bl2) {
                dp2.b(n2, n3, n4, Block.aP.ba, dp2.b(n2, n3, n4));
                if (this.a(dp2, n2, n3, n4, true)) {
                    dp2.a((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.fizz", 0.5f, 2.6f + (dp2.k.nextFloat() - dp2.k.nextFloat()) * 0.8f);
                    for (int i2 = 0; i2 < 5; ++i2) {
                        double d2 = (double)n2 + random.nextDouble() * 0.6 + 0.2;
                        double d3 = (double)n3 + random.nextDouble() * 0.6 + 0.2;
                        double d4 = (double)n4 + random.nextDouble() * 0.6 + 0.2;
                        dp2.a("smoke", d2, d3, d4, 0.0, 0.0, 0.0);
                    }
                }
            }
        } else if (!bl2 && !this.a(dp2, n2, n3, n4, false)) {
            dp2.b(n2, n3, n4, Block.aQ.ba, dp2.b(n2, n3, n4));
        }
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        super.b(dp2, n2, n3, n4, n5);
        dp2.h(n2, n3, n4, this.ba);
    }

    public boolean d(World dp2, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            return this.b((IBlockAccess)dp2, n2, n3, n4, n5);
        }
        return false;
    }

    public int a(int n2, Random random) {
        return Block.aQ.ba;
    }

    public boolean d() {
        return true;
    }
}

