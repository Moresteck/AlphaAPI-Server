/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hc
extends ay {
    private int a;

    public hc(int n2) {
        this.a = n2;
    }

    public boolean a(World dp2, Random random, int n2, int n3, int n4) {
        if (dp2.a(n2, n3 + 1, n4) != Block.t.ba) {
            return false;
        }
        if (dp2.a(n2, n3 - 1, n4) != Block.t.ba) {
            return false;
        }
        if (dp2.a(n2, n3, n4) != 0 && dp2.a(n2, n3, n4) != Block.t.ba) {
            return false;
        }
        int n5 = 0;
        if (dp2.a(n2 - 1, n3, n4) == Block.t.ba) {
            ++n5;
        }
        if (dp2.a(n2 + 1, n3, n4) == Block.t.ba) {
            ++n5;
        }
        if (dp2.a(n2, n3, n4 - 1) == Block.t.ba) {
            ++n5;
        }
        if (dp2.a(n2, n3, n4 + 1) == Block.t.ba) {
            ++n5;
        }
        int n6 = 0;
        if (dp2.a(n2 - 1, n3, n4) == 0) {
            ++n6;
        }
        if (dp2.a(n2 + 1, n3, n4) == 0) {
            ++n6;
        }
        if (dp2.a(n2, n3, n4 - 1) == 0) {
            ++n6;
        }
        if (dp2.a(n2, n3, n4 + 1) == 0) {
            ++n6;
        }
        if (n5 == 3 && n6 == 1) {
            dp2.d(n2, n3, n4, this.a);
        }
        return true;
    }
}

