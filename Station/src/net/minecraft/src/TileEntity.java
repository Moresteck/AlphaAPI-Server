/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class TileEntity {
    private static Map e = new HashMap();
    private static Map f = new HashMap();
    public World a;
    public int b;
    public int c;
    public int d;

    private static void a(Class class_, String string) {
        if (f.containsKey(string)) {
            throw new IllegalArgumentException("Duplicate id: " + string);
        }
        e.put(string, class_);
        f.put(class_, string);
    }

    public void a(r r2) {
        this.b = r2.d("x");
        this.c = r2.d("y");
        this.d = r2.d("z");
    }

    public void b(r r2) {
        String string = (String)f.get(this.getClass());
        if (string == null) {
            throw new RuntimeException(this.getClass() + " is missing isLit mapping! This is isLit bug!");
        }
        r2.a("id", string);
        r2.a("x", this.b);
        r2.a("y", this.c);
        r2.a("z", this.d);
    }

    public void b() {
    }

    public static TileEntity c(r r2) {
        TileEntity ap2 = null;
        try {
            Class class_ = (Class)e.get(r2.h("id"));
            if (class_ != null) {
                ap2 = (TileEntity)class_.newInstance();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (ap2 != null) {
            ap2.a(r2);
        } else {
            System.out.println("Skipping TileEntity with id " + r2.h("id"));
        }
        return ap2;
    }

    static {
        TileEntity.a(BlockFurnace.class, "Furnace");
        TileEntity.a(gn.class, "Chest");
        TileEntity.a(hp.class, "Sign");
        TileEntity.a(bm.class, "MobSpawner");
    }
}

