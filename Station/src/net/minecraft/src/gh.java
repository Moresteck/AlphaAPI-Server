package net.minecraft.src;

/*
 * Decompiled with CFR 0_132.
 */
public class gh {
    public final byte[] a;

    public gh(int n2) {
        this.a = new byte[n2 >> 1];
    }

    public gh(byte[] arrby) {
        this.a = arrby;
    }

    public int a(int n2, int n3, int n4) {
        int n5 = n2 << 11 | n4 << 7 | n3;
        int n6 = n5 >> 1;
        int n7 = n5 & 1;
        if (n7 == 0) {
            return this.a[n6] & 15;
        }
        return this.a[n6] >> 4 & 15;
    }

    public void a(int n2, int n3, int n4, int n5) {
        int n6 = n2 << 11 | n4 << 7 | n3;
        int n7 = n6 >> 1;
        int n8 = n6 & 1;
        this.a[n7] = n8 == 0 ? (byte)(this.a[n7] & 240 | n5 & 15) : (byte)(this.a[n7] & 15 | (n5 & 15) << 4);
    }

    public boolean a() {
        return this.a != null;
    }
}

