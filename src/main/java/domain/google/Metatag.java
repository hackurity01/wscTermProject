package domain.google;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "referrer",
        "viewport",
        "og:image",
        "og:site_name",
        "og:description",
        "og:title",
        "twitter:site",
        "twitter:card",
        "twitter:title",
        "og:url",
        "og:type",
        "twitter:image",
        "twitter:url",
        "fb:admins",
        "fb:app_id",
        "msvalidate.01",
        "stripe-key",
        "csrf-param",
        "csrf-token"
})
public class Metatag {

    @JsonProperty("referrer")
    private String referrer;
    @JsonProperty("viewport")
    private String viewport;
    @JsonProperty("og:image")
    private String ogImage;
    @JsonProperty("og:site_name")
    private String ogSiteName;
    @JsonProperty("og:description")
    private String ogDescription;
    @JsonProperty("og:title")
    private String ogTitle;
    @JsonProperty("twitter:site")
    private String twitterSite;
    @JsonProperty("twitter:card")
    private String twitterCard;
    @JsonProperty("twitter:title")
    private String twitterTitle;
    @JsonProperty("og:url")
    private String ogUrl;
    @JsonProperty("og:type")
    private String ogType;
    @JsonProperty("twitter:image")
    private String twitterImage;
    @JsonProperty("twitter:url")
    private String twitterUrl;
    @JsonProperty("fb:admins")
    private String fbAdmins;
    @JsonProperty("fb:app_id")
    private String fbAppId;
    @JsonProperty("msvalidate.01")
    private String msvalidate01;
    @JsonProperty("stripe-key")
    private String stripeKey;
    @JsonProperty("csrf-param")
    private String csrfParam;
    @JsonProperty("csrf-token")
    private String csrfToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The referrer
     */
    @JsonProperty("referrer")
    public String getReferrer() {
        return referrer;
    }

    /**
     *
     * @param referrer
     * The referrer
     */
    @JsonProperty("referrer")
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    /**
     *
     * @return
     * The viewport
     */
    @JsonProperty("viewport")
    public String getViewport() {
        return viewport;
    }

    /**
     *
     * @param viewport
     * The viewport
     */
    @JsonProperty("viewport")
    public void setViewport(String viewport) {
        this.viewport = viewport;
    }

    /**
     *
     * @return
     * The ogImage
     */
    @JsonProperty("og:image")
    public String getOgImage() {
        return ogImage;
    }

    /**
     *
     * @param ogImage
     * The og:image
     */
    @JsonProperty("og:image")
    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    /**
     *
     * @return
     * The ogSiteName
     */
    @JsonProperty("og:site_name")
    public String getOgSiteName() {
        return ogSiteName;
    }

    /**
     *
     * @param ogSiteName
     * The og:site_name
     */
    @JsonProperty("og:site_name")
    public void setOgSiteName(String ogSiteName) {
        this.ogSiteName = ogSiteName;
    }

    /**
     *
     * @return
     * The ogDescription
     */
    @JsonProperty("og:description")
    public String getOgDescription() {
        return ogDescription;
    }

    /**
     *
     * @param ogDescription
     * The og:description
     */
    @JsonProperty("og:description")
    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    /**
     *
     * @return
     * The ogTitle
     */
    @JsonProperty("og:title")
    public String getOgTitle() {
        return ogTitle;
    }

    /**
     *
     * @param ogTitle
     * The og:title
     */
    @JsonProperty("og:title")
    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    /**
     *
     * @return
     * The twitterSite
     */
    @JsonProperty("twitter:site")
    public String getTwitterSite() {
        return twitterSite;
    }

    /**
     *
     * @param twitterSite
     * The twitter:site
     */
    @JsonProperty("twitter:site")
    public void setTwitterSite(String twitterSite) {
        this.twitterSite = twitterSite;
    }

    /**
     *
     * @return
     * The twitterCard
     */
    @JsonProperty("twitter:card")
    public String getTwitterCard() {
        return twitterCard;
    }

    /**
     *
     * @param twitterCard
     * The twitter:card
     */
    @JsonProperty("twitter:card")
    public void setTwitterCard(String twitterCard) {
        this.twitterCard = twitterCard;
    }

    /**
     *
     * @return
     * The twitterTitle
     */
    @JsonProperty("twitter:title")
    public String getTwitterTitle() {
        return twitterTitle;
    }

    /**
     *
     * @param twitterTitle
     * The twitter:title
     */
    @JsonProperty("twitter:title")
    public void setTwitterTitle(String twitterTitle) {
        this.twitterTitle = twitterTitle;
    }

