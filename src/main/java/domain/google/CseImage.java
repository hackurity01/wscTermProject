package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "src"
})
public class CseImage {

    @JsonProperty("src")
    private String src;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
        return "CseImage{" +
                "src='" + src + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}