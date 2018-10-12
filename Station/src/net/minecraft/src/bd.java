/*
 * Decompiled with CFR 0_132.
 */
public class bd
extends en {
    private int a;

    public bd(int n2, int n3) {
        super(n2);
        this.aR = 1;
        this.aS = 32 << n3;
        if (n3 == 3) {
            this.aS *= 4;
        }
        this.a = 4 + n3 * 2;
    }

    public float a(gc gc2, Block et2) {
        return 1.5f;
    }

    public void a(gc gc2, int n2, int n3, int n4, int n5) {
        gc2.a(2);
    }
}

