/*
 * Decompiled with CFR 0_132.
 */
public class ie
extends en {
    private int a;

    public ie(int n2, Block et2) {
        super(n2);
        this.a = et2.ba;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        if (dp2.a(n2, n3, n4) == Block.aS.ba) {
            n5 = 0;
        } else {
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
        }
        if (gc2.a == 0) {
            return false;
        }
        if (dp2.a(this.a, n2, n3, n4, false)) {
            Block et2 = Block.n[this.a];
            if (dp2.d(n2, n3, n4, this.a)) {
                Block.n[this.a].c(dp2, n2, n3, n4, n5);
                dp2.a((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, et2.bj.c(), (et2.bj.a() + 1.0f) / 2.0f, et2.bj.b() * 0.8f);
                --gc2.a;
            }
        }
        return true;
    }
}

