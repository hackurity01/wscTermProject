package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kind",
        "url",
        "queries",
        "context",
        "searchInformation",
        "items"
})
public class GoogleSearch {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("url")
    private Url url;
    @JsonProperty("queries")
    private Queries queries;
    @JsonProperty("context")
    private Context context;
    @JsonProperty("searchInformation")
    private SearchInformation searchInformation;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The kind
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     *
     * @param kind
     * The kind
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     *
     * @return
     * The url
     */
    @JsonProperty("url")
    public Url getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    @JsonProperty("url")
    public void setUrl(Url url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The queries
     */
    @JsonProperty("queries")
    public Queries getQueries() {
        return queries;
    }

    /**
     *
     * @param queries
     * The queries
     */
    @JsonProperty("queries")
    public void setQueries(Queries queries) {
        this.queries = queries;
    }

    /**
     *
     * @return
     * The context
     */
    @JsonProperty("context")
    public Context getContext() {
        return context;
    }

    /**
     *
     * @param context
     * The context
     */
    @JsonProperty("context")
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     *
     * @return
     * The searchInformation
     */
    @JsonProperty("searchInformation")
    public SearchInformation getSearchInformation() {
        return searchInformation;
    }

    /**
     *
     * @param searchInformation
     * The searchInformation
     */
    @JsonProperty("searchInformation")
    public void setSearchInformation(SearchInformation searchInformation) {
        this.searchInformation = searchInformation;
    }

    /**
     *
     * @return
     * The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
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
        return "GoogleSearch{" +
                "kind='" + kind + '\'' +
                ", url=" + url +
                ", queries=" + queries +
                ", context=" + context +
                ", searchInformation=" + searchInformation +
                ", items=" + items +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}