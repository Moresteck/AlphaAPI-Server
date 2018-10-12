/*
 * Decompiled with CFR 0_132.
 */
public enum fx {
    a("Kebab", 16, 16, 0, 0),
    b("Aztec", 16, 16, 16, 0),
    c("Alban", 16, 16, 32, 0),
    d("Aztec2", 16, 16, 48, 0),
    e("Bomb", 16, 16, 64, 0),
    f("Plant", 16, 16, 80, 0),
    g("Wasteland", 16, 16, 96, 0),
    h("Pool", 32, 16, 0, 32),
    i("Courbet", 32, 16, 32, 32),
    j("Sea", 32, 16, 64, 32),
    k("Sunset", 32, 16, 96, 32),
    l("Wanderer", 16, 32, 0, 64),
    m("Match", 32, 32, 0, 128),
    n("Bust", 32, 32, 32, 128),
    o("Stage", 32, 32, 64, 128),
    p("Void", 32, 32, 96, 128),
    q("SkullAndRoses", 32, 32, 128, 128),
    r("Fighters", 64, 32, 0, 96),
    s("Pointer", 64, 64, 0, 192);
    
    public final String t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;

    private fx(String string2, int n3, int n4, int n5, int n6) {
        this.t = string2;
        this.u = n3;
        this.v = n4;
        this.w = n5;
        this.x = n6;
    }
}

