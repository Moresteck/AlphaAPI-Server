package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class r
extends ft {
    private Map a = new HashMap();

    void a(DataOutput dataOutput) {
        for (ft ft2 : this.a.values()) {
            ft.a(ft2, dataOutput);
        }
        dataOutput.writeByte(0);
    }

    void a(DataInput dataInput) {
        ft ft2;
        this.a.clear();
        while ((ft2 = ft.b(dataInput)).a() != 0) {
            this.a.put(ft2.c(), ft2);
        }
    }

    public byte a() {
        return 10;
    }

    public void a(String string, ft ft2) {
        this.a.put(string, ft2.m(string));
    }

    public void a(String string, byte by2) {
        this.a.put(string, new bj(by2).m(string));
    }

    public void a(String string, short s2) {
        this.a.put(string, new ep(s2).m(string));
    }

    public void a(String string, int n2) {
        this.a.put(string, new bb(n2).m(string));
    }

    public void a(String string, long l2) {
        this.a.put(string, new d(l2).m(string));
    }

    public void a(String string, float f2) {
        this.a.put(string, new k(f2).m(string));
    }

    public void a(String string, double d2) {
        this.a.put(string, new dk(d2).m(string));
    }

    public void a(String string, String string2) {
        this.a.put(string, new gu(string2).m(string));
    }

    public void a(String string, byte[] arrby) {
        this.a.put(string, new fc(arrby).m(string));
    }

    public void a(String string, r r2) {
        this.a.put(string, r2.m(string));
    }

    public void a(String string, boolean bl2) {
        this.a(string, bl2 ? (byte)1 : 0);
    }

    public boolean a(String string) {
        return this.a.containsKey(string);
    }

    public byte b(String string) {
        if (!this.a.containsKey(string)) {
            return 0;
        }
        return ((bj)this.a.get((Object)string)).a;
    }

    public short c(String string) {
        if (!this.a.containsKey(string)) {
            return 0;
        }
        return ((ep)this.a.get((Object)string)).a;
    }

    public int d(String string) {
        if (!this.a.containsKey(string)) {
            return 0;
        }
        return ((bb)this.a.get((Object)string)).a;
    }

    public long e(String string) {
        if (!this.a.containsKey(string)) {
            return 0L;
        }
        return ((d)this.a.get((Object)string)).a;
    }

    public float f(String string) {
        if (!this.a.containsKey(string)) {
            return 0.0f;
        }
        return ((k)this.a.get((Object)string)).a;
    }

    public double g(String string) {
        if (!this.a.containsKey(string)) {
            return 0.0;
        }
        return ((dk)this.a.get((Object)string)).a;
    }

    public String h(String string) {
        if (!this.a.containsKey(string)) {
            return "";
        }
        return ((gu)this.a.get((Object)string)).a;
    }

    public byte[] i(String string) {
        if (!this.a.containsKey(string)) {
            return new byte[0];
        }
        return ((fc)this.a.get((Object)string)).a;
    }

    public r j(String string) {
        if (!this.a.containsKey(string)) {
            return new r();
        }
        return (r)this.a.get(string);
    }

    public de k(String string) {
        if (!this.a.containsKey(string)) {
            return new de();
        }
        return (de)this.a.get(string);
    }

    public boolean l(String string) {
        return this.b(string) != 0;
    }

    public String toString() {
        return "" + this.a.size() + " entries";
    }
}

