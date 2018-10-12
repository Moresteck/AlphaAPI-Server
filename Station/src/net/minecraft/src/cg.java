/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public abstract class cg
extends Block {
    protected int d = 1;

    protected cg(int n2, hz hz2) {
        super(n2, (hz2 == hz.PlayerListBox ? 14 : 12) * 16 + 13, hz2);
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (hz2 == hz.PlayerListBox) {
            this.d = 2;
        }
        this.a(0.0f + f3, 0.0f + f2, 0.0f + f3, 1.0f + f3, 1.0f + f2, 1.0f + f3);
        this.a(true);
    }

    public static float b(int n2) {
        if (n2 >= 8) {
            n2 = 0;
        }
        float f2 = (float)(n2 + 1) / 9.0f;
        return f2;
    }

    public int a(int n2) {
        if (n2 == 0 || n2 == 1) {
            return this.aZ;
        }
        return this.aZ + 1;
    }

    protected int g(World dp2, int n2, int n3, int n4) {
        if (dp2.c(n2, n3, n4) != this.bl) {
            return -1;
        }
        return dp2.b(n2, n3, n4);
    }

    protected int b(IBlockAccess hb2, int n2, int n3, int n4) {
        if (hb2.c(n2, n3, n4) != this.bl) {
            return -1;
        }
        int n5 = hb2.b(n2, n3, n4);
        if (n5 >= 8) {
            n5 = 0;
        }
        return n5;
    }

    public boolean b() {
        return false;
    }

    public boolean a(int n2, boolean bl2) {
        return bl2 && n2 == 0;
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        hz hz2 = hb2.c(n2, n3, n4);
        if (hz2 == this.bl) {
            return false;
        }
        if (hz2 == hz.r) {
            return false;
        }
        if (n5 == 1) {
            return true;
        }
        return super.a(hb2, n2, n3, n4, n5);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public int a() {
        return 4;
    }

    public int a(int n2, Random random) {
        return 0;
    }

    public int a(Random random) {
        return 0;
    }

    private Vec3D c(IBlockAccess hb2, int n2, int n3, int n4) {
        int n5;
        Vec3D as2 = as.b(0.0, 0.0, 0.0);
        int n6 = this.b(hb2, n2, n3, n4);
        for (n5 = 0; n5 < 4; ++n5) {
            int n7;
            int n8;
            int n9 = n2;
            int n10 = n3;
            int n11 = n4;
            if (n5 == 0) {
                --n9;
            }
            if (n5 == 1) {
                --n11;
            }
            if (n5 == 2) {
                ++n9;
            }
            if (n5 == 3) {
                ++n11;
            }
            if ((n8 = this.b(hb2, n9, n10, n11)) < 0) {
                if (hb2.c(n9, n10, n11).c() || (n8 = this.b(hb2, n9, n10 - 1, n11)) < 0) continue;
                n7 = n8 - (n6 - 8);
                as2 = as2.c((n9 - n2) * n7, (n10 - n3) * n7, (n11 - n4) * n7);
                continue;
            }
            if (n8 < 0) continue;
            n7 = n8 - n6;
            as2 = as2.c((n9 - n2) * n7, (n10 - n3) * n7, (n11 - n4) * n7);
        }
        if (hb2.b(n2, n3, n4) >= 8) {
            n5 = 0;
            if (n5 != 0 || this.a(hb2, n2, n3, n4 - 1, 2)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2, n3, n4 + 1, 3)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2 - 1, n3, n4, 4)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2 + 1, n3, n4, 5)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2, n3 + 1, n4 - 1, 2)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2, n3 + 1, n4 + 1, 3)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2 - 1, n3 + 1, n4, 4)) {
                n5 = 1;
            }
            if (n5 != 0 || this.a(hb2, n2 + 1, n3 + 1, n4, 5)) {
                n5 = 1;
            }
            if (n5 != 0) {
                as2 = as2.b().c(0.0, -6.0, 0.0);
            }
        }
        as2 = as2.b();
        return as2;
    }

    public void a(World dp2, int n2, int n3, int n4, Entity db2, Vec3D as2) {
        Vec3D as3 = this.c(dp2, n2, n3, n4);
        as2.a += as3.a;
        as2.b += as3.b;
        as2.c += as3.c;
    }

    public int c() {
        if (this.bl == hz.f) {
            return 5;
        }
        if (this.bl == hz.PlayerListBox) {
            return 30;
        }
        return 0;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        super.a(dp2, n2, n3, n4, random);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        this.i(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        this.i(dp2, n2, n3, n4);
    }

    private void i(World dp2, int n2, int n3, int n4) {
        if (dp2.a(n2, n3, n4) != this.ba) {
            return;
        }
        if (this.bl == hz.PlayerListBox) {
            boolean bl2 = false;
            if (bl2 || dp2.c(n2, n3, n4 - 1) == hz.f) {
                bl2 = true;
            }
            if (bl2 || dp2.c(n2, n3, n4 + 1) == hz.f) {
                bl2 = true;
            }
            if (bl2 || dp2.c(n2 - 1, n3, n4) == hz.f) {
                bl2 = true;
            }
            if (bl2 || dp2.c(n2 + 1, n3, n4) == hz.f) {
                bl2 = true;
            }
            if (bl2 || dp2.c(n2, n3 + 1, n4) == hz.f) {
                bl2 = true;
            }
            if (bl2) {
                int n5 = dp2.b(n2, n3, n4);
                if (n5 == 0) {
                    dp2.d(n2, n3, n4, Block.ap.ba);
                } else if (n5 <= 4) {
                    dp2.d(n2, n3, n4, Block.w.ba);
                }
                this.h(dp2, n2, n3, n4);
            }
        }
    }

    protected void h(World dp2, int n2, int n3, int n4) {
        dp2.a((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.fizz", 0.5f, 2.6f + (dp2.k.nextFloat() - dp2.k.nextFloat()) * 0.8f);
        for (int i2 = 0; i2 < 8; ++i2) {
            dp2.a("largesmoke", (double)n2 + Math.random(), (double)n3 + 1.2, (double)n4 + Math.random(), 0.0, 0.0, 0.0);
        }
    }
}

