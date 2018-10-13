package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class bj
extends ft {
    public byte a;

    public bj() {
    }

    public bj(byte by2) {
        this.a = by2;
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readByte();
    }

    public byte a() {
        return 1;
    }

    public String toString() {
        return "" + this.a;
    }
}

