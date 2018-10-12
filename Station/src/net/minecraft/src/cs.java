/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class cs
extends Packet {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte[] g;
    private int h;

    public cs() {
        this.j = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public cs(int n2, int n3, int n4, int n5, int n6, int n7, World dp2) {
        this.j = true;
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = n5;
        this.e = n6;
        this.f = n7;
        byte[] arrby = dp2.c(n2, n3, n4, n5, n6, n7);
        Deflater deflater = new Deflater(1);
        try {
            deflater.setInput(arrby);
            deflater.finish();
            this.g = new byte[n5 * n6 * n7 * 5 / 2];
            this.h = deflater.deflate(this.g);
        }
        finally {
            deflater.end();
        }
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readShort();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.read() + 1;
        this.e = dataInputStream.read() + 1;
        this.f = dataInputStream.read() + 1;
        int n2 = dataInputStream.readInt();
        byte[] arrby = new byte[n2];
        dataInputStream.readFully(arrby);
        this.g = new byte[this.d * this.e * this.f * 5 / 2];
        Inflater inflater = new Inflater();
        inflater.setInput(arrby);
        try {
            inflater.inflate(this.g);
        }
        catch (DataFormatException dataFormatException) {
            throw new IOException("Bad compressed data format");
        }
        finally {
            inflater.end();
        }
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.write(this.d - 1);
        dataOutputStream.write(this.e - 1);
        dataOutputStream.write(this.f - 1);
        dataOutputStream.writeInt(this.h);
        dataOutputStream.write(this.g, 0, this.h);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 17 + this.h;
    }
}

