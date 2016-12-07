package domain.naver.blog;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "link",
        "description",
        "bloggername",
        "bloggerlink",
        "postdate"
})
public class Item {

    @JsonProperty("title")
    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("description")
    private String description;
    @JsonProperty("bloggername")
    private String bloggername;
    @JsonProperty("bloggerlink")
    private String bloggerlink;
    @JsonProperty("postdate")
    private String postdate;
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
     * The bloggername
     */
    @JsonProperty("bloggername")
    public String getBloggername() {
        return bloggername;
    }

    /**
     *
     * @param bloggername
     * The bloggername
     */
    @JsonProperty("bloggername")
    public void setBloggername(String bloggername) {
        this.bloggername = bloggername;
    }

    /**
     *
     * @return
     * The bloggerlink
     */
    @JsonProperty("bloggerlink")
    public String getBloggerlink() {
        return bloggerlink;
    }

    /**
     *
     * @param bloggerlink
     * The bloggerlink
     */
    @JsonProperty("bloggerlink")
    public void setBloggerlink(String bloggerlink) {
        this.bloggerlink = bloggerlink;
    }

    /**
     *
     * @return
     * The postdate
     */
    @JsonProperty("postdate")
    public String getPostdate() {
        return postdate;
    }

    /**
     *
     * @param postdate
     * The postdate
     */
    @JsonProperty("postdate")
    public void setPostdate(String postdate) {
        this.postdate = postdate;
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
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", bloggername='" + bloggername + '\'' +
                ", bloggerlink='" + bloggerlink + '\'' +
                ", postdate='" + postdate + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}