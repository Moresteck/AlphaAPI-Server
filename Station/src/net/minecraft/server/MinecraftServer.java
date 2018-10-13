/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.server;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.src.Vec3D;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.ThreadServerApplication;
import net.minecraft.src.ThreadCommandReader;
import net.minecraft.src.ThreadShutdown;
import net.minecraft.src.PropertyManager;
import net.minecraft.src.NetworkListenThread;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.IUpdatePlayerListBox;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.dr;
import net.minecraft.src.WorldServer;
import net.minecraft.src.en;
import net.minecraft.src.ConsoleLogManager;
import net.minecraft.src.ServerGUI;
import net.minecraft.src.ServerConfigurationManager;
import net.minecraft.src.EntityTracker;
import net.minecraft.src.gc;

public class MinecraftServer
implements Runnable {
    public static Logger log = Logger.getLogger("Minecraft");
    public static HashMap hashStory = new HashMap();
    public NetworkListenThread networkListener;
    public PropertyManager propertyManager;
    public WorldServer world;
    public ServerConfigurationManager configManager;
    private boolean serverRunning = true;
    public boolean serverStopped = false;
    int deathTime = 0;
    public String currentTask;
    public int percentDone;
    private List playerListBoxes = new ArrayList();
    private List commands = Collections.synchronizedList(new ArrayList());
    public EntityTracker entityTracker;

    private boolean startServer() throws UnknownHostException {
        Runtime.getRuntime().addShutdownHook(new ThreadShutdown(this));
        ThreadCommandReader threadcommandreader = new ThreadCommandReader(this);
        threadcommandreader.setDaemon(true);
        threadcommandreader.start();
        ConsoleLogManager.init();
        log.info("Starting minecraft server version 0.1.0");
        if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
            log.warning("**** NOT ENOUGH RAM!");
            log.warning("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
        }
        log.info("Loading properties");
        this.propertyManager = new PropertyManager(new File("server.properties"));
        String address = this.propertyManager.getStringProperty("server-ip", "");
        InetAddress inetAddress = null;
        if (address.length() > 0) {
            inetAddress = InetAddress.getByName(address);
        }
        int port = this.propertyManager.getIntProperty("server-port", 25565);
        log.info("Starting Minecraft server on " + (address.length() == 0 ? "*" : address) + ":" + port);
        try {
            this.networkListener = new NetworkListenThread(this, inetAddress, port);
        }
        catch (IOException iOException) {
            log.warning("**** FAILED TO BIND TO PORT!");
            log.log(Level.WARNING, "The exception was: " + iOException.toString());
            log.warning("Perhaps a server is already running on that port?");
            return false;
        }
        this.configManager = new ServerConfigurationManager(this);
        this.entityTracker = new EntityTracker(this);
        String name = this.propertyManager.getStringProperty("level-name", "world");
        log.info("Preparing level \"" + name + "\"");
        this.initWorld(name);
        log.info("Done! For help, type \"help\" or \"?\"");
        return true;
    }

    private void initWorld(String name) {
        log.info("Preparing start region");
        this.world = new WorldServer(new File("."), name);
        this.world.a(new dr(this));
        int n2 = 10;
        for (int i2 = - n2; i2 <= n2; ++i2) {
            this.outputPercentRemaining("Preparing spawn area", (i2 + n2) * 100 / (n2 + n2 + 1));
            for (int i3 = - n2; i3 <= n2; ++i3) {
                if (!this.serverRunning) {
                    return;
                }
                this.world.u.d((this.world.l >> 4) + i2, (this.world.n >> 4) + i3);
            }
        }
        this.clearCurrentTask();
    }

    private void outputPercentRemaining(String string, int n2) {
        this.currentTask = string;
        this.percentDone = n2;
        System.out.println(string + ": " + n2 + "%");
    }

    private void clearCurrentTask() {
        this.currentTask = null;
        this.percentDone = 0;
    }

    private void saveServerWorld() {
        log.info("Saving chunks");
        this.world.a(true, null);
    }

    private void stopServer() {
        log.info("Stopping server");
        if (this.world != null) {
            this.saveServerWorld();
        }
    }

    public void a() {
        this.serverRunning = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        try {
            if (this.startServer()) {
                long l2 = System.currentTimeMillis();
                long l3 = 0L;
                while (this.serverRunning) {
                    long l4 = System.currentTimeMillis();
                    long l5 = l4 - l2;
                    if (l5 > 2000L) {
                        log.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        l5 = 2000L;
                    }
                    if (l5 < 0L) {
                        log.warning("Time ran backwards! Did the system time change?");
                        l5 = 0L;
                    }
                    l3 += l5;
                    l2 = l4;
                    while (l3 > 50L) {
                        l3 -= 50L;
                        this.doTick();
                    }
                    Thread.sleep(1L);
                }
            } else {
                while (this.serverRunning) {
                    this.commandLineParser();
                    try {
                        Thread.sleep(10L);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }
        catch (Exception exception) {
            log.log(Level.SEVERE, "Unexpected exception", exception);
            while (this.serverRunning) {
                this.commandLineParser();
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
        finally {
            this.stopServer();
            this.serverStopped = true;
            System.exit(0);
        }
    }

    private void doTick() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Iterator iterator = hashStory.keySet().iterator(); iterator.hasNext();) {
        	String s = (String)iterator.next();
            int n3 = ((Integer)hashStory.get(s)).intValue();
            if (n3 > 0) {
                hashStory.put(s, n3 - 1);
                continue;
            }
            arrayList.add(s);
        }
        for (int i = 0; i < arrayList.size(); ++i) {
            hashStory.remove(arrayList.get(i));
        }
        AxisAlignedBB.a();
        Vec3D.a();
        ++this.deathTime;
        this.world.e();
        while (this.world.c()) {
        }
        this.world.b();
        this.networkListener.a();
        this.configManager.b();
        this.entityTracker.a();
        for (int i = 0; i < this.playerListBoxes.size(); ++i) {
            ((IUpdatePlayerListBox)this.playerListBoxes.get(i)).a();
        }
        try {
            this.commandLineParser();
        }
        catch (Exception exception) {
            log.log(Level.WARNING, "Unexpected exception while parsing console command", exception);
        }
    }

    public void a(String string) {
        this.commands.add(string);
    }

    public void commandLineParser() {
        while (this.commands.size() > 0) {
            EntityPlayerMP entityplayermp;
            String[] arrstring;
            EntityPlayerMP entityplayermp2;
            String string = (String)this.commands.remove(0);
            if (string.toLowerCase().startsWith("help") || string.toLowerCase().startsWith("?")) {
                log.info("To run the server without a gui, start it like this:");
                log.info("   java -Xmx1024M -Xms1024M -jar minecraft_server.jar nogui");
                log.info("Console commands:");
                log.info("   help  or  ?          shows this message");
                log.info("   kick <player>        removes a player from the server");
                log.info("   give <player> <id>   gives a player a resource");
                log.info("   stop                 gracefully stops the server");
                log.info("   list                 lists all currently connected players");
                log.info("   say <message>        broadcasts a message to all players");
                continue;
            }
            if (string.toLowerCase().startsWith("list")) {
                log.info("Connected players: " + this.configManager.c());
                continue;
            }
            if (string.toLowerCase().startsWith("stop")) {
                this.serverRunning = false;
                continue;
            }
            if (string.toLowerCase().startsWith("kick ")) {
                String nickToKick = string.substring(string.indexOf(" ")).trim();
                entityplayermp = null;
                for (int i2 = 0; i2 < this.configManager.playerEntities.size(); ++i2) {
                    entityplayermp2 = (EntityPlayerMP)this.configManager.playerEntities.get(i2);
                    if (!entityplayermp2.ap.equalsIgnoreCase(nickToKick)) continue;
                    entityplayermp = entityplayermp2;
                }
                if (entityplayermp != null) {
                    entityplayermp.a.b("Kicked by admin");
                    log.log(Level.INFO, "Kicking " + entityplayermp.ap);
                    continue;
                }
                log.log(Level.INFO, "Can't find user " + nickToKick + ". No kick.");
                continue;
            }
            if (string.toLowerCase().startsWith("give ")) {
                arrstring = string.split(" ");
                if (arrstring.length != 3) {
                    return;
                }
                String nickToGive = arrstring[1];
                EntityPlayerMP entityplayermp3 = null;
                for (int i = 0; i < this.configManager.playerEntities.size(); ++i) {
                    EntityPlayerMP entityplayermp4 = (EntityPlayerMP)this.configManager.playerEntities.get(i);
                    if (!entityplayermp4.ap.equalsIgnoreCase(nickToGive)) continue;
                    entityplayermp3 = entityplayermp4;
                }
                if (entityplayermp3 != null) {
                    try {
                        int itemID = Integer.parseInt(arrstring[2]);
                        if (en.c[itemID] != null) {
                            log.log(Level.INFO, "Giving " + entityplayermp3.ap + " some " + itemID);
                            entityplayermp3.a(new gc(itemID, 1));
                            continue;
                        }
                        log.log(Level.INFO, "There's no item with id " + itemID);
                    }
                    catch (NumberFormatException numberFormatException) {
                        log.log(Level.INFO, "There's no item with id " + arrstring[2]);
                    }
                    continue;
                }
                log.log(Level.INFO, "Can't find user " + nickToGive);
                continue;
            }
            if (string.toLowerCase().startsWith("say ")) {
                string = string.substring(string.indexOf(" ")).trim();
                log.info("[Server] " + string);
                this.configManager.a(new Packet3Chat("\u00a7d[Server] " + string));
                continue;
            }
            log.warning("Unknown console command. Type \"help\" for help.");
        }
    }

    public void addPlayerListBox(IUpdatePlayerListBox dn2) {
        this.playerListBoxes.add(dn2);
    }

    public static void main(String[] arrstring) {
        try {
            MinecraftServer minecraftserver = new MinecraftServer();
            if (!(GraphicsEnvironment.isHeadless() || arrstring.length > 0 && arrstring[0].equals("nogui"))) {
                ServerGUI.initGui(minecraftserver);
            }
            new ThreadServerApplication("Server thread", minecraftserver).start();
        }
        catch (Exception exception) {
            log.log(Level.SEVERE, "Failed to start the minecraft server", exception);
        }
    }

    public static boolean a(MinecraftServer minecraftServer) {
        return minecraftServer.serverRunning;
    }

    public static boolean a(MinecraftServer minecraftServer, boolean bl2) {
        minecraftServer.serverRunning = bl2;
        return minecraftServer.serverRunning;
    }
}

