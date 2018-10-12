/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class b
extends cl {
    private Random a = new Random();

    protected b(int n2) {
        super(n2, hz.c);
        this.aZ = 26;
    }

    public int a(int n2) {
        if (n2 == 1) {
            return this.aZ - 1;
        }
        if (n2 == 0) {
            return this.aZ - 1;
        }
        if (n2 == 3) {
            return this.aZ + 1;
        }
        return this.aZ;
    }

    public boolean a(dp dp2, int n2, int n3, int n4) {
        int n5 = 0;
        if (dp2.a(n2 - 1, n3, n4) == this.ba) {
            ++n5;
        }
        if (dp2.a(n2 + 1, n3, n4) == this.ba) {
            ++n5;
        }
        if (dp2.a(n2, n3, n4 - 1) == this.ba) {
            ++n5;
        }
        if (dp2.a(n2, n3, n4 + 1) == this.ba) {
            ++n5;
        }
        if (n5 > 1) {
            return false;
        }
        if (this.g(dp2, n2 - 1, n3, n4)) {
            return false;
        }
        if (this.g(dp2, n2 + 1, n3, n4)) {
            return false;
        }
        if (this.g(dp2, n2, n3, n4 - 1)) {
            return false;
        }
        if (this.g(dp2, n2, n3, n4 + 1)) {
            return false;
        }
        return true;
    }

    private boolean g(dp dp2, int n2, int n3, int n4) {
        if (dp2.a(n2, n3, n4) != this.ba) {
            return false;
        }
        if (dp2.a(n2 - 1, n3, n4) == this.ba) {
            return true;
        }
        if (dp2.a(n2 + 1, n3, n4) == this.ba) {
            return true;
        }
        if (dp2.a(n2, n3, n4 - 1) == this.ba) {
            return true;
        }
        if (dp2.a(n2, n3, n4 + 1) == this.ba) {
            return true;
        }
        return false;
    }

    public void b(dp dp2, int n2, int n3, int n4) {
        gn gn2 = (gn)dp2.k(n2, n3, n4);
        for (int i2 = 0; i2 < gn2.a(); ++i2) {
            gc gc2 = gn2.a(i2);
            if (gc2 == null) continue;
            float f2 = this.a.nextFloat() * 0.8f + 0.1f;
            float f3 = this.a.nextFloat() * 0.8f + 0.1f;
            float f4 = this.a.nextFloat() * 0.8f + 0.1f;
            while (gc2.a > 0) {
                int n5 = this.a.nextInt(21) + 10;
                if (n5 > gc2.a) {
                    n5 = gc2.a;
                }
                gc2.a -= n5;
                fa fa2 = new fa(dp2, (float)n2 + f2, (float)n3 + f3, (float)n4 + f4, new gc(gc2.c, n5, gc2.d));
                float f5 = 0.05f;
                fa2.n = (float)this.a.nextGaussian() * f5;
                fa2.o = (float)this.a.nextGaussian() * f5 + 0.2f;
                fa2.p = (float)this.a.nextGaussian() * f5;
                dp2.a(fa2);
            }
        }
        super.b(dp2, n2, n3, n4);
    }

    public boolean a(dp dp2, int n2, int n3, int n4, eq eq2) {
        if if_ = (gn)dp2.k(n2, n3, n4);
        if (dp2.d(n2, n3 + 1, n4)) {
            return true;
        }
        if (dp2.a(n2 - 1, n3, n4) == this.ba && dp2.d(n2 - 1, n3 + 1, n4)) {
            return true;
        }
        if (dp2.a(n2 + 1, n3, n4) == this.ba && dp2.d(n2 + 1, n3 + 1, n4)) {
            return true;
        }
        if (dp2.a(n2, n3, n4 - 1) == this.ba && dp2.d(n2, n3 + 1, n4 - 1)) {
            return true;
        }
        if (dp2.a(n2, n3, n4 + 1) == this.ba && dp2.d(n2, n3 + 1, n4 + 1)) {
            return true;
        }
        if (dp2.a(n2 - 1, n3, n4) == this.ba) {
            if_ = new ae("Large chest", (gn)dp2.k(n2 - 1, n3, n4), if_);
        }
        if (dp2.a(n2 + 1, n3, n4) == this.ba) {
            if_ = new ae("Large chest", if_, (gn)dp2.k(n2 + 1, n3, n4));
        }
        if (dp2.a(n2, n3, n4 - 1) == this.ba) {
            if_ = new ae("Large chest", (gn)dp2.k(n2, n3, n4 - 1), if_);
        }
        if (dp2.a(n2, n3, n4 + 1) == this.ba) {
            if_ = new ae("Large chest", if_, (gn)dp2.k(n2, n3, n4 + 1));
        }
        eq2.a(if_);
        return true;
    }

    protected ap a_() {
        return new gn();
    }
}

