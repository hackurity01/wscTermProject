package domain.rest.cs.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kind",
        "title",
        "htmlTitle",
        "link",
        "displayLink",
        "snippet",
        "htmlSnippet",
        "cacheId",
        "formattedUrl",
        "htmlFormattedUrl",
        "pagemap"
})
public class Item {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("title")
    private String title;
    @JsonProperty("htmlTitle")
    private String htmlTitle;
    @JsonProperty("link")
    private String link;
    @JsonProperty("displayLink")
    private String displayLink;
    @JsonProperty("snippet")
    private String snippet;
    @JsonProperty("htmlSnippet")
    private String htmlSnippet;
    @JsonProperty("cacheId")
    private String cacheId;
    @JsonProperty("formattedUrl")
    private String formattedUrl;
    @JsonProperty("htmlFormattedUrl")
    private String htmlFormattedUrl;
    @JsonProperty("pagemap")
    private Pagemap pagemap;
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
     * The htmlTitle
     */
    @JsonProperty("htmlTitle")
    public String getHtmlTitle() {
        return htmlTitle;
    }

    /**
     *
     * @param htmlTitle
     * The htmlTitle
     */
    @JsonProperty("htmlTitle")
    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
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

    /**
     *
     * @return
     * The displayLink
     */
    @JsonProperty("displayLink")
    public String getDisplayLink() {
        return displayLink;
    }

    /**
     *
     * @param displayLink
     * The displayLink
     */
    @JsonProperty("displayLink")
    public void setDisplayLink(String displayLink) {
        this.displayLink = displayLink;
    }

    /**
     *
     * @return
     * The snippet
     */
    @JsonProperty("snippet")
    public String getSnippet() {
        return snippet;
    }

    /**
     *
     * @param snippet
     * The snippet
     */
    @JsonProperty("snippet")
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     *
     * @return
     * The htmlSnippet
     */
    @JsonProperty("htmlSnippet")
    public String getHtmlSnippet() {
        return htmlSnippet;
    }

    /**
     *
     * @param htmlSnippet
     * The htmlSnippet
     */
    @JsonProperty("htmlSnippet")
    public void setHtmlSnippet(String htmlSnippet) {
        this.htmlSnippet = htmlSnippet;
    }

    /**
     *
     * @return
     * The cacheId
     */
    @JsonProperty("cacheId")
    public String getCacheId() {
        return cacheId;
    }

    /**
     *
     * @param cacheId
     * The cacheId
     */
    @JsonProperty("cacheId")
    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }

    /**
     *
     * @return
     * The formattedUrl
     */
    @JsonProperty("formattedUrl")
    public String getFormattedUrl() {
        return formattedUrl;
    }

    /**
     *
     * @param formattedUrl
     * The formattedUrl
     */
    @JsonProperty("formattedUrl")
    public void setFormattedUrl(String formattedUrl) {
        this.formattedUrl = formattedUrl;
    }

    /**
     *
     * @return
     * The htmlFormattedUrl
     */
    @JsonProperty("htmlFormattedUrl")
    public String getHtmlFormattedUrl() {
        return htmlFormattedUrl;
    }

    /**
     *
     * @param htmlFormattedUrl
     * The htmlFormattedUrl
     */
    @JsonProperty("htmlFormattedUrl")
    public void setHtmlFormattedUrl(String htmlFormattedUrl) {
        this.htmlFormattedUrl = htmlFormattedUrl;
    }

    /**
     *
     * @return
     * The pagemap
     */
    @JsonProperty("pagemap")
    public Pagemap getPagemap() {
        return pagemap;
    }

    /**
     *
     * @param pagemap
     * The pagemap
     */
    @JsonProperty("pagemap")
    public void setPagemap(Pagemap pagemap) {
        this.pagemap = pagemap;
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
                "kind='" + kind + '\'' +
                ", title='" + title + '\'' +
                ", htmlTitle='" + htmlTitle + '\'' +
                ", link='" + link + '\'' +
                ", displayLink='" + displayLink + '\'' +
                ", snippet='" + snippet + '\'' +
                ", htmlSnippet='" + htmlSnippet + '\'' +
                ", cacheId='" + cacheId + '\'' +
                ", formattedUrl='" + formattedUrl + '\'' +
                ", htmlFormattedUrl='" + htmlFormattedUrl + '\'' +
                ", pagemap=" + pagemap +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}