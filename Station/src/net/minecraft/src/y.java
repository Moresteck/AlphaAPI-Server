package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class y
extends Block {
    public y(int n2, int n3) {
        super(n2, n3, Material.p);
    }

    public int a(int n2) {
        if (n2 == 0) {
            return this.aZ + 2;
        }
        if (n2 == 1) {
            return this.aZ + 1;
        }
        return this.aZ;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        if (n5 > 0 && Block.n[n5].d() && dp2.o(n2, n3, n4)) {
            this.a(dp2, n2, n3, n4, 0);
            dp2.d(n2, n3, n4, 0);
        }
    }

    public int a(Random random) {
        return 0;
    }

    public void c(World dp2, int n2, int n3, int n4) {
        bs bs2 = new bs(dp2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f);
        bs2.a = dp2.k.nextInt(bs2.a / 4) + bs2.a / 8;
        dp2.a(bs2);
    }

    public void a(World dp2, int n2, int n3, int n4, int n5) {
        bs bs2 = new bs(dp2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f);
        dp2.a(bs2);
        dp2.a(bs2, "random.fuse", 1.0f, 1.0f);
    }
}

