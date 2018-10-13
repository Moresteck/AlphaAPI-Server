package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class em
extends Block {
    public static boolean a = false;

    public em(int n2, int n3) {
        super(n2, n3, hz.m);
    }

    public void e(World dp2, int n2, int n3, int n4) {
        dp2.h(n2, n3, n4, this.ba);
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        dp2.h(n2, n3, n4, this.ba);
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        this.h(dp2, n2, n3, n4);
    }

    private void h(World dp2, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = n3;
        int n7 = n4;
        if (em.g(dp2, n5, n6 - 1, n7) && n6 >= 0) {
            go go2 = new go(dp2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, this.ba);
            if (a) {
                while (!go2.A) {
                    go2.b_();
                }
            } else {
                dp2.a(go2);
            }
        }
    }

    public int c() {
        return 3;
    }

    public static boolean g(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.a(n2, n3, n4);
        if (n5 == 0) {
            return true;
        }
        if (n5 == Block.ar.ba) {
            return true;
        }
        hz hz2 = Block.n[n5].bl;
        if (hz2 == hz.f) {
            return true;
        }
        if (hz2 == hz.PlayerListBox) {
            return true;
        }
        return false;
    }
}

