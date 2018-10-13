package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet50PreChunk
extends Packet {
    public int a;
    public int b;
    public boolean c;

    public Packet50PreChunk() {
    }

    public Packet50PreChunk(int n2, int n3, boolean bl2) {
        this.j = true;
        this.a = n2;
        this.b = n3;
        this.c = bl2;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.read() != 0;
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.write(this.c ? 1 : 0);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 9;
    }
}

