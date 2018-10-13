package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet10Flying
extends Packet {
    public double a;
    public double b;
    public double c;
    public double d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.g = dataInputStream.read() != 0;
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.g ? 1 : 0);
    }

    public int a() {
        return 1;
    }
}

