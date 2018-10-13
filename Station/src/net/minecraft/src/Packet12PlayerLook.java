package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet12PlayerLook
extends Packet10Flying {
    public Packet12PlayerLook() {
        this.i = true;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.e = dataInputStream.readFloat();
        this.f = dataInputStream.readFloat();
        super.a(dataInputStream);
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.e);
        dataOutputStream.writeFloat(this.f);
        super.a(dataOutputStream);
    }

    public int a() {
        return 9;
    }
}

