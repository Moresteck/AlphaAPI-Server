package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ep
extends ft {
    public short a;

    public ep() {
    }

    public ep(short s2) {
        this.a = s2;
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readShort();
    }

    public byte a() {
        return 2;
    }

    public String toString() {
        return "" + this.a;
    }
}

