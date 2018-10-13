package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class bb
extends ft {
    public int a;

    public bb() {
    }

    public bb(int n2) {
        this.a = n2;
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readInt();
    }

    public byte a() {
        return 3;
    }

    public String toString() {
        return "" + this.a;
    }
}

