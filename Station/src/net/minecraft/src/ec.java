package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// ChunkFile ?
public class ec
implements am {
    private File a;
    private boolean b;

    public ec(File file, boolean bl2) {
        this.a = file;
        this.b = bl2;
    }

    private File a(int n2, int n3) {
        String string = "c." + Integer.toString(n2, 36) + "." + Integer.toString(n3, 36) + ".dat";
        String string2 = Integer.toString(n2 & 63, 36);
        String string3 = Integer.toString(n3 & 63, 36);
        File file = new File(this.a, string2);
        if (!file.exists()) {
            if (this.b) {
                file.mkdir();
            } else {
                return null;
            }
        }
        if (!(file = new File(file, string3)).exists()) {
            if (this.b) {
                file.mkdir();
            } else {
                return null;
            }
        }
        if (!(file = new File(file, string)).exists() && !this.b) {
            return null;
        }
        return file;
    }

    public hv a(World dp2, int n2, int n3) {
        File file = this.a(n2, n3);
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                r r2 = af.a(fileInputStream);
                if (!r2.a("Level")) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is missing level data, skipping");
                    return null;
                }
                if (!r2.j("Level").a("Blocks")) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is missing block data, skipping");
                    return null;
                }
                hv hv2 = ec.a(dp2, r2.j("Level"));
                if (!hv2.a(n2, n3)) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is in the wrong location; relocating. (Expected " + n2 + ", " + n3 + ", got " + hv2.j + ", " + hv2.k + ")");
                    r2.a("xPos", n2);
                    r2.a("zPos", n3);
                    hv2 = ec.a(dp2, r2.j("Level"));
                }
                return hv2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void a(World dp2, hv hv2) {
        dp2.g();
        File file = this.a(hv2.j, hv2.k);
        if (file.exists()) {
            dp2.q -= file.length();
        }
        try {
            File file2 = new File(this.a, "tmp_chunk.dat");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            r r2 = new r();
            r r3 = new r();
            r2.a("Level", (ft)r3);
            this.a(hv2, dp2, r3);
            af.a(r2, fileOutputStream);
            fileOutputStream.close();
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
            dp2.q += file.length();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(hv hv2, World dp2, r r2) {
        r r3;
        dp2.g();
        r2.a("xPos", hv2.j);
        r2.a("zPos", hv2.k);
        r2.a("LastUpdate", dp2.b);
        r2.a("Blocks", hv2.b);
        r2.a("Data", hv2.e.a);
        r2.a("SkyLight", hv2.f.a);
        r2.a("BlockLight", hv2.g.a);
        r2.a("HeightMap", hv2.h);
        r2.a("TerrainPopulated", hv2.n);
        hv2.r = false;
        de de2 = new de();
        for (int i2 = 0; i2 < hv2.m.length; ++i2) {
            for (Object object : hv2.m[i2]) {
                hv2.r = true;
                r3 = new r();
                if (!((Entity)object).c(r3)) continue;
                de2.a(r3);
            }
        }
        r2.a("Entities", de2);
        de de3 = new de();
        for (Object object : hv2.l.values()) {
            r3 = new r();
            ((Entity)object).b(r3);
            de3.a(r3);
        }
        r2.a("TileEntities", de3);
    }

    public static hv a(World dp2, r r2) {
        de de2;
        de de3;
        Object object;
        int n2 = r2.d("xPos");
        int n3 = r2.d("zPos");
        hv hv2 = new hv(dp2, n2, n3);
        hv2.b = r2.i("Blocks");
        hv2.e = new gh(r2.i("Data"));
        hv2.f = new gh(r2.i("SkyLight"));
        hv2.g = new gh(r2.i("BlockLight"));
        hv2.h = r2.i("HeightMap");
        hv2.n = r2.l("TerrainPopulated");
        if (!hv2.e.a()) {
            hv2.e = new gh(hv2.b.length);
        }
        if (hv2.h == null || !hv2.f.a()) {
            hv2.h = new byte[256];
            hv2.f = new gh(hv2.b.length);
            hv2.b();
        }
        if (!hv2.g.a()) {
            hv2.g = new gh(hv2.b.length);
            hv2.a();
        }
        if ((de2 = r2.k("Entities")) != null) {
            for (int i2 = 0; i2 < de2.b(); ++i2) {
                r r3 = (r)de2.a(i2);
                object = EntityTypes.a(r3, dp2);
                hv2.r = true;
                if (object == null) continue;
                hv2.a((Entity)object);
            }
        }
        if ((de3 = r2.k("TileEntities")) != null) {
            for (int i3 = 0; i3 < de3.b(); ++i3) {
                object = (r)de3.a(i3);
                TileEntity ap2 = TileEntity.c((r)object);
                if (ap2 == null) continue;
                hv2.a(ap2);
            }
        }
        return hv2;
    }

    public void a() {
    }

    public void b() {
    }

    public void b(World dp2, hv hv2) {
    }
}

