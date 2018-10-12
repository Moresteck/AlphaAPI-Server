/*
 * Decompiled with CFR 0_132.
 */
public class dx
extends gb {
    protected dx(int n2, int n3) {
        super(n2, n3);
        float f2 = 0.2f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 2.0f, 0.5f + f2);
    }

    protected boolean b(int n2) {
        return Block.p[n2];
    }

    public boolean f(World dp2, int n2, int n3, int n4) {
        return dp2.h(n2, n3, n4) <= 13 && this.b(dp2.a(n2, n3 - 1, n4));
    }
}

