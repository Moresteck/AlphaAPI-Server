package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class gu
extends ft {
    public String a;

    public gu() {
    }

    public gu(String string) {
        this.a = string;
        if (string == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.a);
    }

    void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readUTF();
    }

    public byte a() {
        return 8;
    }

    public String toString() {
        return "" + this.a;
    }
}

