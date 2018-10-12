/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class hj
extends en {
    public hj(int n2) {
        super(n2);
        this.aR = 1;
        this.aS = 64;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        int n6;
        if (n5 == 0) {
            --n3;
        }
        if (n5 == 1) {
            ++n3;
        }
        if (n5 == 2) {
            --n4;
        }
        if (n5 == 3) {
            ++n4;
        }
        if (n5 == 4) {
            --n2;
        }
        if (n5 == 5) {
            ++n2;
        }
        if ((n6 = dp2.a(n2, n3, n4)) == 0) {
            dp2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "fire.ignite", 1.0f, b.nextFloat() * 0.4f + 0.8f);
            dp2.d(n2, n3, n4, Block.ar.ba);
        }
        gc2.a(1);
        return true;
    }
}

