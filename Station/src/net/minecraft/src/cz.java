/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class cz
extends Block {
    private boolean a = true;

    public cz(int n2, int n3) {
        super(n2, n3, hz.n);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 5;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        return dp2.d(n2, n3 - 1, n4);
    }

    private void g(World dp2, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8 = dp2.b(n2, n3, n4);
        int n9 = 0;
        this.a = false;
        boolean bl2 = dp2.o(n2, n3, n4);
        this.a = true;
        if (bl2) {
            n9 = 15;
        } else {
            for (n5 = 0; n5 < 4; ++n5) {
                n7 = n2;
                n6 = n4;
                if (n5 == 0) {
                    --n7;
                }
                if (n5 == 1) {
                    ++n7;
                }
                if (n5 == 2) {
                    --n6;
                }
                if (n5 == 3) {
                    ++n6;
                }
                n9 = this.f(dp2, n7, n3, n6, n9);
                if (dp2.d(n7, n3, n6) && !dp2.d(n2, n3 + 1, n4)) {
                    n9 = this.f(dp2, n7, n3 + 1, n6, n9);
                    continue;
                }
                if (dp2.d(n7, n3, n6)) continue;
                n9 = this.f(dp2, n7, n3 - 1, n6, n9);
            }
            n9 = n9 > 0 ? --n9 : 0;
        }
        if (n8 != n9) {
            dp2.b(n2, n3, n4, n9);
            dp2.b(n2, n3, n4, n2, n3, n4);
            if (n9 > 0) {
                --n9;
            }
            for (n5 = 0; n5 < 4; ++n5) {
                int n10;
                n7 = n2;
                n6 = n4;
                int n11 = n3 - 1;
                if (n5 == 0) {
                    --n7;
                }
                if (n5 == 1) {
                    ++n7;
                }
                if (n5 == 2) {
                    --n6;
                }
                if (n5 == 3) {
                    ++n6;
                }
                if (dp2.d(n7, n3, n6)) {
                    n11 += 2;
                }
                if ((n10 = this.f(dp2, n7, n3, n6, -1)) >= 0 && n10 != n9) {
                    this.g(dp2, n7, n3, n6);
                }
                if ((n10 = this.f(dp2, n7, n11, n6, -1)) < 0 || n10 == n9) continue;
                this.g(dp2, n7, n11, n6);
            }
            if (n8 == 0 || n9 == 0) {
                dp2.g(n2, n3, n4, this.ba);
                dp2.g(n2 - 1, n3, n4, this.ba);
                dp2.g(n2 + 1, n3, n4, this.ba);
                dp2.g(n2, n3, n4 - 1, this.ba);
                dp2.g(n2, n3, n4 + 1, this.ba);
                dp2.g(n2, n3 - 1, n4, this.ba);
                dp2.g(n2, n3 + 1, n4, this.ba);
            }
        }
    }

    private void h(World dp2, int n2, int n3, int n4) {
        if (dp2.a(n2, n3, n4) != this.ba) {
            return;
        }
        dp2.g(n2, n3, n4, this.ba);
        dp2.g(n2 - 1, n3, n4, this.ba);
        dp2.g(n2 + 1, n3, n4, this.ba);
        dp2.g(n2, n3, n4 - 1, this.ba);
        dp2.g(n2, n3, n4 + 1, this.ba);
        dp2.g(n2, n3 - 1, n4, this.ba);
        dp2.g(n2, n3 + 1, n4, this.ba);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        super.e(dp2, n2, n3, n4);
        this.g(dp2, n2, n3, n4);
        dp2.g(n2, n3 + 1, n4, this.ba);
        dp2.g(n2, n3 - 1, n4, this.ba);
        this.h(dp2, n2 - 1, n3, n4);
        this.h(dp2, n2 + 1, n3, n4);
        this.h(dp2, n2, n3, n4 - 1);
        this.h(dp2, n2, n3, n4 + 1);
        if (dp2.d(n2 - 1, n3, n4)) {
            this.h(dp2, n2 - 1, n3 + 1, n4);
        } else {
            this.h(dp2, n2 - 1, n3 - 1, n4);
        }
        if (dp2.d(n2 + 1, n3, n4)) {
            this.h(dp2, n2 + 1, n3 + 1, n4);
        } else {
            this.h(dp2, n2 + 1, n3 - 1, n4);
        }
        if (dp2.d(n2, n3, n4 - 1)) {
            this.h(dp2, n2, n3 + 1, n4 - 1);
        } else {
            this.h(dp2, n2, n3 - 1, n4 - 1);
        }
        if (dp2.d(n2, n3, n4 + 1)) {
            this.h(dp2, n2, n3 + 1, n4 + 1);
        } else {
            this.h(dp2, n2, n3 - 1, n4 + 1);
        }
    }

    public void b(World dp2, int n2, int n3, int n4) {
        super.b(dp2, n2, n3, n4);
        dp2.g(n2, n3 + 1, n4, this.ba);
        dp2.g(n2, n3 - 1, n4, this.ba);
        this.g(dp2, n2, n3, n4);
        this.h(dp2, n2 - 1, n3, n4);
        this.h(dp2, n2 + 1, n3, n4);
        this.h(dp2, n2, n3, n4 - 1);
        this.h(dp2, n2, n3, n4 + 1);
        if (dp2.d(n2 - 1, n3, n4)) {
            this.h(dp2, n2 - 1, n3 + 1, n4);
        } else {
            this.h(dp2, n2 - 1, n3 - 1, n4);
        }
        if (dp2.d(n2 + 1, n3, n4)) {
            this.h(dp2, n2 + 1, n3 + 1, n4);
        } else {
            this.h(dp2, n2 + 1, n3 - 1, n4);
        }
        if (dp2.d(n2, n3, n4 - 1)) {
            this.h(dp2, n2, n3 + 1, n4 - 1);
        } else {
            this.h(dp2, n2, n3 - 1, n4 - 1);
        }
        if (dp2.d(n2, n3, n4 + 1)) {
            this.h(dp2, n2, n3 + 1, n4 + 1);
        } else {
            this.h(dp2, n2, n3 - 1, n4 + 1);
        }
    }

    private int f(World dp2, int n2, int n3, int n4, int n5) {
        if (dp2.a(n2, n3, n4) != this.ba) {
            return n5;
        }
        int n6 = dp2.b(n2, n3, n4);
        if (n6 > n5) {
            return n6;
        }
        return n5;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        boolean bl2 = this.a(dp2, n2, n3, n4);
        if (!bl2) {
            this.a_(dp2, n2, n3, n4, n6);
            dp2.d(n2, n3, n4, 0);
        } else {
            this.g(dp2, n2, n3, n4);
        }
        super.b(dp2, n2, n3, n4, n5);
    }

    public int a(int n2, Random random) {
        return en.aA.aQ;
    }

    public boolean d(World dp2, int n2, int n3, int n4, int n5) {
        if (!this.a) {
            return false;
        }
        return this.b((IBlockAccess)dp2, n2, n3, n4, n5);
    }

    public boolean b(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        boolean bl2;
        if (!this.a) {
            return false;
        }
        if (hb2.b(n2, n3, n4) == 0) {
            return false;
        }
        if (n5 == 1) {
            return true;
        }
        boolean bl3 = cz.b(hb2, n2 - 1, n3, n4) || !hb2.d(n2 - 1, n3, n4) && cz.b(hb2, n2 - 1, n3 - 1, n4);
        boolean bl4 = cz.b(hb2, n2 + 1, n3, n4) || !hb2.d(n2 + 1, n3, n4) && cz.b(hb2, n2 + 1, n3 - 1, n4);
        boolean bl5 = cz.b(hb2, n2, n3, n4 - 1) || !hb2.d(n2, n3, n4 - 1) && cz.b(hb2, n2, n3 - 1, n4 - 1);
        boolean bl6 = bl2 = cz.b(hb2, n2, n3, n4 + 1) || !hb2.d(n2, n3, n4 + 1) && cz.b(hb2, n2, n3 - 1, n4 + 1);
        if (!hb2.d(n2, n3 + 1, n4)) {
            if (hb2.d(n2 - 1, n3, n4) && cz.b(hb2, n2 - 1, n3 + 1, n4)) {
                bl3 = true;
            }
            if (hb2.d(n2 + 1, n3, n4) && cz.b(hb2, n2 + 1, n3 + 1, n4)) {
                bl4 = true;
            }
            if (hb2.d(n2, n3, n4 - 1) && cz.b(hb2, n2, n3 + 1, n4 - 1)) {
                bl5 = true;
            }
            if (hb2.d(n2, n3, n4 + 1) && cz.b(hb2, n2, n3 + 1, n4 + 1)) {
                bl2 = true;
            }
        }
        if (!(bl5 || bl4 || bl3 || bl2 || n5 < 2 || n5 > 5)) {
            return true;
        }
        if (n5 == 2 && bl5 && !bl3 && !bl4) {
            return true;
        }
        if (n5 == 3 && bl2 && !bl3 && !bl4) {
            return true;
        }
        if (n5 == 4 && bl3 && !bl5 && !bl2) {
            return true;
        }
        if (n5 == 5 && bl4 && !bl5 && !bl2) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return this.a;
    }

    public static boolean b(IBlockAccess hb2, int n2, int n3, int n4) {
        int n5 = hb2.a(n2, n3, n4);
        if (n5 == Block.av.ba) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        if (Block.n[n5].d()) {
            return true;
        }
        return false;
    }
}

