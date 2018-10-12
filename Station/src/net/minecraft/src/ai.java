/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ai
extends cg {
    int a = 0;
    boolean[] b = new boolean[4];
    int[] c = new int[4];

    protected ai(int n2, hz hz2) {
        super(n2, hz2);
    }

    private void i(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        dp2.a(n2, n3, n4, this.ba + 1, n5);
        dp2.b(n2, n3, n4, n2, n3, n4);
        dp2.f(n2, n3, n4);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        int n5;
        int n6 = this.g(dp2, n2, n3, n4);
        boolean bl2 = true;
        if (n6 > 0) {
            int n7 = -100;
            this.a = 0;
            n7 = this.e(dp2, n2 - 1, n3, n4, n7);
            n7 = this.e(dp2, n2 + 1, n3, n4, n7);
            n7 = this.e(dp2, n2, n3, n4 - 1, n7);
            n5 = (n7 = this.e(dp2, n2, n3, n4 + 1, n7)) + this.d;
            if (n5 >= 8 || n7 < 0) {
                n5 = -1;
            }
            if (this.g(dp2, n2, n3 + 1, n4) >= 0) {
                int n8 = this.g(dp2, n2, n3 + 1, n4);
                n5 = n8 >= 8 ? n8 : n8 + 8;
            }
            if (this.a >= 2 && this.bl == hz.f) {
                if (dp2.d(n2, n3 - 1, n4)) {
                    n5 = 0;
                } else if (dp2.c(n2, n3 - 1, n4) == this.bl && dp2.b(n2, n3, n4) == 0) {
                    n5 = 0;
                }
            }
            if (this.bl == hz.PlayerListBox && n6 < 8 && n5 < 8 && n5 > n6 && random.nextInt(4) != 0) {
                n5 = n6;
                bl2 = false;
            }
            if (n5 != n6) {
                n6 = n5;
                if (n6 < 0) {
                    dp2.d(n2, n3, n4, 0);
                } else {
                    dp2.b(n2, n3, n4, n6);
                    dp2.h(n2, n3, n4, this.ba);
                    dp2.g(n2, n3, n4, this.ba);
                }
            } else if (bl2) {
                this.i(dp2, n2, n3, n4);
            }
        } else {
            this.i(dp2, n2, n3, n4);
        }
        if (this.l(dp2, n2, n3 - 1, n4)) {
            if (n6 >= 8) {
                dp2.b(n2, n3 - 1, n4, this.ba, n6);
            } else {
                dp2.b(n2, n3 - 1, n4, this.ba, n6 + 8);
            }
        } else if (n6 >= 0 && (n6 == 0 || this.k(dp2, n2, n3 - 1, n4))) {
            boolean[] arrbl = this.j(dp2, n2, n3, n4);
            n5 = n6 + this.d;
            if (n6 >= 8) {
                n5 = 1;
            }
            if (n5 >= 8) {
                return;
            }
            if (arrbl[0]) {
                this.f(dp2, n2 - 1, n3, n4, n5);
            }
            if (arrbl[1]) {
                this.f(dp2, n2 + 1, n3, n4, n5);
            }
            if (arrbl[2]) {
                this.f(dp2, n2, n3, n4 - 1, n5);
            }
            if (arrbl[3]) {
                this.f(dp2, n2, n3, n4 + 1, n5);
            }
        }
    }

    private void f(World dp2, int n2, int n3, int n4, int n5) {
        if (this.l(dp2, n2, n3, n4)) {
            int n6 = dp2.a(n2, n3, n4);
            if (n6 > 0) {
                if (this.bl == hz.PlayerListBox) {
                    this.h(dp2, n2, n3, n4);
                } else {
                    Block.n[n6].a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
                }
            }
            dp2.b(n2, n3, n4, this.ba, n5);
        }
    }

    private int a(World dp2, int n2, int n3, int n4, int n5, int n6) {
        int n7 = 1000;
        for (int i2 = 0; i2 < 4; ++i2) {
            int n8;
            if (i2 == 0 && n6 == 1 || i2 == 1 && n6 == 0 || i2 == 2 && n6 == 3 || i2 == 3 && n6 == 2) continue;
            int n9 = n2;
            int n10 = n3;
            int n11 = n4;
            if (i2 == 0) {
                --n9;
            }
            if (i2 == 1) {
                ++n9;
            }
            if (i2 == 2) {
                --n11;
            }
            if (i2 == 3) {
                ++n11;
            }
            if (this.k(dp2, n9, n10, n11) || dp2.c(n9, n10, n11) == this.bl && dp2.b(n9, n10, n11) == 0) continue;
            if (!this.k(dp2, n9, n10 - 1, n11)) {
                return n5;
            }
            if (n5 >= 4 || (n8 = this.a(dp2, n9, n10, n11, n5 + 1, i2)) >= n7) continue;
            n7 = n8;
        }
        return n7;
    }

    private boolean[] j(World dp2, int n2, int n3, int n4) {
        int n5;
        int n6;
        for (n6 = 0; n6 < 4; ++n6) {
            this.c[n6] = 1000;
            n5 = n2;
            int n7 = n3;
            int n8 = n4;
            if (n6 == 0) {
                --n5;
            }
            if (n6 == 1) {
                ++n5;
            }
            if (n6 == 2) {
                --n8;
            }
            if (n6 == 3) {
                ++n8;
            }
            if (this.k(dp2, n5, n7, n8) || dp2.c(n5, n7, n8) == this.bl && dp2.b(n5, n7, n8) == 0) continue;
            this.c[n6] = !this.k(dp2, n5, n7 - 1, n8) ? 0 : this.a(dp2, n5, n7, n8, 1, n6);
        }
        n6 = this.c[0];
        for (n5 = 1; n5 < 4; ++n5) {
            if (this.c[n5] >= n6) continue;
            n6 = this.c[n5];
        }
        for (n5 = 0; n5 < 4; ++n5) {
            this.b[n5] = this.c[n5] == n6;
        }
        return this.b;
    }

    private boolean k(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.a(n2, n3, n4);
        if (n5 == Block.aE.ba || n5 == Block.aL.ba || n5 == Block.aD.ba || n5 == Block.aF.ba || n5 == Block.aX.ba) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        hz hz2 = Block.n[n5].bl;
        if (hz2.a()) {
            return true;
        }
        return false;
    }

    protected int e(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = this.g(dp2, n2, n3, n4);
        if (n6 < 0) {
            return n5;
        }
        if (n6 == 0) {
            ++this.a;
        }
        if (n6 >= 8) {
            n6 = 0;
        }
        return n5 < 0 || n6 < n5 ? n6 : n5;
    }

    private boolean l(World dp2, int n2, int n3, int n4) {
        hz hz2 = dp2.c(n2, n3, n4);
        if (hz2 == this.bl) {
            return false;
        }
        if (hz2 == hz.PlayerListBox) {
            return false;
        }
        return !this.k(dp2, n2, n3, n4);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        super.e(dp2, n2, n3, n4);
        if (dp2.a(n2, n3, n4) == this.ba) {
            dp2.h(n2, n3, n4, this.ba);
        }
    }
}

