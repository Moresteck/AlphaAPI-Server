/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class di
extends el {
    public di() {
    }

    public di(int n2, byte by2, byte by3, byte by4) {
        super(n2);
        this.b = by2;
        this.c = by3;
        this.d = by4;
    }

    public void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readByte();
        this.d = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.d);
    }

    public int a() {
        return 7;
    }
}

