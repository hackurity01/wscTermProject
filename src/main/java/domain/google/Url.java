package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "template"
})
public class Url {

    @JsonProperty("type")
    private String type;
    @JsonProperty("template")
    private String template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The template
     */
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    /**
     *
     * @param template
     * The template
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
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
        return "Url{" +
                "type='" + type + '\'' +
                ", template='" + template + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}