package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class BlockTorch
extends Block {
    protected BlockTorch(int n2, int n3) {
        super(n2, n3, Material.n);
        this.a(true);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 2;
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
        if (dp2.d(n2, n3 - 1, n4)) {
            return true;
        }
        return false;
    }

    public void c(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        if (n5 == 1 && dp2.d(n2, n3 - 1, n4)) {
            n6 = 5;
        }
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
        dp2.b(n2, n3, n4, n6);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        super.a(dp2, n2, n3, n4, random);
        if (dp2.b(n2, n3, n4) == 0) {
            this.e(dp2, n2, n3, n4);
        }
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
        } else if (dp2.d(n2, n3 - 1, n4)) {
            dp2.b(n2, n3, n4, 5);
        }
        this.g(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (this.g(dp2, n2, n3, n4)) {
            int n6 = dp2.b(n2, n3, n4);
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
            if (!dp2.d(n2, n3 - 1, n4) && n6 == 5) {
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

    public fe a(World dp2, int n2, int n3, int n4, Vec3D as2, Vec3D as3) {
        int n5 = dp2.b(n2, n3, n4) & 7;
        float f2 = 0.15f;
        if (n5 == 1) {
            this.a(0.0f, 0.2f, 0.5f - f2, f2 * 2.0f, 0.8f, 0.5f + f2);
        } else if (n5 == 2) {
            this.a(1.0f - f2 * 2.0f, 0.2f, 0.5f - f2, 1.0f, 0.8f, 0.5f + f2);
        } else if (n5 == 3) {
            this.a(0.5f - f2, 0.2f, 0.0f, 0.5f + f2, 0.8f, f2 * 2.0f);
        } else if (n5 == 4) {
            this.a(0.5f - f2, 0.2f, 1.0f - f2 * 2.0f, 0.5f + f2, 0.8f, 1.0f);
        } else {
            f2 = 0.1f;
            this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 0.6f, 0.5f + f2);
        }
        return super.a(dp2, n2, n3, n4, as2, as3);
    }
}

