package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

public class de
extends ft {
    private List a = new ArrayList();
    private byte b;

    void a(DataOutput dataOutput) {
        this.b = this.a.size() > 0 ? ((ft)this.a.get(0)).a() : (byte)1;
        dataOutput.writeByte(this.b);
        dataOutput.writeInt(this.a.size());
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            ((ft)this.a.get(i2)).a(dataOutput);
        }
    }

    void a(DataInput dataInput) {
        this.b = dataInput.readByte();
        int n2 = dataInput.readInt();
        this.a = new ArrayList();
        for (int i2 = 0; i2 < n2; ++i2) {
            ft ft2 = ft.a(this.b);
            ft2.a(dataInput);
            this.a.add(ft2);
        }
    }

    public byte a() {
        return 9;
    }

    public String toString() {
        return "" + this.a.size() + " entries of type " + ft.b(this.b);
    }

    public void a(ft ft2) {
        this.b = ft2.a();
        this.a.add(ft2);
    }

    public ft a(int n2) {
        return (ft)this.a.get(n2);
    }

    public int b() {
        return this.a.size();
    }
}

