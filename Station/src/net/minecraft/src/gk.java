package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class gk
extends Block {
    private boolean a;

    protected gk(int n2, int n3, Material hz2, boolean bl2) {
        super(n2, n3, hz2);
        this.a = bl2;
    }

    public boolean b() {
        return false;
    }

    public boolean a(IBlockAccess hb2, int n2, int n3, int n4, int n5) {
        int n6 = hb2.a(n2, n3, n4);
        if (!this.a && n6 == this.ba) {
            return false;
        }
        return super.a(hb2, n2, n3, n4, n5);
    }
}

