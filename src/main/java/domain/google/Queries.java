package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "request",
        "nextPage"
})
public class Queries {

    @JsonProperty("request")
    private List<Request> request = null;
    @JsonProperty("nextPage")
    private List<NextPage> nextPage = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The request
     */
    @JsonProperty("request")
    public List<Request> getRequest() {
        return request;
    }

    /**
     *
     * @param request
     * The request
     */
    @JsonProperty("request")
    public void setRequest(List<Request> request) {
        this.request = request;
    }

    /**
     *
     * @return
     * The nextPage
     */
    @JsonProperty("nextPage")
    public List<NextPage> getNextPage() {
        return nextPage;
    }

    /**
     *
     * @param nextPage
     * The nextPage
     */
    @JsonProperty("nextPage")
    public void setNextPage(List<NextPage> nextPage) {
        this.nextPage = nextPage;
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
        return "Queries{" +
                "request=" + request +
                ", nextPage=" + nextPage +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}