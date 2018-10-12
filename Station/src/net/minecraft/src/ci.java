/*
 * Decompiled with CFR 0_132.
 */
public class ci
extends en {
    private Block[] aV;
    private float aW = 4.0f;
    private int aX;
    protected int a;

    public ci(int n2, int n3, int n4, Block[] arret) {
        super(n2);
        this.a = n4;
        this.aV = arret;
        this.aR = 1;
        this.aS = 32 << n4;
        if (n4 == 3) {
            this.aS *= 4;
        }
        this.aW = (n4 + 1) * 2;
        this.aX = n3 + n4;
    }

    public float a(gc gc2, Block et2) {
        for (int i2 = 0; i2 < this.aV.length; ++i2) {
            if (this.aV[i2] != et2) continue;
            return this.aW;
        }
        return 1.0f;
    }

    public void a(gc gc2, int n2, int n3, int n4, int n5) {
        gc2.a(1);
    }
}

