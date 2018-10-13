package net.minecraft.src;
/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet11PlayerPosition
extends Packet10Flying {
    public Packet11PlayerPosition() {
        this.h = true;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readDouble();
        this.b = dataInputStream.readDouble();
        this.d = dataInputStream.readDouble();
        this.c = dataInputStream.readDouble();
        super.a(dataInputStream);
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
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

