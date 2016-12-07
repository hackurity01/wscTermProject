package domain.daum.knowledge;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pubDate",
        "title",
        "category",
        "answerCount",
        "description",
        "link"
})
public class Item {

    @JsonProperty("pubDate")
    private String pubDate;
    @JsonProperty("title")
    private String title;
    @JsonProperty("category")
    private String category;
    @JsonProperty("answerCount")
    private String answerCount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The pubDate
     */
    @JsonProperty("pubDate")
    public String getPubDate() {
        return pubDate;
    }

    /**
     *
     * @param pubDate
     * The pubDate
     */
    @JsonProperty("pubDate")
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

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
     * The category
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The answerCount
     */
    @JsonProperty("answerCount")
    public String getAnswerCount() {
        return answerCount;
    }

    /**
     *
     * @param answerCount
     * The answerCount
     */
    @JsonProperty("answerCount")
    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    /**
     *
     * @return
     * The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
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
        return "Item{" +
                "pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", answerCount='" + answerCount + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}