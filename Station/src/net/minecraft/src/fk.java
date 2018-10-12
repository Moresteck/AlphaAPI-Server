/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class fk
extends fs {
    public fk() {
        this.i = true;
    }

    public void a(DataInputStream dataInputStream) {
        this.e = dataInputStream.readFloat();
        this.f = dataInputStream.readFloat();
        super.a(dataInputStream);
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeFloat(this.e);
        dataOutputStream.writeFloat(this.f);
        super.a(dataOutputStream);
    }

    public int a() {
        return 9;
    }
}

