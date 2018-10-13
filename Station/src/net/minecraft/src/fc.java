package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fc
extends ft {
    public byte[] a;

    public fc() {
    }

    public fc(byte[] arrby) {
        this.a = arrby;
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.a.length);
        dataOutput.write(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        int n2 = dataInput.readInt();
        this.a = new byte[n2];
        dataInput.readFully(this.a);
    }

    public byte a() {
        return 7;
    }

    public String toString() {
        return "[" + this.a.length + " bytes]";
    }
}

