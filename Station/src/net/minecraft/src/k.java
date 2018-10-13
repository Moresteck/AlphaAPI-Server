package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class k
extends ft {
    public float a;

    public k() {
    }

    public k(float f2) {
        this.a = f2;
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readFloat();
    }

    public byte a() {
        return 5;
    }

    public String toString() {
        return "" + this.a;
    }
}

