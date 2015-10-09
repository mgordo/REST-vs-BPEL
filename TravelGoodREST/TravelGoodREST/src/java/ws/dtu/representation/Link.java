package ws.dtu.representation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Link {

    private String mediaType;
    private String uri;
    private String rel;

    @XmlAttribute
    public String getUri() {
        return uri;
    }

    public void setUri(String href) {
        this.uri = href;
    }

    @XmlAttribute
    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @XmlAttribute
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

}
