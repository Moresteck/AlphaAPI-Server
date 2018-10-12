/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class cq
extends el {
    public cq() {
        this.g = true;
    }

    public cq(int n2, byte by2, byte by3) {
        super(n2);
        this.e = by2;
        this.f = by3;
        this.g = true;
    }

    public void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
    }

    public int a() {
        return 6;
    }
}

