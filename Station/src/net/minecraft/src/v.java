package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class v
extends cg {
    protected v(int n2, Material hz2) {
        super(n2, hz2);
        this.a(false);
        if (hz2 == Material.g) {
            this.a(true);
        }
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        super.b(dp2, n2, n3, n4, n5);
        if (dp2.a(n2, n3, n4) == this.ba) {
            this.i(dp2, n2, n3, n4);
        }
    }

    private void i(World dp2, int n2, int n3, int n4) {
        int n5 = dp2.b(n2, n3, n4);
        dp2.g = true;
        dp2.a(n2, n3, n4, this.ba - 1, n5);
        dp2.b(n2, n3, n4, n2, n3, n4);
        dp2.h(n2, n3, n4, this.ba - 1);
        dp2.g = false;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (this.bl == Material.g) {
            int n5 = random.nextInt(3);
            for (int i2 = 0; i2 < n5; ++i2) {
                int n6 = dp2.a(n2 += random.nextInt(3) - 1, ++n3, n4 += random.nextInt(3) - 1);
                if (n6 == 0) {
                    if (!this.j(dp2, n2 - 1, n3, n4) && !this.j(dp2, n2 + 1, n3, n4) && !this.j(dp2, n2, n3, n4 - 1) && !this.j(dp2, n2, n3, n4 + 1) && !this.j(dp2, n2, n3 - 1, n4) && !this.j(dp2, n2, n3 + 1, n4)) continue;
                    dp2.d(n2, n3, n4, Block.ar.ba);
                    return;
                }
                if (!Block.n[n6].bl.c()) continue;
                return;
            }
        }
    }

    private boolean j(World dp2, int n2, int n3, int n4) {
        return dp2.c(n2, n3, n4).e();
    }
}

