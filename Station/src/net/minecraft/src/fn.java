package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class fn
extends en {
    private hz a;

    public fn(int n2, hz hz2) {
        super(n2);
        this.a = hz2;
        this.aS = 64;
        this.aR = 1;
    }

    public boolean a(gc gc2, eq eq2, World dp2, int n2, int n3, int n4, int n5) {
        if (n5 != 1) {
            return false;
        }
        Block et2 = this.a == hz.Packet20NamedEntitySpawn ? Block.aE : Block.aL;
        if (!et2.a(dp2, n2, ++n3, n4)) {
            return false;
        }
        int n6 = fw.b((double)((eq2.q + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
        int n7 = 0;
        int n8 = 0;
        if (n6 == 0) {
            n8 = 1;
        }
        if (n6 == 1) {
            n7 = -1;
        }
        if (n6 == 2) {
            n8 = -1;
        }
        if (n6 == 3) {
            n7 = 1;
        }
        int n9 = (dp2.d(n2 - n7, n3, n4 - n8) ? 1 : 0) + (dp2.d(n2 - n7, n3 + 1, n4 - n8) ? 1 : 0);
        int n10 = (dp2.d(n2 + n7, n3, n4 + n8) ? 1 : 0) + (dp2.d(n2 + n7, n3 + 1, n4 + n8) ? 1 : 0);
        boolean bl2 = dp2.a(n2 - n7, n3, n4 - n8) == et2.ba || dp2.a(n2 - n7, n3 + 1, n4 - n8) == et2.ba;
        boolean bl3 = dp2.a(n2 + n7, n3, n4 + n8) == et2.ba || dp2.a(n2 + n7, n3 + 1, n4 + n8) == et2.ba;
        boolean bl4 = false;
        if (bl2 && !bl3) {
            bl4 = true;
        } else if (n10 > n9) {
            bl4 = true;
        }
        if (bl4) {
            n6 = n6 - 1 & 3;
            n6 += 4;
        }
        dp2.d(n2, n3, n4, et2.ba);
        dp2.b(n2, n3, n4, n6);
        dp2.d(n2, n3 + 1, n4, et2.ba);
        dp2.b(n2, n3 + 1, n4, n6 + 8);
        --gc2.a;
        return true;
    }
}

