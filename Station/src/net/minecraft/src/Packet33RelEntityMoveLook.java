package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet33RelEntityMoveLook
extends Packet30Entity {
    public Packet33RelEntityMoveLook() {
        this.g = true;
    }

    public Packet33RelEntityMoveLook(int n2, byte by2, byte by3, byte by4, byte by5, byte by6) {
        super(n2);
        this.b = by2;
        this.c = by3;
        this.d = by4;
        this.e = by5;
        this.f = by6;
        this.g = true;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        super.a(dataInputStream);
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readByte();
        this.d = dataInputStream.readByte();
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.d);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
    }

    public int a() {
        return 9;
    }
}

