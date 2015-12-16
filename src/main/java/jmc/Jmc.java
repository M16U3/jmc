/*
 * 
 * 
 * 
 */
package jmc;

/**
 *
 * @author miguel
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.json.JSONArray;
import jmc.proc.Jmcrawl;
import jmc.util.ConfigPropiedades;
import jmc.util.Convertidor;
import jmc.exception.JMCException;

public class Jmc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String opcion;
        opcion = args != null ? (args[0]).toLowerCase() : "xml";

        if (opcion != null) {
            try {
                Properties props = ConfigPropiedades.getProperties("props_config.properties");
                String sitio = props.getProperty("sitio");
                Jmcrawl.props = props;

                switch (opcion) {
                    case "json":

                        try {
                            JSONArray arn = Convertidor.JSON(Jmcrawl.contenido(Jmcrawl.enlaces(sitio)));

                            PrintWriter f = null;

                            if (args != null && args.length == 2 && args[1] != null) {
                                f = new PrintWriter(args[1]);
                            }

                            for (int i = 0; i < arn.length(); i++) {
                                if (f != null) {
                                    f.println(arn.get(i));
                                } else {
                                    System.out.println(arn.get(i));
                                }
                            }

                            if (f != null) {
                                f.close();
                            }

                        } catch (JMCException e) {
                            System.out.println(e);
                        }

                        break;
                    case "xml":

                        try {
                            Document doc = Convertidor.DOM(Jmcrawl.contenido(Jmcrawl.enlaces(sitio)));
                            DOMSource domSource = new DOMSource(doc);
                            StringWriter writer = new StringWriter();
                            StreamResult result = new StreamResult(writer);
                            TransformerFactory tf = TransformerFactory.newInstance();
                            Transformer transformer = tf.newTransformer();                            
                            transformer.transform(domSource, result);
                            
                            PrintWriter out = null;

                            if (args != null && args.length == 2 && args[1] != null) {
                                out = new PrintWriter(args[1]);
                                out.println(writer.toString());
                            } else {
                                System.out.println(writer.toString());
                            }

                            writer.close();

                        } catch (TransformerException e) {
                            System.out.println(e);
                        } catch (JMCException e) {
                            System.out.println(e);
                        }
                        break;
                    default:
                        System.out.println("USAR: java -jar jmc.jar [<default> json|xml] (opcional) archivoDestino ...");
                        break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("USAR: java -jar jmc.jar [<default> json|xml] (opcional) archivoDestino ...");
        }

    }

}
