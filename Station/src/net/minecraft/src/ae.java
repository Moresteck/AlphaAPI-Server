package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class ae
implements IInventory {
    private String a;
    private IInventory b;
    private IInventory c;

    public ae(String string, IInventory if_, IInventory if_2) {
        this.a = string;
        this.b = if_;
        this.c = if_2;
    }

    public int a() {
        return this.b.a() + this.c.a();
    }

    public gc a(int n2) {
        if (n2 >= this.b.a()) {
            return this.c.a(n2 - this.b.a());
        }
        return this.b.a(n2);
    }
}

