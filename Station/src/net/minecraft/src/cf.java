/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class cf
extends Block {
    protected cf(int n2, int n3) {
        super(n2, n3, hz.Packet18ArmAnimation);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        float f2 = 0.125f;
        if (n5 == 2) {
            this.a(0.0f, 0.0f, 1.0f - f2, 1.0f, 1.0f, 1.0f);
        }
        if (n5 == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f2);
        }
        if (n5 == 4) {
            this.a(1.0f - f2, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (n5 == 5) {
            this.a(0.0f, 0.0f, 0.0f, f2, 1.0f, 1.0f);
        }
        return super.d(dp2, n2, n3, n4);
    }

    public boolean b() {
        return false;
    }

    public int a() {
        return 8;
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
        if ((n6 == 0 || n5 == 2) && dp2.d(n2, n3, n4 + 1)) {
            n6 = 2;
        }
        if ((n6 == 0 || n5 == 3) && dp2.d(n2, n3, n4 - 1)) {
            n6 = 3;
        }
        if ((n6 == 0 || n5 == 4) && dp2.d(n2 + 1, n3, n4)) {
            n6 = 4;
        }
        if ((n6 == 0 || n5 == 5) && dp2.d(n2 - 1, n3, n4)) {
            n6 = 5;
        }
        dp2.b(n2, n3, n4, n6);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        int n6 = dp2.b(n2, n3, n4);
        boolean bl2 = false;
        if (n6 == 2 && dp2.d(n2, n3, n4 + 1)) {
            bl2 = true;
        }
        if (n6 == 3 && dp2.d(n2, n3, n4 - 1)) {
            bl2 = true;
        }
        if (n6 == 4 && dp2.d(n2 + 1, n3, n4)) {
            bl2 = true;
        }
        if (n6 == 5 && dp2.d(n2 - 1, n3, n4)) {
            bl2 = true;
        }
        if (!bl2) {
            this.a_(dp2, n2, n3, n4, n6);
            dp2.d(n2, n3, n4, 0);
        }
        super.b(dp2, n2, n3, n4, n5);
    }

    public int a(Random random) {
        return 1;
    }
}

