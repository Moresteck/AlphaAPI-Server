package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet15Place
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readShort();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.read();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.write(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.write(this.e);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 12;
    }
}

