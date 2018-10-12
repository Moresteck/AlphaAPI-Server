/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyManager {
    public static Logger log = Logger.getLogger("Minecraft");
    private Properties properties = new Properties();
    private File serverPropertiesFile;

    public PropertyManager(File file) {
        this.serverPropertiesFile = file;
        if (file.exists()) {
            try {
                this.properties.load(new FileInputStream(file));
                for (Object k2 : this.properties.keySet()) {
                    System.out.println(k2 + ":" + this.properties.get(k2));
                }
            }
            catch (Exception exception) {
                log.log(Level.WARNING, "Failed to load " + file, exception);
                this.generateNewProperties();
            }
        } else {
            log.log(Level.WARNING, file + " does not exist");
            this.generateNewProperties();
        }
    }

    public void generateNewProperties() {
        log.log(Level.INFO, "Generating new properties file");
        this.saveProperties();
    }

    public void saveProperties() {
        try {
            this.properties.store(new FileOutputStream(this.serverPropertiesFile), "Minecraft server properties");
        }
        catch (Exception exception) {
            log.log(Level.WARNING, "Failed to save " + this.serverPropertiesFile, exception);
            this.generateNewProperties();
        }
    }

    public String getStringProperty(String string, String string2) {
        System.out.println("Getting " + string);
        if (!this.properties.containsKey(string)) {
            System.out.println("Nope!");
            this.properties.setProperty(string, string2);
            this.saveProperties();
        }
        System.out.println("Yep: " + this.properties.getProperty(string, string2));
        return this.properties.getProperty(string, string2);
    }

    public int getIntProperty(String string, int n2) {
        try {
            return Integer.parseInt(this.getStringProperty(string, "" + n2));
        }
        catch (Exception exception) {
            this.properties.setProperty(string, "" + n2);
            return n2;
        }
    }
}

