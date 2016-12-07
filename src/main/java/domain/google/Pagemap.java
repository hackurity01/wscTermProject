package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cse_thumbnail",
        "metatags",
        "cse_image",
        "webpage",
        "breadcrumb"
})
public class Pagemap {

    @JsonProperty("cse_thumbnail")
    private List<CseThumbnail> cseThumbnail = null;
    @JsonProperty("metatags")
    private List<Metatag> metatags = null;
    @JsonProperty("cse_image")
    private List<CseImage> cseImage = null;
    @JsonProperty("webpage")
    private List<Webpage> webpage = null;
    @JsonProperty("breadcrumb")
    private List<Breadcrumb> breadcrumb = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The cseThumbnail
     */
    @JsonProperty("cse_thumbnail")
    public List<CseThumbnail> getCseThumbnail() {
        return cseThumbnail;
    }

    /**
     *
     * @param cseThumbnail
     * The cse_thumbnail
     */
    @JsonProperty("cse_thumbnail")
    public void setCseThumbnail(List<CseThumbnail> cseThumbnail) {
        this.cseThumbnail = cseThumbnail;
    }

    /**
     *
     * @return
     * The metatags
     */
    @JsonProperty("metatags")
    public List<Metatag> getMetatags() {
        return metatags;
    }

    /**
     *
     * @param metatags
     * The metatags
     */
    @JsonProperty("metatags")
    public void setMetatags(List<Metatag> metatags) {
        this.metatags = metatags;
    }

    /**
     *
     * @return
     * The cseImage
     */
    @JsonProperty("cse_image")
    public List<CseImage> getCseImage() {
        return cseImage;
    }

    /**
     *
     * @param cseImage
     * The cse_image
     */
    @JsonProperty("cse_image")
    public void setCseImage(List<CseImage> cseImage) {
        this.cseImage = cseImage;
    }

    /**
     *
     * @return
     * The webpage
     */
    @JsonProperty("webpage")
    public List<Webpage> getWebpage() {
        return webpage;
    }

    /**
     *
     * @param webpage
     * The webpage
     */
    @JsonProperty("webpage")
    public void setWebpage(List<Webpage> webpage) {
        this.webpage = webpage;
    }

    /**
     *
     * @return
     * The breadcrumb
     */
    @JsonProperty("breadcrumb")
    public List<Breadcrumb> getBreadcrumb() {
        return breadcrumb;
    }

    /**
     *
     * @param breadcrumb
     * The breadcrumb
     */
    @JsonProperty("breadcrumb")
    public void setBreadcrumb(List<Breadcrumb> breadcrumb) {
        this.breadcrumb = breadcrumb;
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
        return "Pagemap{" +
                "cseThumbnail=" + cseThumbnail +
                ", metatags=" + metatags +
                ", cseImage=" + cseImage +
                ", webpage=" + webpage +
                ", breadcrumb=" + breadcrumb +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}