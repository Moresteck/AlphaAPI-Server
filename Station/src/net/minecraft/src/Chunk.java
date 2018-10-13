package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Chunk {
    public static boolean isLit;
    public byte blocks[];
    public boolean isChunkLoaded;
    public World world;
    public gh e;
    public gh f;
    public gh g;
    public byte[] heightMap;
    public int i;
    public final int xPosition;
    public final int zPosition;
    public Map chunkTileEntityMap = new HashMap();
    public List[] entities = new List[8];
    public boolean n = false;
    public boolean isModified = false;
    public boolean p;
    public boolean q = false;
    public boolean r = false;
    public long s = 0L;

    public Chunk(World world, int xPos, int zPos) {
        this.world = world;
        this.xPosition = xPos;
        this.zPosition = zPos;
        this.heightMap = new byte[256];
        for (int i2 = 0; i2 < this.entities.length; ++i2) {
            this.entities[i2] = new ArrayList();
        }
    }

    public Chunk(World world, byte[] abyte0, int i, int j) {
        this(world, i, j);
        this.blocks = abyte0;
        this.e = new gh(abyte0.length);
        this.f = new gh(abyte0.length);
        this.g = new gh(abyte0.length);
    }

    public boolean a(int xPos, int zPos) {
        return xPos == this.xPosition && zPos == this.zPosition;
    }

    public int b(int xPos, int zPos) {
        return this.heightMap[zPos << 4 | xPos] & 255;
    }

    public void a() {
    }

    public void b() {
        int n2;
        int n3;
        int n4 = 127;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n3 = 0; n3 < 16; ++n3) {
                this.heightMap[n3 << 4 | n2] = -128;
                this.g(n2, 127, n3);
                if ((this.heightMap[n3 << 4 | n2] & 255) >= n4) continue;
                n4 = this.heightMap[n3 << 4 | n2] & 255;
            }
        }
        this.i = n4;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n3 = 0; n3 < 16; ++n3) {
                this.c(n2, n3);
            }
        }
        this.isModified = true;
    }

    private void c(int n2, int n3) {
        int n4 = this.b(n2, n3);
        int n5 = this.xPosition * 16 + n2;
        int n6 = this.zPosition * 16 + n3;
        this.f(n5 - 1, n6, n4);
        this.f(n5 + 1, n6, n4);
        this.f(n5, n6 - 1, n4);
        this.f(n5, n6 + 1, n4);
    }

    private void f(int n2, int n3, int n4) {
        int n5 = this.world.c(n2, n3);
        if (n5 > n4) {
            this.world.a(cr.a, n2, n4, n3, n2, n5, n3);
        } else if (n5 < n4) {
            this.world.a(cr.a, n2, n5, n3, n2, n4, n3);
        }
        this.isModified = true;
    }

    private void g(int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9 = n5 = this.heightMap[n4 << 4 | n2] & 255;
        if (n3 > n5) {
            n9 = n3;
        }
        int n10 = n2 << 11 | n4 << 7;
        while (n9 > 0 && Block.q[this.blocks[n10 + n9 - 1]] == 0) {
            --n9;
        }
        if (n9 == n5) {
            return;
        }
        this.world.f(n2, n4, n9, n5);
        this.heightMap[n4 << 4 | n2] = (byte)n9;
        if (n9 < this.i) {
            this.i = n9;
        } else {
            n7 = 127;
            for (n6 = 0; n6 < 16; ++n6) {
                for (n8 = 0; n8 < 16; ++n8) {
                    if ((this.heightMap[n8 << 4 | n6] & 255) >= n7) continue;
                    n7 = this.heightMap[n8 << 4 | n6] & 255;
                }
            }
            this.i = n7;
        }
        n7 = this.xPosition * 16 + n2;
        n6 = this.zPosition * 16 + n4;
        if (n9 < n5) {
            for (n8 = n9; n8 < n5; ++n8) {
                this.f.a(n2, n8, n4, 15);
            }
        } else {
            this.world.a(cr.a, n7, n5, n6, n7, n9, n6);
            for (n8 = n5; n8 < n9; ++n8) {
                this.f.a(n2, n8, n4, 0);
            }
        }
        n8 = 15;
        int n11 = n9;
        while (n9 > 0 && n8 > 0) {
            int n12;
            if ((n12 = Block.q[this.a(n2, --n9, n4)]) == 0) {
                n12 = 1;
            }
            if ((n8 -= n12) < 0) {
                n8 = 0;
            }
            this.f.a(n2, n9, n4, n8);
        }
        while (n9 > 0 && Block.q[this.a(n2, n9 - 1, n4)] == 0) {
            --n9;
        }
        if (n9 != n11) {
            this.world.a(cr.a, n7 - 1, n9, n6 - 1, n7 + 1, n11, n6 + 1);
        }
        this.isModified = true;
    }

    public int a(int n2, int n3, int n4) {
        return this.blocks[n2 << 11 | n4 << 7 | n3];
    }

    public boolean a(int n2, int n3, int n4, int n5, int n6) {
        byte by2 = (byte)n5;
        int n7 = this.heightMap[n4 << 4 | n2] & 255;
        int n8 = this.blocks[n2 << 11 | n4 << 7 | n3] & 255;
        if (n8 == n5) {
            return false;
        }
        int n9 = this.xPosition * 16 + n2;
        int n10 = this.zPosition * 16 + n4;
        this.blocks[n2 << 11 | n4 << 7 | n3] = by2;
        if (n8 != 0 && !this.world.t) {
            Block.n[n8].b(this.world, n9, n3, n10);
        }
        this.e.a(n2, n3, n4, n6);
        if (Block.q[by2] != 0) {
            if (n3 >= n7) {
                this.g(n2, n3 + 1, n4);
            }
        } else if (n3 == n7 - 1) {
            this.g(n2, n3, n4);
        }
        this.world.a(cr.a, n9, n3, n10, n9, n3, n10);
        this.world.a(cr.b, n9, n3, n10, n9, n3, n10);
        this.c(n2, n4);
        if (n5 != 0) {
            Block.n[n5].e(this.world, n9, n3, n10);
        }
        this.isModified = true;
        return true;
    }

    public boolean a(int n2, int n3, int n4, int n5) {
        byte by2 = (byte)n5;
        int n6 = this.heightMap[n4 << 4 | n2] & 255;
        int n7 = this.blocks[n2 << 11 | n4 << 7 | n3] & 255;
        if (n7 == n5) {
            return false;
        }
        int n8 = this.xPosition * 16 + n2;
        int n9 = this.zPosition * 16 + n4;
        this.blocks[n2 << 11 | n4 << 7 | n3] = by2;
        if (n7 != 0) {
            Block.n[n7].b(this.world, n8, n3, n9);
        }
        this.e.a(n2, n3, n4, 0);
        if (Block.q[by2] != 0) {
            if (n3 >= n6) {
                this.g(n2, n3 + 1, n4);
            }
        } else if (n3 == n6 - 1) {
            this.g(n2, n3, n4);
        }
        this.world.a(cr.a, n8, n3, n9, n8, n3, n9);
        this.world.a(cr.b, n8, n3, n9, n8, n3, n9);
        this.c(n2, n4);
        if (n5 != 0 && !this.world.t) {
            Block.n[n5].e(this.world, n8, n3, n9);
        }
        this.isModified = true;
        return true;
    }

    public int b(int n2, int n3, int n4) {
        return this.e.a(n2, n3, n4);
    }

    public void b(int n2, int n3, int n4, int n5) {
        this.isModified = true;
        this.e.a(n2, n3, n4, n5);
    }

    public int a(cr cr2, int n2, int n3, int n4) {
        if (cr2 == cr.a) {
            return this.f.a(n2, n3, n4);
        }
        if (cr2 == cr.b) {
            return this.g.a(n2, n3, n4);
        }
        return 0;
    }

    public void a(cr cr2, int n2, int n3, int n4, int n5) {
        this.isModified = true;
        if (cr2 == cr.a) {
            this.f.a(n2, n3, n4, n5);
        } else if (cr2 == cr.b) {
            this.g.a(n2, n3, n4, n5);
        } else {
            return;
        }
    }

    public int c(int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = this.f.a(n2, n3, n4);
        if (n7 > 0) {
            isLit = true;
        }
        if ((n6 = this.g.a(n2, n3, n4)) > (n7 -= n5)) {
            n7 = n6;
        }
        return n7;
    }

    public void a(Entity db2) {
        int n2;
        if (this.q) {
            return;
        }
        this.r = true;
        int n3 = MathHelper.b(db2.k / 16.0);
        int n4 = MathHelper.b(db2.m / 16.0);
        if (n3 != this.xPosition || n4 != this.zPosition) {
            System.out.println("Wrong location! " + db2);
        }
        if ((n2 = MathHelper.b(db2.l / 16.0)) < 0) {
            n2 = 0;
        }
        if (n2 >= this.entities.length) {
            n2 = this.entities.length - 1;
        }
        db2.Y = true;
        db2.Z = this.xPosition;
        db2.aa = n2;
        db2.ab = this.zPosition;
        this.entities[n2].add(db2);
    }

    public void b(Entity db2) {
        this.a(db2, db2.aa);
    }

    public void a(Entity db2, int n2) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 >= this.entities.length) {
            n2 = this.entities.length - 1;
        }
        this.entities[n2].remove(db2);
    }

    public boolean c(int n2, int n3, int n4) {
        return n3 >= (this.heightMap[n4 << 4 | n2] & 255);
    }

    public TileEntity d(int n2, int n3, int n4) {
        gf gf2 = new gf(n2, n3, n4);
        TileEntity ap2 = (TileEntity)this.chunkTileEntityMap.get(gf2);
        if (ap2 == null) {
            int n5 = this.a(n2, n3, n4);
            cl cl2 = (cl)Block.n[n5];
            cl2.e(this.world, this.xPosition * 16 + n2, n3, this.zPosition * 16 + n4);
            ap2 = (TileEntity)this.chunkTileEntityMap.get(gf2);
        }
        return ap2;
    }

    public void a(TileEntity ap2) {
        int n2 = ap2.b - this.xPosition * 16;
        int n3 = ap2.c;
        int n4 = ap2.d - this.zPosition * 16;
        this.a(n2, n3, n4, ap2);
    }

    public void a(int n2, int n3, int n4, TileEntity ap2) {
        gf gf2 = new gf(n2, n3, n4);
        ap2.a = this.world;
        ap2.b = this.xPosition * 16 + n2;
        ap2.c = n3;
        ap2.d = this.zPosition * 16 + n4;
        if (this.a(n2, n3, n4) == 0 || !(Block.n[this.a(n2, n3, n4)] instanceof cl)) {
            System.out.println("Attempted to place a tile entity where there was no entity tile!");
            return;
        }
        if (this.isChunkLoaded) {
            if (this.chunkTileEntityMap.get(gf2) != null) {
                this.world.a.remove(this.chunkTileEntityMap.get(gf2));
            }
            this.world.a.add(ap2);
        }
        this.chunkTileEntityMap.put(gf2, ap2);
    }

    public void e(int n2, int n3, int n4) {
        gf gf2 = new gf(n2, n3, n4);
        if (this.isChunkLoaded) {
            this.world.a.remove(this.chunkTileEntityMap.remove(gf2));
        }
    }

    public void c() {
        this.isChunkLoaded = true;
        this.world.a.addAll(this.chunkTileEntityMap.values());
        for (int i2 = 0; i2 < this.entities.length; ++i2) {
            this.world.a(this.entities[i2]);
        }
    }

    public void d() {
        this.isChunkLoaded = false;
        this.world.a.removeAll(this.chunkTileEntityMap.values());
        for (int i2 = 0; i2 < this.entities.length; ++i2) {
            this.world.b(this.entities[i2]);
        }
    }

    public void e() {
        this.isModified = true;
    }

    public void a(Entity db2, AxisAlignedBB cy2, List list) {
        int n2 = MathHelper.b((cy2.b - 2.0) / 16.0);
        int n3 = MathHelper.b((cy2.e + 2.0) / 16.0);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= this.entities.length) {
            n3 = this.entities.length - 1;
        }
        for (int i2 = n2; i2 <= n3; ++i2) {
            List list2 = this.entities[i2];
            for (int i3 = 0; i3 < list2.size(); ++i3) {
                Entity db3 = (Entity)list2.get(i3);
                if (db3 == db2 || !db3.u.a(cy2)) continue;
                list.add(db3);
            }
        }
    }

    public void a(Class class_, AxisAlignedBB cy2, List list) {
        int n2 = MathHelper.b((cy2.b - 2.0) / 16.0);
        int n3 = MathHelper.b((cy2.e + 2.0) / 16.0);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= this.entities.length) {
            n3 = this.entities.length - 1;
        }
        for (int i2 = n2; i2 <= n3; ++i2) {
            List list2 = this.entities[i2];
            for (int i3 = 0; i3 < list2.size(); ++i3) {
                Entity db2 = (Entity)list2.get(i3);
                if (!class_.isAssignableFrom(db2.getClass()) || !db2.u.a(cy2)) continue;
                list.add(db2);
            }
        }
    }

    public boolean a(boolean bl2) {
        if (this.p) {
            return false;
        }
        if (this.r && this.world.b != this.s) {
            return true;
        }
        return this.isModified;
    }

    public int a(byte[] arrby, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9;
        int n10;
        int n11;
        int n12;
        for (n11 = n2; n11 < n5; ++n11) {
            for (n10 = n4; n10 < n7; ++n10) {
                n12 = n11 << 11 | n10 << 7 | n3;
                n9 = n6 - n3;
                System.arraycopy(this.blocks, n12, arrby, n8, n9);
                n8 += n9;
            }
        }
        for (n11 = n2; n11 < n5; ++n11) {
            for (n10 = n4; n10 < n7; ++n10) {
                n12 = (n11 << 11 | n10 << 7 | n3) >> 1;
                n9 = (n6 - n3) / 2;
                System.arraycopy(this.e.a, n12, arrby, n8, n9);
                n8 += n9;
            }
        }
        for (n11 = n2; n11 < n5; ++n11) {
            for (n10 = n4; n10 < n7; ++n10) {
                n12 = (n11 << 11 | n10 << 7 | n3) >> 1;
                n9 = (n6 - n3) / 2;
                System.arraycopy(this.g.a, n12, arrby, n8, n9);
                n8 += n9;
            }
        }
        for (n11 = n2; n11 < n5; ++n11) {
            for (n10 = n4; n10 < n7; ++n10) {
                n12 = (n11 << 11 | n10 << 7 | n3) >> 1;
                n9 = (n6 - n3) / 2;
                System.arraycopy(this.f.a, n12, arrby, n8, n9);
                n8 += n9;
            }
        }
        return n8;
    }

    public Random a(long l2) {
        return new Random(this.world.p + (long)(this.xPosition * this.xPosition * 4987142) + (long)(this.xPosition * 5947611) + (long)(this.zPosition * this.zPosition) * 4392871L + (long)(this.zPosition * 389711) ^ l2);
    }
}

