package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hn
extends Block {
    protected hn(int n2, hz hz2) {
        super(n2, hz2);
        this.aZ = 97;
        if (hz2 == hz.e) {
            ++this.aZ;
        }
        float f2 = 0.5f;
        float f3 = 1.0f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f3, 0.5f + f2);
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 7;
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        this.a((IBlockAccess)dp2, n2, n3, n4);
        return super.d(dp2, n2, n3, n4);
    }

    public void a(IBlockAccess hb2, int n2, int n3, int n4) {
        this.b(this.d(hb2.b(n2, n3, n4)));
    }

    public void b(int n2) {
        float f2 = 0.1875f;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        if (n2 == 0) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f2);
        }
        if (n2 == 1) {
            this.a(1.0f - f2, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (n2 == 2) {
            this.a(0.0f, 0.0f, 1.0f - f2, 1.0f, 1.0f, 1.0f);
        }
        if (n2 == 3) {
            this.a(0.0f, 0.0f, 0.0f, f2, 1.0f, 1.0f);
        }
    }

    public void b(World dp2, int n2, int n3, int n4, eq eq2) {
        this.a(dp2, n2, n3, n4, eq2);
    }

    public boolean a(World dp2, int n2, int n3, int n4, eq eq2) {
        if (this.bl == hz.e) {
            return true;
        }
        int n5 = dp2.b(n2, n3, n4);
        if ((n5 & 8) != 0) {
            if (dp2.a(n2, n3 - 1, n4) == this.ba) {
                this.a(dp2, n2, n3 - 1, n4, eq2);
            }
            return true;
        }
        if (dp2.a(n2, n3 + 1, n4) == this.ba) {
            dp2.b(n2, n3 + 1, n4, (n5 ^ 4) + 8);
        }
        dp2.b(n2, n3, n4, n5 ^ 4);
        dp2.b(n2, n3 - 1, n4, n2, n3, n4);
        if (Math.random() < 0.5) {
            dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_open", 1.0f, dp2.k.nextFloat() * 0.1f + 0.9f);
        } else {
            dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_close", 1.0f, dp2.k.nextFloat() * 0.1f + 0.9f);
        }
        return true;
    }

    public void a(World dp2, int n2, int n3, int n4, boolean bl2) {
        boolean bl3;
        int n5 = dp2.b(n2, n3, n4);
        if ((n5 & 8) != 0) {
            if (dp2.a(n2, n3 - 1, n4) == this.ba) {
                this.a(dp2, n2, n3 - 1, n4, bl2);
            }
            return;
        }
        boolean bl4 = bl3 = (dp2.b(n2, n3, n4) & 4) > 0;
        if (bl3 == bl2) {
            return;
        }
        if (dp2.a(n2, n3 + 1, n4) == this.ba) {
            dp2.b(n2, n3 + 1, n4, (n5 ^ 4) + 8);
        }
        dp2.b(n2, n3, n4, n5 ^ 4);
        dp2.b(n2, n3 - 1, n4, n2, n3, n4);
        if (Math.random() < 0.5) {
            dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_open", 1.0f, dp2.k.nextFloat() * 0.1f + 0.9f);
        } else {
            dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_close", 1.0f, dp2.k.nextFloat() * 0.1f + 0.9f);
        }
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        if ((n6 & 8) != 0) {
            if (dp2.a(n2, n3 - 1, n4) != this.ba) {
                dp2.d(n2, n3, n4, 0);
            }
            if (n5 > 0 && Block.n[n5].d()) {
                this.b(dp2, n2, n3 - 1, n4, n5);
            }
        } else {
            boolean bl2 = false;
            if (dp2.a(n2, n3 + 1, n4) != this.ba) {
                dp2.d(n2, n3, n4, 0);
                bl2 = true;
            }
            if (!dp2.d(n2, n3 - 1, n4)) {
                dp2.d(n2, n3, n4, 0);
                bl2 = true;
                if (dp2.a(n2, n3 + 1, n4) == this.ba) {
                    dp2.d(n2, n3 + 1, n4, 0);
                }
            }
            if (bl2) {
                this.a_(dp2, n2, n3, n4, n6);
            } else if (n5 > 0 && Block.n[n5].d()) {
                boolean bl3 = dp2.o(n2, n3, n4) || dp2.o(n2, n3 + 1, n4);
                this.a(dp2, n2, n3, n4, bl3);
            }
        }
    }

    public int a(int n2, Random random) {
        if ((n2 & 8) != 0) {
            return 0;
        }
        if (this.bl == hz.e) {
            return en.az.aQ;
        }
        return en.at.aQ;
    }

    public fe a(World dp2, int n2, int n3, int n4, Vec3D as2, Vec3D as3) {
        this.a((IBlockAccess)dp2, n2, n3, n4);
        return super.a(dp2, n2, n3, n4, as2, as3);
    }

    public int d(int n2) {
        if ((n2 & 4) == 0) {
            return n2 - 1 & 3;
        }
        return n2 & 3;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        if (n3 >= 127) {
            return false;
        }
        return dp2.d(n2, n3 - 1, n4) && super.a(dp2, n2, n3, n4) && super.a(dp2, n2, n3 + 1, n4);
    }
}

