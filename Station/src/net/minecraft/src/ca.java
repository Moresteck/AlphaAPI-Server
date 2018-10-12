/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class ca
extends Block {
    protected ca(int n2, int n3) {
        super(n2, hz.i);
        this.aZ = n3;
        float f2 = 0.375f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 1.0f, 0.5f + f2);
        this.a(true);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (dp2.a(n2, n3 + 1, n4) == 0) {
            int n5 = 1;
            while (dp2.a(n2, n3 - n5, n4) == this.ba) {
                ++n5;
            }
            if (n5 < 3) {
                int n6 = dp2.b(n2, n3, n4);
                if (n6 == 15) {
                    dp2.d(n2, n3 + 1, n4, this.ba);
                    dp2.b(n2, n3, n4, 0);
                } else {
                    dp2.b(n2, n3, n4, n6 + 1);
                }
            }
        }
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.a(n2, n3 - 1, n4);
        if (n5 == this.ba) {
            return true;
        }
        if (n5 != Block.u.ba && n5 != Block.v.ba) {
            return false;
        }
        if (dp2.c(n2 - 1, n3 - 1, n4) == hz.f) {
            return true;
        }
        if (dp2.c(n2 + 1, n3 - 1, n4) == hz.f) {
            return true;
        }
        if (dp2.c(n2, n3 - 1, n4 - 1) == hz.f) {
            return true;
        }
        if (dp2.c(n2, n3 - 1, n4 + 1) == hz.f) {
            return true;
        }
        return false;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        this.g(dp2, n2, n3, n4);
    }

    protected final void g(World dp2, int n2, int n3, int n4) {
        if (!this.f(dp2, n2, n3, n4)) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
    }

    public boolean f(World dp2, int n2, int n3, int n4) {
        return this.a(dp2, n2, n3, n4);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return null;
    }

    public int a(int n2, Random random) {
        return en.aH.aQ;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 1;
    }
}

