package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet53BlockChange
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet53BlockChange() {
        this.j = true;
    }

    public Packet53BlockChange(int n2, int n3, int n4, World dp2) {
        this.j = true;
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = dp2.a(n2, n3, n4);
        this.e = dp2.b(n2, n3, n4);
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.read();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.read();
        this.e = dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.write(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.write(this.d);
        dataOutputStream.write(this.e);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 11;
    }
}

