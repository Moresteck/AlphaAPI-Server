package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class h
extends Block {
    public h(int n2, int n3) {
        super(n2, hz.e);
        this.aZ = n3;
    }

    public int a(int n2) {
        if (n2 == 1) {
            return this.aZ - 16;
        }
        if (n2 == 0) {
            return this.aZ + 16;
        }
        return this.aZ;
    }
}

