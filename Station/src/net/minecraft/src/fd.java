package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class fd
extends en {
    public fd(int n2) {
        super(n2);
        this.aS = 64;
        this.aR = 1;
    }

    public boolean a(gc gc2, EntityPlayer eq2, World dp2, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            return false;
        }
        if (!dp2.c(n2, n3, n4).a()) {
            return false;
        }
        if (n5 == 1) {
            ++n3;
        }
        if (n5 == 2) {
            --n4;
        }
        if (n5 == 3) {
            ++n4;
        }
        if (n5 == 4) {
            --n2;
        }
        if (n5 == 5) {
            ++n2;
        }
        if (!Block.aD.a(dp2, n2, n3, n4)) {
            return false;
        }
        if (n5 == 1) {
            dp2.b(n2, n3, n4, Block.aD.ba, MathHelper.b((double)((eq2.q + 180.0f) * 16.0f / 360.0f) + 0.5) & 15);
        } else {
            dp2.b(n2, n3, n4, Block.aI.ba, n5);
        }
        --gc2.a;
        eq2.a((hp)dp2.k(n2, n3, n4));
        return true;
    }
}

