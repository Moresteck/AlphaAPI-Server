package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class fm
extends Block {
    protected fm(int n2) {
        super(n2, hz.b);
        this.aZ = 87;
        this.a(true);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.c(255);
    }

    public AxisAlignedBB d(World dp2, int n2, int n3, int n4) {
        return AxisAlignedBB.b(n2 + 0, n3 + 0, n4 + 0, n2 + 1, n3 + 1, n4 + 1);
    }

    public boolean b() {
        return false;
    }

    public void a(World dp2, int n2, int n3, int n4, Random random) {
        if (random.nextInt(5) == 0) {
            if (this.h(dp2, n2, n3, n4)) {
                dp2.b(n2, n3, n4, 7);
            } else {
                int n5 = dp2.b(n2, n3, n4);
                if (n5 > 0) {
                    dp2.b(n2, n3, n4, n5 - 1);
                } else if (!this.g(dp2, n2, n3, n4)) {
                    dp2.d(n2, n3, n4, Block.v.ba);
                }
            }
        }
    }

    public void b(World dp2, int n2, int n3, int n4, Entity db2) {
        if (dp2.k.nextInt(4) == 0) {
            dp2.d(n2, n3, n4, Block.v.ba);
        }
    }

    private boolean g(World dp2, int n2, int n3, int n4) {
        int n5 = 0;
        for (int i2 = n2 - n5; i2 <= n2 + n5; ++i2) {
            for (int i3 = n4 - n5; i3 <= n4 + n5; ++i3) {
                if (dp2.a(i2, n3 + 1, i3) != Block.az.ba) continue;
                return true;
            }
        }
        return false;
    }

    private boolean h(World dp2, int n2, int n3, int n4) {
        for (int i2 = n2 - 4; i2 <= n2 + 4; ++i2) {
            for (int i3 = n3; i3 <= n3 + 1; ++i3) {
                for (int i4 = n4 - 4; i4 <= n4 + 4; ++i4) {
                    if (dp2.c(i2, i3, i4) != hz.f) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public void b(World dp2, int n2, int n3, int n4, int n5) {
        super.b(dp2, n2, n3, n4, n5);
        hz hz2 = dp2.c(n2, n3 + 1, n4);
        if (hz2.a()) {
            dp2.d(n2, n3, n4, Block.v.ba);
        }
    }

    public int a(int n2, Random random) {
        return Block.v.a(0, random);
    }
}

