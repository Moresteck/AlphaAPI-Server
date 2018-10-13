package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet32EntityLook
extends Packet30Entity {
    public Packet32EntityLook() {
        this.g = true;
    }

    public Packet32EntityLook(int n2, byte by2, byte by3) {
        super(n2);
        this.e = by2;
        this.f = by3;
        this.g = true;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        super.a(dataInputStream);
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
    }

    public int a() {
        return 6;
    }
}

