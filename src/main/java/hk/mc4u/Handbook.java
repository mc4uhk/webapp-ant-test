package hk.mc4u;



import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@Data
public class Handbook {
    private Long id;
    private String name;
    private String author;
    private Date date;
    private String isdn;
    private int numPage;
    private String revision;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "title")
    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // constructor, getters and setters
}