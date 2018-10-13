package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet17AddToInventory
extends Packet {
    public int a;
    public int b;
    public int c;

    public Packet17AddToInventory() {
    }

    public Packet17AddToInventory(gc gc2, int n2) {
        this.a = gc2.c;
        this.b = n2;
        this.c = gc2.d;
        if (n2 == 0) {
            n2 = 1;
        }
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readShort();
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeShort(this.c);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 5;
    }
}

