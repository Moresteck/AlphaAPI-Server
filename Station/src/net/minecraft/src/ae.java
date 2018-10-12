/*
 * Decompiled with CFR 0_132.
 */
public class ae
implements if {
    private String a;
    private if b;
    private if c;

    public ae(String string, if if_, if if_2) {
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

