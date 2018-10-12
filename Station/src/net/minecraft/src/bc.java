/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class bc
extends el {
    public bc() {
        this.g = true;
    }

    public bc(int n2, byte by2, byte by3, byte by4, byte by5, byte by6) {
        super(n2);
        this.b = by2;
        this.c = by3;
        this.d = by4;
        this.e = by5;
        this.f = by6;
        this.g = true;
    }

    public void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readByte();
        this.d = dataInputStream.readByte();
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
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

