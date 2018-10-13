<<<<<<< HEAD:Station/src/net/minecraft/src/EntityTypes.java
package net.minecraft.src;
=======
package net.minecraft.src;/*
 * Decompiled with CFR 0_132.
 */
import java.io.PrintStream;
import java.lang.reflect.Constructor;
>>>>>>> b77d6455ae9338e01f6531751a545b600c4f01b2:Station/src/net/minecraft/src/ge.java
import java.util.HashMap;
import java.util.Map;

public class EntityTypes {
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
        EntityTypes.a(da.class, "Arrow");
        EntityTypes.a(av.class, "Snowball");
        EntityTypes.a(fa.class, "Item");
        EntityTypes.a(EntityPainting.class, "Painting");
        EntityTypes.a(EntityLiving.class, "Mob");
        EntityTypes.a(EntityMonster.class, "Monster");
        EntityTypes.a(EntityCreeper.class, "Creeper");
        EntityTypes.a(EntitySkeleton.class, "Skeleton");
        EntityTypes.a(EntitySpider.class, "Spider");
        EntityTypes.a(p.class, "Giant");
        EntityTypes.a(EntityZombie.class, "Zombie");
        EntityTypes.a(EntitySlime.class, "Slime");
        EntityTypes.a(EntityPig.class, "Pig");
        EntityTypes.a(EntitySheep.class, "Sheep");
        EntityTypes.a(EntityCow.class, "Cow");
        EntityTypes.a(EntityChicken.class, "Chicken");
        EntityTypes.a(bs.class, "PrimedTnt");
        EntityTypes.a(go.class, "FallingSand");
        EntityTypes.a(EntityMinecart.class, "Minecart");
        EntityTypes.a(eg.class, "Boat");
    }
}

