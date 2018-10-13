/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet20NamedEntitySpawn
extends Packet {
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;
    public int h;

    public Packet20NamedEntitySpawn() {
    }

    public Packet20NamedEntitySpawn(EntityPlayer entityplayer) {
        this.a = entityplayer.c;
        this.b = entityplayer.ap;
        this.c = MathHelper.b(entityplayer.k * 32.0);
        this.d = MathHelper.b(entityplayer.l * 32.0);
        this.e = MathHelper.b(entityplayer.m * 32.0);
        this.f = (byte)(entityplayer.q * 256.0f / 360.0f);
        this.g = (byte)(entityplayer.r * 256.0f / 360.0f);
        gc gc2 = entityplayer.ai.b();
        this.h = gc2 == null ? 0 : gc2.c;
    }

    public void a(DataInputStream dataInputStream) throws IOException {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readUTF();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.readInt();
        this.f = dataInputStream.readByte();
        this.g = dataInputStream.readByte();
        this.h = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeInt(this.e);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.g);
        dataOutputStream.writeShort(this.h);
    }

    public void a(NetHandler dy2) {
        dy2.a(this);
    }

    public int a() {
        return 28;
    }
}

