package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet14BlockDig
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public void a(DataInputStream dataInputStream) throws IOException {
        this.e = dataInputStream.read();
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.read();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.e);
        dataOutputStream.writeInt(this.a);
        dataOutputStream.write(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.write(this.d);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 11;
    }
}

