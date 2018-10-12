/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class bn
extends o {
    private int b;
    private int c = 0;

    protected bn(int n2, int n3) {
        super(n2, n3, hz.h, false);
        this.b = n3;
        this.a(true);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        this.c = 0;
        this.g(dp2, n2, n3, n4);
        super.b(dp2, n2, n3, n4, n5);
    }

    public void e(World dp2, int n2, int n3, int n4, int n5) {
        if (dp2.a(n2, n3, n4) != this.ba) {
            return;
        }
        int n6 = dp2.b(n2, n3, n4);
        if (n6 == 0 || n6 != n5 - 1) {
            return;
        }
        this.g(dp2, n2, n3, n4);
    }

    public void g(World dp2, int n2, int n3, int n4) {
        if (this.c++ >= 100) {
            return;
        }
        int n5 = dp2.c(n2, n3 - 1, n4).a() ? 16 : 0;
        int n6 = dp2.b(n2, n3, n4);
        if (n6 == 0) {
            n6 = 1;
            dp2.b(n2, n3, n4, 1);
        }
        n5 = this.f(dp2, n2, n3 - 1, n4, n5);
        n5 = this.f(dp2, n2, n3, n4 - 1, n5);
        n5 = this.f(dp2, n2, n3, n4 + 1, n5);
        n5 = this.f(dp2, n2 - 1, n3, n4, n5);
        int n7 = (n5 = this.f(dp2, n2 + 1, n3, n4, n5)) - 1;
        if (n7 < 10) {
            n7 = 1;
        }
        if (n7 != n6) {
            dp2.b(n2, n3, n4, n7);
            this.e(dp2, n2, n3 - 1, n4, n6);
            this.e(dp2, n2, n3 + 1, n4, n6);
            this.e(dp2, n2, n3, n4 - 1, n6);
            this.e(dp2, n2, n3, n4 + 1, n6);
            this.e(dp2, n2 - 1, n3, n4, n6);
            this.e(dp2, n2 + 1, n3, n4, n6);
        }
    }

    private int f(World dp2, int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = dp2.a(n2, n3, n4);
        if (n7 == Block.J.ba) {
            return 16;
        }
        if (n7 == this.ba && (n6 = dp2.b(n2, n3, n4)) != 0 && n6 > n5) {
            return n6;
        }
        return n5;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        int n5 = dp2.b(n2, n3, n4);
        if (n5 == 0) {
            this.c = 0;
            this.g(dp2, n2, n3, n4);
        } else if (n5 == 1) {
            this.h(dp2, n2, n3, n4);
        } else if (random.nextInt(10) == 0) {
            this.g(dp2, n2, n3, n4);
        }
    }

    private void h(World dp2, int n2, int n3, int n4) {
        this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
        dp2.d(n2, n3, n4, 0);
    }

    public int a(Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    public int a(int n2, Random random) {
        return Block.y.ba;
    }

    public boolean b() {
        return !this.a;
    }

    public void b(World dp2, int n2, int n3, int n4, Entity db2) {
        super.b(dp2, n2, n3, n4, db2);
    }
}

