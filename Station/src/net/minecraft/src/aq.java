/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class aq
extends Block {
    private boolean a;

    public aq(int n2, int n3, boolean bl2) {
        super(n2, n3, hz.d);
        if (bl2) {
            this.a(true);
        }
        this.a = bl2;
    }

    public int c() {
        return 30;
    }

    public void b(World dp2, int n2, int n3, int n4, eq eq2) {
        this.g(dp2, n2, n3, n4);
        super.b(dp2, n2, n3, n4, eq2);
    }

    public void b(World dp2, int n2, int n3, int n4, Entity db2) {
        this.g(dp2, n2, n3, n4);
        super.b(dp2, n2, n3, n4, db2);
    }

    public boolean a(World dp2, int n2, int n3, int n4, eq eq2) {
        this.g(dp2, n2, n3, n4);
        return super.a(dp2, n2, n3, n4, eq2);
    }

    private void g(World dp2, int n2, int n3, int n4) {
        this.h(dp2, n2, n3, n4);
        if (this.ba == Block.aN.ba) {
            dp2.d(n2, n3, n4, Block.aO.ba);
        }
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (this.ba == Block.aO.ba) {
            dp2.d(n2, n3, n4, Block.aN.ba);
        }
    }

    public int a(int n2, Random random) {
        return en.aA.aQ;
    }

    public int a(Random random) {
        return 4 + random.nextInt(2);
    }

    private void h(World dp2, int n2, int n3, int n4) {
        Random random = dp2.k;
        double d2 = 0.0625;
        for (int i2 = 0; i2 < 6; ++i2) {
            double d3 = (float)n2 + random.nextFloat();
            double d4 = (float)n3 + random.nextFloat();
            double d5 = (float)n4 + random.nextFloat();
            if (i2 == 0 && !dp2.d(n2, n3 + 1, n4)) {
                d4 = (double)(n3 + 1) + d2;
            }
            if (i2 == 1 && !dp2.d(n2, n3 - 1, n4)) {
                d4 = (double)(n3 + 0) - d2;
            }
            if (i2 == 2 && !dp2.d(n2, n3, n4 + 1)) {
                d5 = (double)(n4 + 1) + d2;
            }
            if (i2 == 3 && !dp2.d(n2, n3, n4 - 1)) {
                d5 = (double)(n4 + 0) - d2;
            }
            if (i2 == 4 && !dp2.d(n2 + 1, n3, n4)) {
                d3 = (double)(n2 + 1) + d2;
            }
            if (i2 == 5 && !dp2.d(n2 - 1, n3, n4)) {
                d3 = (double)(n2 + 0) - d2;
            }
            if (d3 >= (double)n2 && d3 <= (double)(n2 + 1) && d4 >= 0.0 && d4 <= (double)(n3 + 1) && d5 >= (double)n4 && d5 <= (double)(n4 + 1)) continue;
            dp2.a("reddust", d3, d4, d5, 0.0, 0.0, 0.0);
        }
    }
}

