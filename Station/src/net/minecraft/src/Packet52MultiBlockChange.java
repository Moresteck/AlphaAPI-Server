package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet52MultiBlockChange
extends Packet {
    public int a;
    public int b;
    public short[] c;
    public byte[] d;
    public byte[] e;
    public int f;

    public Packet52MultiBlockChange() {
        this.j = true;
    }

    public Packet52MultiBlockChange(int n2, int n3, short[] arrs, int n4, World dp2) {
        this.j = true;
        this.a = n2;
        this.b = n3;
        this.f = n4;
        this.c = new short[n4];
        this.d = new byte[n4];
        this.e = new byte[n4];
        Chunk chunk2 = dp2.b(n2, n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = arrs[i2] >> 12 & 15;
            int n6 = arrs[i2] >> 8 & 15;
            int n7 = arrs[i2] & 255;
            this.c[i2] = arrs[i2];
            this.d[i2] = (byte) chunk2.a(n5, n7, n6);
            this.e[i2] = (byte) chunk2.b(n5, n7, n6);
        }
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.f = dataInputStream.readShort() & 65535;
        this.c = new short[this.f];
        this.d = new byte[this.f];
        this.e = new byte[this.f];
        for (int i2 = 0; i2 < this.f; ++i2) {
            this.c[i2] = dataInputStream.readShort();
        }
        dataInputStream.readFully(this.d);
        dataInputStream.readFully(this.e);
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeShort((short)this.f);
        for (int i2 = 0; i2 < this.f; ++i2) {
            dataOutputStream.writeShort(this.c[i2]);
        }
        dataOutputStream.write(this.d);
        dataOutputStream.write(this.e);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 10 + this.f * 4;
    }
}

