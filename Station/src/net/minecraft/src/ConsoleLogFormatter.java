/*
 * Decompiled with CFR 0_132.
 */
package net.minecraft.src;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class ConsoleLogFormatter
extends Formatter {
    private SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    ConsoleLogFormatter() {
    }

    public String format(LogRecord logRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.format(logRecord.getMillis()));
        Level level = logRecord.getLevel();
        if (level == Level.FINEST) {
            stringBuilder.append(" [FINEST] ");
        } else if (level == Level.FINER) {
            stringBuilder.append(" [FINER] ");
        } else if (level == Level.FINE) {
            stringBuilder.append(" [FINE] ");
        } else if (level == Level.INFO) {
            stringBuilder.append(" [INFO] ");
        } else if (level == Level.WARNING) {
            stringBuilder.append(" [WARNING] ");
        } else if (level == Level.SEVERE) {
            stringBuilder.append(" [SEVERE] ");
        } else if (level == Level.SEVERE) {
            stringBuilder.append(" [" + level.getLocalizedName() + "] ");
        }
        stringBuilder.append(logRecord.getMessage());
        stringBuilder.append('\n');
        Throwable throwable = logRecord.getThrown();
        if (throwable != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            stringBuilder.append(stringWriter.toString());
        }
        return stringBuilder.toString();
    }
}

