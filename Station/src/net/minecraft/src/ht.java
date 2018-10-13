package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class ht
extends en {
    public ht(int n2) {
        super(n2);
        this.aS = 64;
    }

    public boolean a(gc gc2, EntityPlayer eq2, World dp2, int n2, int n3, int n4, int n5) {
        EntityPainting bp2;
        if (n5 == 0) {
            return false;
        }
        if (n5 == 1) {
            return false;
        }
        int n6 = 0;
        if (n5 == 4) {
            n6 = 1;
        }
        if (n5 == 3) {
            n6 = 2;
        }
        if (n5 == 5) {
            n6 = 3;
        }
        if ((bp2 = new EntityPainting(dp2, n2, n3, n4, n6)).b()) {
            dp2.a(bp2);
            --gc2.a;
        }
        return true;
    }
}

