package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet1Login
extends Packet {
    public int a;
    public String b;
    public String c;

    public Packet1Login() {
    }

    public Packet1Login(String string, String string2, int n2) {
        this.b = string;
        this.c = string2;
        this.a = n2;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readUTF();
        this.c = dataInputStream.readUTF();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        dataOutputStream.writeUTF(this.c);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 4 + this.b.length() + this.c.length() + 4;
    }
}

