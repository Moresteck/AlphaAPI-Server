/*
 * Decompiled with CFR 0_132.
 */
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ge {
    private static Map a = new HashMap();
    private static Map b = new HashMap();

    private static void a(Class class_, String string) {
        a.put(string, class_);
        b.put(class_, string);
    }

    public static Entity a(String string, World dp2) {
        Entity db2 = null;
        try {
            Class class_ = (Class)a.get(string);
            if (class_ != null) {
                db2 = (Entity)class_.getConstructor(World.class).newInstance(dp2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return db2;
    }

    public static Entity a(r r2, World dp2) {
        Entity db2 = null;
        try {
            Class class_ = (Class)a.get(r2.h("id"));
            if (class_ != null) {
                db2 = (Entity)class_.getConstructor(World.class).newInstance(dp2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (db2 != null) {
            db2.e(r2);
        } else {
            System.out.println("Skipping Entity with id " + r2.h("id"));
        }
        return db2;
    }

    public static String a(Entity db2) {
        return (String)b.get(db2.getClass());
    }

    static {
        ge.a(da.class, "Arrow");
        ge.a(av.class, "Snowball");
        ge.a(fa.class, "Item");
        ge.a(bp.class, "Painting");
        ge.a(EntityLiving.class, "Mob");
        ge.a(eu.class, "Monster");
        ge.a(ei.class, "Creeper");
        ge.a(dz.class, "Skeleton");
        ge.a(bg.class, "Spider");
        ge.a(p.class, "Giant");
        ge.a(ez.class, "Zombie");
        ge.a(ev.class, "Slime");
        ge.a(gg.class, "Pig");
        ge.a(cd.class, "Sheep");
        ge.a(au.class, "Cow");
        ge.a(gt.class, "Chicken");
        ge.a(bs.class, "PrimedTnt");
        ge.a(go.class, "FallingSand");
        ge.a(EntityMinecart.class, "Minecart");
        ge.a(eg.class, "Boat");
    }
}

