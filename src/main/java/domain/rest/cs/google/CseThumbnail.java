package domain.rest.cs.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "width",
        "height",
        "src"
})
public class CseThumbnail {

    @JsonProperty("width")
    private String width;
    @JsonProperty("height")
    private String height;
    @JsonProperty("src")
    private String src;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The width
     */
    @JsonProperty("width")
    public String getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    @JsonProperty("width")
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The src
     */
    @JsonProperty("src")
    public String getSrc() {
        return src;
    }

    /**
     *
     * @param src
     * The src
     */
    @JsonProperty("src")
    public void setSrc(String src) {
        this.src = src;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CseThumbnail{" +
                "width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", src='" + src + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}