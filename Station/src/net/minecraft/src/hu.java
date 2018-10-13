package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hu
extends Block {
    private int[] a = new int[256];
    private int[] b = new int[256];

    protected hu(int n2, int n3) {
        super(n2, n3, hz.l);
        this.a(Block.x.ba, 5, 20);
        this.a(Block.J.ba, 5, 5);
        this.a(Block.K.ba, 30, 60);
        this.a(Block.an.ba, 30, 20);
        this.a(Block.am.ba, 15, 100);
        this.a(Block.ab.ba, 30, 60);
        this.a(true);
    }

    private void a(int n2, int n3, int n4) {
        this.a[n2] = n3;
        this.b[n2] = n4;
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 3;
    }

    public int a(Random random) {
        return 0;
    }

    public int c() {
        return 10;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        int n5 = dp2.b(n2, n3, n4);
        if (n5 < 15) {
            dp2.b(n2, n3, n4, n5 + 1);
            dp2.h(n2, n3, n4, this.ba);
        }
        if (!this.g(dp2, n2, n3, n4)) {
            if (!dp2.d(n2, n3 - 1, n4) || n5 > 3) {
                dp2.d(n2, n3, n4, 0);
            }
            return;
        }
        if (!this.be(dp2, n2, n3 - 1, n4) && n5 == 15 && random.nextInt(4) == 0) {
            dp2.d(n2, n3, n4, 0);
            return;
        }
        if (n5 % 2 == 0 && n5 > 2) {
            this.a(dp2, n2 + 1, n3, n4, 300, random);
            this.a(dp2, n2 - 1, n3, n4, 300, random);
            this.a(dp2, n2, n3 - 1, n4, 200, random);
            this.a(dp2, n2, n3 + 1, n4, 250, random);
            this.a(dp2, n2, n3, n4 - 1, 300, random);
            this.a(dp2, n2, n3, n4 + 1, 300, random);
            for (int i2 = n2 - 1; i2 <= n2 + 1; ++i2) {
                for (int i3 = n4 - 1; i3 <= n4 + 1; ++i3) {
                    for (int i4 = n3 - 1; i4 <= n3 + 4; ++i4) {
                        int n6;
                        if (i2 == n2 && i4 == n3 && i3 == n4) continue;
                        int n7 = 100;
                        if (i4 > n3 + 1) {
                            n7 += (i4 - (n3 + 1)) * 100;
                        }
                        if ((n6 = this.h(dp2, i2, i4, i3)) <= 0 || random.nextInt(n7) > n6) continue;
                        dp2.d(i2, i4, i3, this.ba);
                    }
                }
            }
        }
    }

    private void a(World dp2, int n2, int n3, int n4, int n5, Random random) {
        int n6 = this.b[dp2.a(n2, n3, n4)];
        if (random.nextInt(n5) < n6) {
            boolean bl2;
            boolean bl3 = bl2 = dp2.a(n2, n3, n4) == Block.am.ba;
            if (random.nextInt(2) == 0) {
                dp2.d(n2, n3, n4, this.ba);
            } else {
                dp2.d(n2, n3, n4, 0);
            }
            if (bl2) {
                Block.am.a(dp2, n2, n3, n4, 0);
            }
        }
    }

    private boolean g(World dp2, int n2, int n3, int n4) {
        if (this.be(dp2, n2 + 1, n3, n4)) {
            return true;
        }
        if (this.be(dp2, n2 - 1, n3, n4)) {
            return true;
        }
        if (this.be(dp2, n2, n3 - 1, n4)) {
            return true;
        }
        if (this.be(dp2, n2, n3 + 1, n4)) {
            return true;
        }
        if (this.be(dp2, n2, n3, n4 - 1)) {
            return true;
        }
        if (this.be(dp2, n2, n3, n4 + 1)) {
            return true;
        }
        return false;
    }

    private int h(World dp2, int n2, int n3, int n4) {
        int n5 = 0;
        if (dp2.a(n2, n3, n4) != 0) {
            return 0;
        }
        n5 = this.f(dp2, n2 + 1, n3, n4, n5);
        n5 = this.f(dp2, n2 - 1, n3, n4, n5);
        n5 = this.f(dp2, n2, n3 - 1, n4, n5);
        n5 = this.f(dp2, n2, n3 + 1, n4, n5);
        n5 = this.f(dp2, n2, n3, n4 - 1, n5);
        n5 = this.f(dp2, n2, n3, n4 + 1, n5);
        return n5;
    }

    public boolean e() {
        return false;
    }

    public boolean be(IBlockAccess hb2, int n2, int n3, int n4) {
        return this.a[hb2.a(n2, n3, n4)] > 0;
    }

    public int f(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = this.a[dp2.a(n2, n3, n4)];
        if (n6 > n5) {
            return n6;
        }
        return n5;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        return dp2.d(n2, n3 - 1, n4) || this.g(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (!dp2.d(n2, n3 - 1, n4) && !this.g(dp2, n2, n3, n4)) {
            dp2.d(n2, n3, n4, 0);
            return;
        }
    }

    public void e(World dp2, int n2, int n3, int n4) {
        if (!dp2.d(n2, n3 - 1, n4) && !this.g(dp2, n2, n3, n4)) {
            dp2.d(n2, n3, n4, 0);
            return;
        }
        dp2.h(n2, n3, n4, this.ba);
    }
}

