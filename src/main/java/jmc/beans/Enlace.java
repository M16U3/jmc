/*
 * 
 * 
 * 
 */
package jmc.beans;

/**
 *
 * @author miguel
 */
import java.io.Serializable;
import java.util.List;

public class Enlace implements Serializable {
    
    private String url;
    private List<String> tags;

    public Enlace() {
    }

    public Enlace(String url, List<String> tags) {
        this.url = url;
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
}
