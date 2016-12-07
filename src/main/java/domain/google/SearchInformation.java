package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "searchTime",
        "formattedSearchTime",
        "totalResults",
        "formattedTotalResults"
})
public class SearchInformation {

    @JsonProperty("searchTime")
    private Double searchTime;
    @JsonProperty("formattedSearchTime")
    private String formattedSearchTime;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("formattedTotalResults")
    private String formattedTotalResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The searchTime
     */
    @JsonProperty("searchTime")
    public Double getSearchTime() {
        return searchTime;
    }

    /**
     *
     * @param searchTime
     * The searchTime
     */
    @JsonProperty("searchTime")
    public void setSearchTime(Double searchTime) {
        this.searchTime = searchTime;
    }

    /**
     *
     * @return
     * The formattedSearchTime
     */
    @JsonProperty("formattedSearchTime")
    public String getFormattedSearchTime() {
        return formattedSearchTime;
    }

    /**
     *
     * @param formattedSearchTime
     * The formattedSearchTime
     */
    @JsonProperty("formattedSearchTime")
    public void setFormattedSearchTime(String formattedSearchTime) {
        this.formattedSearchTime = formattedSearchTime;
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
     * The formattedTotalResults
     */
    @JsonProperty("formattedTotalResults")
    public String getFormattedTotalResults() {
        return formattedTotalResults;
    }

    /**
     *
     * @param formattedTotalResults
     * The formattedTotalResults
     */
    @JsonProperty("formattedTotalResults")
    public void setFormattedTotalResults(String formattedTotalResults) {
        this.formattedTotalResults = formattedTotalResults;
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
        return "SearchInformation{" +
                "searchTime=" + searchTime +
                ", formattedSearchTime='" + formattedSearchTime + '\'' +
                ", totalResults='" + totalResults + '\'' +
                ", formattedTotalResults='" + formattedTotalResults + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}