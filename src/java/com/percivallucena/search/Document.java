
package com.percivallucena.search;

import javax.persistence.Entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author plucena
 */



public class Document {

  
    private int pageID;
    private String content;

    public Document() {}
    
    public Document(String content){
        this.pageID = Generator.getId();
        this.content = content;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }
   
    public int getPageID() {
        return pageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
