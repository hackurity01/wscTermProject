package domain.rest.cs.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "totalResults",
        "searchTerms",
        "count",
        "startIndex",
        "inputEncoding",
        "outputEncoding",
        "safe",
        "cx"
})
public class NextPage {

    @JsonProperty("title")
    private String title;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("searchTerms")
    private String searchTerms;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("startIndex")
    private Integer startIndex;
    @JsonProperty("inputEncoding")
    private String inputEncoding;
    @JsonProperty("outputEncoding")
    private String outputEncoding;
    @JsonProperty("safe")
    private String safe;
    @JsonProperty("cx")
    private String cx;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The totalResults
     */
    @JsonProperty("totalResults")
    public String getTotalResults() {
        return totalResults;
    }

    /**
     *
     * @param totalResults
     * The totalResults
     */
    @JsonProperty("totalResults")
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    /**
     *
     * @return
     * The searchTerms
     */
    @JsonProperty("searchTerms")
    public String getSearchTerms() {
        return searchTerms;
    }

    /**
     *
     * @param searchTerms
     * The searchTerms
     */
    @JsonProperty("searchTerms")
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    /**
     *
     * @return
     * The count
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The startIndex
     */
    @JsonProperty("startIndex")
    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     *
     * @param startIndex
     * The startIndex
     */
    @JsonProperty("startIndex")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    /**
     *
     * @return
     * The inputEncoding
     */
    @JsonProperty("inputEncoding")
    public String getInputEncoding() {
        return inputEncoding;
    }

    /**
     *
     * @param inputEncoding
     * The inputEncoding
     */
    @JsonProperty("inputEncoding")
    public void setInputEncoding(String inputEncoding) {
        this.inputEncoding = inputEncoding;
    }

    /**
     *
     * @return
     * The outputEncoding
     */
    @JsonProperty("outputEncoding")
    public String getOutputEncoding() {
        return outputEncoding;
    }

    /**
     *
     * @param outputEncoding
     * The outputEncoding
     */
    @JsonProperty("outputEncoding")
    public void setOutputEncoding(String outputEncoding) {
        this.outputEncoding = outputEncoding;
    }

    /**
     *
     * @return
     * The safe
     */
    @JsonProperty("safe")
    public String getSafe() {
        return safe;
    }

    /**
     *
     * @param safe
     * The safe
     */
    @JsonProperty("safe")
    public void setSafe(String safe) {
        this.safe = safe;
    }

    /**
     *
     * @return
     * The cx
     */
    @JsonProperty("cx")
    public String getCx() {
        return cx;
    }

    /**
     *
     * @param cx
     * The cx
     */
    @JsonProperty("cx")
    public void setCx(String cx) {
        this.cx = cx;
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
        return "NextPage{" +
                "title='" + title + '\'' +
                ", totalResults='" + totalResults + '\'' +
                ", searchTerms='" + searchTerms + '\'' +
                ", count=" + count +
                ", startIndex=" + startIndex +
                ", inputEncoding='" + inputEncoding + '\'' +
                ", outputEncoding='" + outputEncoding + '\'' +
                ", safe='" + safe + '\'' +
                ", cx='" + cx + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}