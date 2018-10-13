package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet21PickupSpawn
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
    public byte g;
    public int h;
    public int i;

    public Packet21PickupSpawn() {
    }

    public Packet21PickupSpawn(fa fa2) {
        this.a = fa2.c;
        this.h = fa2.a.c;
        this.i = fa2.a.a;
        this.b = fw.b(fa2.k * 32.0);
        this.c = fw.b(fa2.l * 32.0);
        this.d = fw.b(fa2.m * 32.0);
        this.e = (byte)(fa2.n * 128.0);
        this.f = (byte)(fa2.o * 128.0);
        this.g = (byte)(fa2.p * 128.0);
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.h = dataInputStream.readShort();
        this.i = dataInputStream.readByte();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
        this.g = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.h);
        dataOutputStream.writeByte(this.i);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.g);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 22;
    }
}

