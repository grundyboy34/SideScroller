package com.grundyboy34.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.grundyboy34.entities.Mob;
import com.grundyboy34.entities.Obstacle;
import com.grundyboy34.level.Grid;
import com.grundyboy34.level.Level;
import com.thoughtworks.xstream.XStream;

/**
 *
 *
 */
@SuppressWarnings("unchecked")
public final class LevelXMLHandler {
	  private static XStream xmlHandler;   

    public LevelXMLHandler() {
    
    }
    
    static {
        xmlHandler = new XStream();
        xmlHandler.alias("level", Level.class);
        xmlHandler.alias("grid", Grid.class);
        xmlHandler.alias("mob", Mob.class);
        xmlHandler.alias("obstacle", Obstacle.class);
    }

  
 

    public static void toXML(String file, Object object) throws IOException {
        OutputStream out = new FileOutputStream(file);
        try {
            xmlHandler.toXML(object, out);
            out.flush();
        } finally {
            out.close();
        }
    }

    public static <T> T fromXML(String file) throws IOException {
        InputStream in = new FileInputStream(file);
        try {
            return (T) xmlHandler.fromXML(in);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return null;
    }
}
