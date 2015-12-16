/*
 * 
 * 
 * 
 */
package jmc.util;

/**
 *
 * @author miguel
 */
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.json.JSONObject;
import org.json.JSONArray;
import jmc.beans.Contenido;
import jmc.exception.JMCException;

public class Convertidor {

    public static JSONArray JSON(List<Contenido> lc) {

        JSONArray nar = new JSONArray();

        for (Contenido c : lc) {
            JSONObject jo = new JSONObject();
            jo.put("Enlace", c.getEnlace().getUrl());
            jo.put("Tags", c.getEnlace().getTags());
            jo.put("Titulo", c.getTitulo().trim());
            jo.put("Contenido", c.getContenido().trim());
            jo.put("Autor", c.getAutor().trim());
            jo.put("Fecha", c.getFecha().trim());
            nar.put(jo);
        }

        return nar;
    }

    public static Document DOM(List<Contenido> lc) throws JMCException {

        Document doc = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            
            Element root = doc.createElement("Noticias");            
            
            for (Contenido c : lc) {
                Element e = doc.createElement("Enlace");
                e.setAttribute("url", c.getEnlace().getUrl());
                
                Element tags = doc.createElement("Tags");
                for (String tg : c.getEnlace().getTags()) {
                    Element t = doc.createElement("Tag");
                    t.setTextContent(tg);
                    tags.appendChild(t);
                }
                e.appendChild(tags);
                
                Element tit = doc.createElement("Titulo");
                tit.setTextContent(c.getTitulo().trim());
                
                Element cont = doc.createElement("Contenido");
                cont.setTextContent(c.getContenido().trim());
                cont.setAttribute("Autor", c.getAutor().trim());
                cont.setAttribute("Fecha", c.getFecha().trim());
                e.appendChild(tit);
                e.appendChild(cont);
                
                root.appendChild(e);                
            }
            doc.appendChild(root);
            
        } catch (ParserConfigurationException e) {
            throw new JMCException(e);
        }

        return doc;
    }

}
