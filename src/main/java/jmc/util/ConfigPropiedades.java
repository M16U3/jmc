/* 
 * 
 * 
 * 
 * 
 */
package jmc.util;

/**
 *
 * @author miguel
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public final class ConfigPropiedades {
        
    public static Properties getProperties(String archivo) throws IOException {
        Properties props = new Properties();
        InputStream in = new FileInputStream(new File(archivo));
        props.load(in);
        in.close();
     return props;
    }
    
}
