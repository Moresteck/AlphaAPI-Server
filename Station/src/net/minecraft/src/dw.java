package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.Random;

public class dw
extends Block {
    protected dw(int n2, int n3) {
        super(n2, n3, hz.Packet20NamedEntitySpawn);
    }

    public int a(int n2) {
        return this.aZ + (n2 == 1 ? 1 : 0);
    }

    public boolean a(World dp2, int n2, int n3, int n4, EntityPlayer eq2) {
        int n5 = dp2.b(n2, n3, n4);
        if (n5 > 0) {
            this.f(dp2, n2, n3, n4, n5);
            return true;
        }
        return false;
    }

    public void f(World dp2, int n2, int n3, int n4, int n5) {
        dp2.a((String)null, n2, n3, n4);
        dp2.b(n2, n3, n4, 0);
        int n6 = en.aO.aQ + n5 - 1;
        float f2 = 0.7f;
        double d2 = (double)(dp2.k.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d3 = (double)(dp2.k.nextFloat() * f2) + (double)(1.0f - f2) * 0.2 + 0.6;
        double d4 = (double)(dp2.k.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        fa fa2 = new fa(dp2, (double)n2 + d2, (double)n3 + d3, (double)n4 + d4, new gc(n6));
        fa2.ac = 10;
        dp2.a(fa2);
    }

    public void a(World dp2, int n2, int n3, int n4, int n5, float f2) {
        if (dp2.t) {
            return;
        }
        if (n5 > 0) {
            this.f(dp2, n2, n3, n4, n5);
        }
        super.a(dp2, n2, n3, n4, n5, f2);
    }
}

