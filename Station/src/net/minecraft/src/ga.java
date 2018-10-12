/*
 * Decompiled with CFR 0_132.
 */
public class ga
extends en {
    private static final int[] aY = new int[]{3, 8, 6, 3};
    private static final int[] aZ = new int[]{11, 16, 15, 13};
    public final int a;
    public final int aV;
    public final int aW;
    public final int aX;

    public ga(int n2, int n3, int n4, int n5) {
        super(n2);
        this.a = n3;
        this.aV = n5;
        this.aX = n4;
        this.aW = aY[n5];
        this.aS = aZ[n5] * 3 << n3;
        this.aR = 1;
    }
}

