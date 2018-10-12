/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class w
extends fs {
    public w() {
        this.h = true;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readDouble();
        this.b = dataInputStream.readDouble();
        this.d = dataInputStream.readDouble();
        this.c = dataInputStream.readDouble();
        super.a(dataInputStream);
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeDouble(this.a);
        dataOutputStream.writeDouble(this.b);
        dataOutputStream.writeDouble(this.d);
        dataOutputStream.writeDouble(this.c);
        super.a(dataOutputStream);
    }

    public int a() {
        return 33;
    }
}

