package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ag
extends Block {
    protected ag(int n2, int n3) {
        super(n2, n3, Material.n);
        this.a(true);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public int c() {
        return 20;
    }

    public boolean b() {
        return false;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        if (dp2.d(n2 - 1, n3, n4)) {
            return true;
        }
        if (dp2.d(n2 + 1, n3, n4)) {
            return true;
        }
        if (dp2.d(n2, n3, n4 - 1)) {
            return true;
        }
        if (dp2.d(n2, n3, n4 + 1)) {
            return true;
        }
        return false;
    }

    public void c(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        int n7 = n6 & 8;
        n6 &= 7;
        if (n5 == 2 && dp2.d(n2, n3, n4 + 1)) {
            n6 = 4;
        }
        if (n5 == 3 && dp2.d(n2, n3, n4 - 1)) {
            n6 = 3;
        }
        if (n5 == 4 && dp2.d(n2 + 1, n3, n4)) {
            n6 = 2;
        }
        if (n5 == 5 && dp2.d(n2 - 1, n3, n4)) {
            n6 = 1;
        }
        dp2.b(n2, n3, n4, n6 + n7);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        if (dp2.d(n2 - 1, n3, n4)) {
            dp2.b(n2, n3, n4, 1);
        } else if (dp2.d(n2 + 1, n3, n4)) {
            dp2.b(n2, n3, n4, 2);
        } else if (dp2.d(n2, n3, n4 - 1)) {
            dp2.b(n2, n3, n4, 3);
        } else if (dp2.d(n2, n3, n4 + 1)) {
            dp2.b(n2, n3, n4, 4);
        }
        this.g(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (this.g(dp2, n2, n3, n4)) {
            int n6 = dp2.b(n2, n3, n4) & 7;
            boolean bl2 = false;
            if (!dp2.d(n2 - 1, n3, n4) && n6 == 1) {
                bl2 = true;
            }
            if (!dp2.d(n2 + 1, n3, n4) && n6 == 2) {
                bl2 = true;
            }
            if (!dp2.d(n2, n3, n4 - 1) && n6 == 3) {
                bl2 = true;
            }
            if (!dp2.d(n2, n3, n4 + 1) && n6 == 4) {
                bl2 = true;
            }
            if (bl2) {
                this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
                dp2.d(n2, n3, n4, 0);
            }
        }
    }

    private boolean g(World dp2, int n2, int n3, int n4) {
        if (!this.a(dp2, n2, n3, n4)) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
            return false;
        }
        return true;
    }

    public void a(IBlockAccess hb2, int n2, int n3, int n4) {
        int n5 = hb2.b(n2, n3, n4);
        int n6 = n5 & 7;
        boolean bl2 = (n5 & 8) > 0;
        float f2 = 0.375f;
        float f3 = 0.625f;
        float f4 = 0.1875f;
        float f5 = 0.125f;
        if (bl2) {
            f5 = 0.0625f;
        }
        if (n6 == 1) {
            this.a(0.0f, f2, 0.5f - f4, f5, f3, 0.5f + f4);
        } else if (n6 == 2) {
            this.a(1.0f - f5, f2, 0.5f - f4, 1.0f, f3, 0.5f + f4);
        } else if (n6 == 3) {
            this.a(0.5f - f4, f2, 0.0f, 0.5f + f4, f3, f5);
        } else if (n6 == 4) {
            this.a(0.5f - f4, f2, 1.0f - f5, 0.5f + f4, f3, 1.0f);
        }
    }

    public void b(World dp2, int n2, int n3, int n4, EntityPlayer eq2) {
        this.a(dp2, n2, n3, n4, eq2);
    }

    public boolean a(World dp2, int n2, int n3, int n4, EntityPlayer eq2) {
        int n5 = dp2.b(n2, n3, n4);
        int n6 = n5 & 7;
        int n7 = 8 - (n5 & 8);
        if (n7 == 0) {
            return true;
        }
        dp2.b(n2, n3, n4, n6 + n7);
        dp2.b(n2, n3, n4, n2, n3, n4);
        dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.click", 0.3f, 0.6f);
        dp2.g(n2, n3, n4, this.ba);
        if (n6 == 1) {
            dp2.g(n2 - 1, n3, n4, this.ba);
        } else if (n6 == 2) {
            dp2.g(n2 + 1, n3, n4, this.ba);
        } else if (n6 == 3) {
            dp2.g(n2, n3, n4 - 1, this.ba);
        } else if (n6 == 4) {
            dp2.g(n2, n3, n4 + 1, this.ba);
        } else {
            dp2.g(n2, n3 - 1, n4, this.ba);
        }
        dp2.h(n2, n3, n4, this.ba);
        return true;
    }

    public void b(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        if ((n5 & 8) > 0) {
            dp2.g(n2, n3, n4, this.ba);
            int n6 = n5 & 7;
            if (n6 == 1) {
                dp2.g(n2 - 1, n3, n4, this.ba);
            } else if (n6 == 2) {
                dp2.g(n2 + 1, n3, n4, this.ba);
            } else if (n6 == 3) {
                dp2.g(n2, n3, n4 - 1, this.ba);
            } else if (n6 == 4) {
                dp2.g(n2, n3, n4 + 1, this.ba);
            } else {
                dp2.g(n2, n3 - 1, n4, this.ba);
            }
        }
        super.b(dp2, n2, n3, n4);
    }

    public boolean b(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        return (hb2.b(n2, n3, n4) & 8) > 0;
    }

    public boolean d(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        if ((n6 & 8) == 0) {
            return false;
        }
        int n7 = n6 & 7;
        if (n7 == 5 && n5 == 1) {
            return true;
        }
        if (n7 == 4 && n5 == 2) {
            return true;
        }
        if (n7 == 3 && n5 == 3) {
            return true;
        }
        if (n7 == 2 && n5 == 4) {
            return true;
        }
        if (n7 == 1 && n5 == 5) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return true;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        int n5 = dp2.b(n2, n3, n4);
        if ((n5 & 8) == 0) {
            return;
        }
        dp2.b(n2, n3, n4, n5 & 7);
        dp2.g(n2, n3, n4, this.ba);
        int n6 = n5 & 7;
        if (n6 == 1) {
            dp2.g(n2 - 1, n3, n4, this.ba);
        } else if (n6 == 2) {
            dp2.g(n2 + 1, n3, n4, this.ba);
        } else if (n6 == 3) {
            dp2.g(n2, n3, n4 - 1, this.ba);
        } else if (n6 == 4) {
            dp2.g(n2, n3, n4 + 1, this.ba);
        } else {
            dp2.g(n2, n3 - 1, n4, this.ba);
        }
        dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.click", 0.3f, 0.5f);
        dp2.b(n2, n3, n4, n2, n3, n4);
    }
}

