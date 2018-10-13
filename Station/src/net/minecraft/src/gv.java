package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class gv
extends Block {
    protected gv(int n2) {
        super(n2, hz.Packet21PickupSpawn);
        this.aZ = 48;
    }

    public void e(World dp2, int n2, int n3, int n4) {
        int n5 = 2;
        for (int i2 = n2 - n5; i2 <= n2 + n5; ++i2) {
            for (int i3 = n3 - n5; i3 <= n3 + n5; ++i3) {
                for (int i4 = n4 - n5; i4 <= n4 + n5; ++i4) {
                    if (dp2.c(i2, i3, i4) != hz.f) continue;
                }
            }
        }
    }

    public void b(World dp2, int n2, int n3, int n4) {
        int n5 = 2;
        for (int i2 = n2 - n5; i2 <= n2 + n5; ++i2) {
            for (int i3 = n3 - n5; i3 <= n3 + n5; ++i3) {
                for (int i4 = n4 - n5; i4 <= n4 + n5; ++i4) {
                    dp2.g(i2, i3, i4, dp2.a(i2, i3, i4));
                }
            }
        }
    }
}