    /**
     *
     * @return
     * The ogUrl
     */
    @JsonProperty("og:url")
    public String getOgUrl() {
        return ogUrl;
    }

    /**
     *
     * @param ogUrl
     * The og:url
     */
    @JsonProperty("og:url")
    public void setOgUrl(String ogUrl) {
        this.ogUrl = ogUrl;
    }

    /**
     *
     * @return
     * The ogType
     */
    @JsonProperty("og:type")
    public String getOgType() {
        return ogType;
    }

    /**
     *
     * @param ogType
     * The og:type
     */
    @JsonProperty("og:type")
    public void setOgType(String ogType) {
        this.ogType = ogType;
    }

    /**
     *
     * @return
     * The twitterImage
     */
    @JsonProperty("twitter:image")
    public String getTwitterImage() {
        return twitterImage;
    }

    /**
     *
     * @param twitterImage
     * The twitter:image
     */
    @JsonProperty("twitter:image")
    public void setTwitterImage(String twitterImage) {
        this.twitterImage = twitterImage;
    }

    /**
     *
     * @return
     * The twitterUrl
     */
    @JsonProperty("twitter:url")
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     *
     * @param twitterUrl
     * The twitter:url
     */
    @JsonProperty("twitter:url")
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     *
     * @return
     * The fbAdmins
     */
    @JsonProperty("fb:admins")
    public String getFbAdmins() {
        return fbAdmins;
    }

    /**
     *
     * @param fbAdmins
     * The fb:admins
     */
    @JsonProperty("fb:admins")
    public void setFbAdmins(String fbAdmins) {
        this.fbAdmins = fbAdmins;
    }

    /**
     *
     * @return
     * The fbAppId
     */
    @JsonProperty("fb:app_id")
    public String getFbAppId() {
        return fbAppId;
    }

    /**
     *
     * @param fbAppId
     * The fb:app_id
     */
    @JsonProperty("fb:app_id")
    public void setFbAppId(String fbAppId) {
        this.fbAppId = fbAppId;
    }

    /**
     *
     * @return
     * The msvalidate01
     */
    @JsonProperty("msvalidate.01")
    public String getMsvalidate01() {
        return msvalidate01;
    }

    /**
     *
     * @param msvalidate01
     * The msvalidate.01
     */
    @JsonProperty("msvalidate.01")
    public void setMsvalidate01(String msvalidate01) {
        this.msvalidate01 = msvalidate01;
    }

    /**
     *
     * @return
     * The stripeKey
     */
    @JsonProperty("stripe-key")
    public String getStripeKey() {
        return stripeKey;
    }

    /**
     *
     * @param stripeKey
     * The stripe-key
     */
    @JsonProperty("stripe-key")
    public void setStripeKey(String stripeKey) {
        this.stripeKey = stripeKey;
    }

    /**
     *
     * @return
     * The csrfParam
     */
    @JsonProperty("csrf-param")
    public String getCsrfParam() {
        return csrfParam;
    }

    /**
     *
     * @param csrfParam
     * The csrf-param
     */
    @JsonProperty("csrf-param")
    public void setCsrfParam(String csrfParam) {
        this.csrfParam = csrfParam;
    }

    /**
     *
     * @return
     * The csrfToken
     */
    @JsonProperty("csrf-token")
    public String getCsrfToken() {
        return csrfToken;
    }

    /**
     *
     * @param csrfToken
     * The csrf-token
     */
    @JsonProperty("csrf-token")
    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
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
        return "Metatag{" +
                "referrer='" + referrer + '\'' +
                ", viewport='" + viewport + '\'' +
                ", ogImage='" + ogImage + '\'' +
                ", ogSiteName='" + ogSiteName + '\'' +
                ", ogDescription='" + ogDescription + '\'' +
                ", ogTitle='" + ogTitle + '\'' +
                ", twitterSite='" + twitterSite + '\'' +
                ", twitterCard='" + twitterCard + '\'' +
                ", twitterTitle='" + twitterTitle + '\'' +
                ", ogUrl='" + ogUrl + '\'' +
                ", ogType='" + ogType + '\'' +
                ", twitterImage='" + twitterImage + '\'' +
                ", twitterUrl='" + twitterUrl + '\'' +
                ", fbAdmins='" + fbAdmins + '\'' +
                ", fbAppId='" + fbAppId + '\'' +
                ", msvalidate01='" + msvalidate01 + '\'' +
                ", stripeKey='" + stripeKey + '\'' +
                ", csrfParam='" + csrfParam + '\'' +
                ", csrfToken='" + csrfToken + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}