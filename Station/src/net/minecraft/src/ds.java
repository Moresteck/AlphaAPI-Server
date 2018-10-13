package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class ds
extends Block {
    protected ds(int n2) {
        super(n2, Material.c);
        this.aZ = 59;
    }

    public int a(int n2) {
        if (n2 == 1) {
            return this.aZ - 16;
        }
        if (n2 == 0) {
            return Block.x.a(0);
        }
        if (n2 == 2 || n2 == 4) {
            return this.aZ + 1;
        }
        return this.aZ;
    }

    public boolean a(World dp2, int n2, int n3, int n4, EntityPlayer eq2) {
        eq2.z();
        return true;
    }
}

