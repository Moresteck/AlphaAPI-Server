/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLogManager {
    public static Logger log = Logger.getLogger("Minecraft");

    public static void init() {
        ConsoleLogFormatter gj2 = new ConsoleLogFormatter();
        log.setUseParentHandlers(false);
        ConsoleHandler consolehandler = new ConsoleHandler();
        consolehandler.setFormatter(gj2);
        log.addHandler(consolehandler);
        try {
            FileHandler fileHandler = new FileHandler("server.log");
            fileHandler.setFormatter(gj2);
            log.addHandler(fileHandler);
        }
        catch (Exception exception) {
            log.log(Level.WARNING, "Failed to log to server.log", exception);
        }
    }
}

