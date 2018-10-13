package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class dk
extends ft {
    public double a;

    public dk() {
    }

    public dk(double d2) {
        this.a = d2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeDouble(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readDouble();
    }

    public byte a() {
        return 6;
    }

    public String toString() {
        return "" + this.a;
    }
}

