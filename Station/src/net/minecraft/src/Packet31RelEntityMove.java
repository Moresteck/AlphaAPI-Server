package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet31RelEntityMove
extends Packet30Entity {
    public Packet31RelEntityMove() {
    }

    public Packet31RelEntityMove(int n2, byte by2, byte by3, byte by4) {
        super(n2);
        this.b = by2;
        this.c = by3;
        this.d = by4;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        super.a(dataInputStream);
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readByte();
        this.d = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.d);
    }

    public int a() {
        return 7;
    }
}

