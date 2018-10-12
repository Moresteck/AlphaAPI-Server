/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class aj
extends Block {
    protected aj(int n2, int n3) {
        super(n2, n3, hz.u);
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

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        float f2 = 0.0625f;
        return AxisAlignedBB.b((float)n2 + f2, n3, (float)n4 + f2, (float)(n2 + 1) - f2, (float)(n3 + 1) - f2, (float)(n4 + 1) - f2);
    }

    public int a(int n2) {
        if (n2 == 1) {
            return this.aZ - 1;
        }
        if (n2 == 0) {
            return this.aZ + 1;
        }
        return this.aZ;
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 13;
    }

    public boolean a(World dp2, int n2, int n3, int n4) {
        if (!super.a(dp2, n2, n3, n4)) {
            return false;
        }
        return this.f(dp2, n2, n3, n4);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (!this.f(dp2, n2, n3, n4)) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
    }

    public boolean f(World dp2, int n2, int n3, int n4) {
        if (dp2.c(n2 - 1, n3, n4).a()) {
            return false;
        }
        if (dp2.c(n2 + 1, n3, n4).a()) {
            return false;
        }
        if (dp2.c(n2, n3, n4 - 1).a()) {
            return false;
        }
        if (dp2.c(n2, n3, n4 + 1).a()) {
            return false;
        }
        int n5 = dp2.a(n2, n3 - 1, n4);
        return n5 == Block.aV.ba || n5 == Block.E.ba;
    }

    public void a(World dp2, int n2, int n3, int n4, Entity db2) {
        db2.a(null, 1);
    }
}

