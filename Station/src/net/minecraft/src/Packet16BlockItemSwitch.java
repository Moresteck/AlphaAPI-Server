package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet16BlockItemSwitch
extends Packet {
    public int a;
    public int b;

    public Packet16BlockItemSwitch() {
    }

    public Packet16BlockItemSwitch(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.b);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 6;
    }
}

