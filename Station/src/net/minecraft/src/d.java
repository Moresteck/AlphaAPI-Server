package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class d
extends ft {
    public long a;

    public d() {
    }

    public d(long l2) {
        this.a = l2;
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readLong();
    }

    public byte a() {
        return 4;
    }

    public String toString() {
        return "" + this.a;
    }
}

