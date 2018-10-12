/*
 * Decompiled with CFR 0_132.
 */
public class cc
extends en {
    private int a;

    public cc(int n2, int n3) {
        super(n2);
        this.a = n3;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        if (n5 != 1) {
            return false;
        }
        int n6 = dp2.a(n2, n3, n4);
        if (n6 == Block.aA.ba) {
            dp2.d(n2, n3 + 1, n4, this.a);
            --gc2.a;
            return true;
        }
        return false;
    }
}

