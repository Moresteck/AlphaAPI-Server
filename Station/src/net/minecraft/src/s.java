package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class s
extends Block {
    protected s(int n2, int n3) {
        super(n2, n3, hz.t);
        this.a(true);
    }

    public int a(int n2, Random random) {
        return en.aB.aQ;
    }

    public int a(Random random) {
        return 4;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (dp2.a(cr.b, n2, n3, n4) > 11) {
            this.a_(dp2, n2, n3, n4, dp2.b(n2, n3, n4));
            dp2.d(n2, n3, n4, 0);
        }
    }
}

