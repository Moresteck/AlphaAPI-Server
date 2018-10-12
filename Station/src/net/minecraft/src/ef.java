/*
 * Decompiled with CFR 0_132.
 */
public class ef
extends en {
    private String a;

    protected ef(int n2, String string) {
        super(n2);
        this.a = string;
        this.aR = 1;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        if (dp2.a(n2, n3, n4) == Block.aY.ba && dp2.b(n2, n3, n4) == 0) {
            dp2.b(n2, n3, n4, this.aQ - en.aO.aQ + 1);
            dp2.a(this.a, n2, n3, n4);
            --gc2.a;
            return true;
        }
        return false;
    }
}

