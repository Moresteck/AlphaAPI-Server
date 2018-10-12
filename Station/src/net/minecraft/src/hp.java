/*
 * Decompiled with CFR 0_132.
 */
public class hp
extends TileEntity {
    public String[] e = new String[]{"", "", "", ""};
    public int f = -1;

    public void b(r r2) {
        super.b(r2);
        r2.a("Text1", this.e[0]);
        r2.a("Text2", this.e[1]);
        r2.a("Text3", this.e[2]);
        r2.a("Text4", this.e[3]);
    }

    public void a(r r2) {
        super.a(r2);
        for (int i2 = 0; i2 < 4; ++i2) {
            this.e[i2] = r2.h("Text" + (i2 + 1));
            if (this.e[i2].length() <= 15) continue;
            this.e[i2] = this.e[i2].substring(0, 15);
        }
    }
}

