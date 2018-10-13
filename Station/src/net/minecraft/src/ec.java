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
        String string = "isChunkLoaded." + Integer.toString(n2, 36) + "." + Integer.toString(n3, 36) + ".dat";
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

    public Chunk a(World dp2, int n2, int n3) {
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
                Chunk chunk2 = ec.a(dp2, r2.j("Level"));
                if (!chunk2.a(n2, n3)) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is in the wrong location; relocating. (Expected " + n2 + ", " + n3 + ", got " + chunk2.xPosition + ", " + chunk2.zPosition + ")");
                    r2.a("xPos", n2);
                    r2.a("zPos", n3);
                    chunk2 = ec.a(dp2, r2.j("Level"));
                }
                return chunk2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void a(World dp2, Chunk chunk2) {
        dp2.g();
        File file = this.a(chunk2.xPosition, chunk2.zPosition);
        if (file.exists()) {
            dp2.q -= file.length();
        }
        try {
            File file2 = new File(this.a, "tmp_chunk.dat");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            r r2 = new r();
            r r3 = new r();
            r2.a("Level", (ft)r3);
            this.a(chunk2, dp2, r3);
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

    public void a(Chunk chunk2, World dp2, r r2) {
        r r3;
        dp2.g();
        r2.a("xPos", chunk2.xPosition);
        r2.a("zPos", chunk2.zPosition);
        r2.a("LastUpdate", dp2.b);
        r2.a("Blocks", chunk2.blocks);
        r2.a("Data", chunk2.e.a);
        r2.a("SkyLight", chunk2.f.a);
        r2.a("BlockLight", chunk2.g.a);
        r2.a("HeightMap", chunk2.heightMap);
        r2.a("TerrainPopulated", chunk2.n);
        chunk2.r = false;
        de de2 = new de();
        for (int i2 = 0; i2 < chunk2.entities.length; ++i2) {
            for (Object object : chunk2.entities[i2]) {
                chunk2.r = true;
                r3 = new r();
                if (!((Entity)object).c(r3)) continue;
                de2.a(r3);
            }
        }
        r2.a("Entities", de2);
        de de3 = new de();
        for (Object object : chunk2.chunkTileEntityMap.values()) {
            r3 = new r();
            ((Entity)object).b(r3);
            de3.a(r3);
        }
        r2.a("TileEntities", de3);
    }

    public static Chunk a(World dp2, r r2) {
        de de2;
        de de3;
        Object object;
        int n2 = r2.d("xPos");
        int n3 = r2.d("zPos");
        Chunk chunk2 = new Chunk(dp2, n2, n3);
        chunk2.blocks = r2.i("Blocks");
        chunk2.e = new gh(r2.i("Data"));
        chunk2.f = new gh(r2.i("SkyLight"));
        chunk2.g = new gh(r2.i("BlockLight"));
        chunk2.heightMap = r2.i("HeightMap");
        chunk2.n = r2.l("TerrainPopulated");
        if (!chunk2.e.a()) {
            chunk2.e = new gh(chunk2.blocks.length);
        }
        if (chunk2.heightMap == null || !chunk2.f.a()) {
            chunk2.heightMap = new byte[256];
            chunk2.f = new gh(chunk2.blocks.length);
            chunk2.b();
        }
        if (!chunk2.g.a()) {
            chunk2.g = new gh(chunk2.blocks.length);
            chunk2.a();
        }
        if ((de2 = r2.k("Entities")) != null) {
            for (int i2 = 0; i2 < de2.b(); ++i2) {
                r r3 = (r)de2.a(i2);
                object = EntityTypes.a(r3, dp2);
                chunk2.r = true;
                if (object == null) continue;
                chunk2.a((Entity)object);
            }
        }
        if ((de3 = r2.k("TileEntities")) != null) {
            for (int i3 = 0; i3 < de3.b(); ++i3) {
                object = (r)de3.a(i3);
                TileEntity ap2 = TileEntity.c((r)object);
                if (ap2 == null) continue;
                chunk2.a(ap2);
            }
        }
        return chunk2;
    }

    public void a() {
    }

    public void b() {
    }

    public void b(World dp2, Chunk chunk2) {
    }
}

