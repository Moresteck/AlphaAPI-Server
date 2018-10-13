package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class af {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static r a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
        try {
            r r2 = af.a(dataInputStream);
            return r2;
        }
        finally {
            dataInputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(r r2, OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));
        try {
            af.a(r2, dataOutputStream);
        }
        finally {
            dataOutputStream.close();
        }
    }

    public static r a(DataInput dataInput) {
        ft ft2 = ft.b(dataInput);
        if (ft2 instanceof r) {
            return (r)ft2;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void a(r r2, DataOutput dataOutput) {
        ft.a(r2, dataOutput);
    }
}

