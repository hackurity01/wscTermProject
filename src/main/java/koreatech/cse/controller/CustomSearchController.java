package koreatech.cse.controller;

import koreatech.cse.domain.rest.cs.daum.blog.DaumBlog;
import koreatech.cse.domain.rest.cs.daum.board.DaumBoard;
import koreatech.cse.domain.rest.cs.daum.knowledge.DaumKnowledge;
import koreatech.cse.domain.rest.cs.daum.web.Web;
import koreatech.cse.domain.rest.cs.google.GoogleSearch;
import koreatech.cse.domain.rest.cs.naver.blog.Blog;
import koreatech.cse.domain.rest.cs.naver.cafearticle.CafeArticle;
import koreatech.cse.domain.rest.cs.naver.encyc.Encyc;
import koreatech.cse.domain.rest.cs.naver.kin.Kin;
import koreatech.cse.domain.rest.cs.naver.webkr.Webkr;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by feeling_x64 on 2016-12-06.
 */

@Controller
@RequestMapping("/cs")
public class CustomSearchController {
    private static final String NAVER_CLIENT_ID = "zzfxWt08wZ83tKDkkQG5";
    private static final String NAVER_CLIENT_SECRET = "uOX0hfGJU2";
    private static final String NAVER_REST_SERVICE_URI = "https://openapi.naver.com/v1/search";
    private static final String DAUM_API_KEY = "3290ef3cd3ab379e6491a313800f28e7";
    private static final String DAUM_REST_SERVICE_URI = "https://apis.daum.net/search";
    private static final String GOOGLE_REST_SERVICE_URI = "https://www.googleapis.com/customsearch/v1";
    private static final String GOOGLE_API_KEY = "AIzaSyBvjZSmEnhIbjoOS3Y5gMHtNHwOlDo1Tfo";
    private static final String GOOGLE_CX = "016904682003137614969:vx9ytdzgvoq";

    @RequestMapping("/naver")
    public String getNaver(Model model,
                                      @RequestParam(name = "searchWord") String searchWord) {
        System.out.println("Testing GET METHOD (1)----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", NAVER_CLIENT_ID);
        headers.add("X-Naver-Client-Secret", NAVER_CLIENT_SECRET);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Webkr webkr = null;
        Blog blog = null;
        Encyc encyc = null;
        Kin kin = null;
        CafeArticle cafearticle = null;
        try {
            ResponseEntity<Webkr> naverWebkrResponseEntity = restTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/webkr.json?query=" + searchWord + "&display=7&start=1",
                    HttpMethod.GET,
                    entity,
                    Webkr.class);
            webkr = naverWebkrResponseEntity.getBody();
            ResponseEntity<Blog> naverBlogResponseEntity = restTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/blog.json?query=" + searchWord + "&display=7&start=1",
                    HttpMethod.GET,
                    entity,
                    Blog.class);
            blog = naverBlogResponseEntity.getBody();
            ResponseEntity<Encyc> naverEncycResponseEntity = restTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/encyc.json?query=" + searchWord + "&display=7&start=1",
                    HttpMethod.GET,
                    entity,
                    Encyc.class);
            encyc = naverEncycResponseEntity.getBody();
            ResponseEntity<Kin> naverKinResponseEntity = restTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/kin.json?query=" + searchWord + "&display=7&start=1",
                    HttpMethod.GET,
                    entity,
                    Kin.class);
            kin = naverKinResponseEntity.getBody();
            ResponseEntity<CafeArticle> naverCafeArticleResponseEntity = restTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/cafearticle.json?query=" + searchWord + "&display=7&start=1",
                    HttpMethod.GET,
                    entity,
                    CafeArticle.class);
            cafearticle = naverCafeArticleResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception");
        }
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("webkr", webkr);
        model.addAttribute("blog", blog);
        model.addAttribute("encyc", encyc);
        model.addAttribute("kin", kin);
        model.addAttribute("cafearticle", cafearticle);

        return "naverSearch";
    }

    @RequestMapping("/daum")
    public String getDaum(Model model,
                           @RequestParam(name = "searchWord") String searchWord) {
        System.out.println("Testing GET METHOD (2)----------");
        RestTemplate restTemplate = new RestTemplate();
        Web web = null;
        DaumBlog daumBlog = null;
        DaumKnowledge daumKnowledge = null;
        DaumBoard daumBoard = null;
        try {
            ResponseEntity<Web> daumWebResponseEntity = restTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/web?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=7",
                    Web.class);
            web = daumWebResponseEntity.getBody();
            ResponseEntity<DaumBlog> daumDaumBlogResponseEntity = restTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/blog?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=7",
                    DaumBlog.class);
            daumBlog = daumDaumBlogResponseEntity.getBody();
            ResponseEntity<DaumKnowledge> daumDaumKnowledgeResponseEntity = restTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/knowledge?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=7",
                    DaumKnowledge.class);
            daumKnowledge = daumDaumKnowledgeResponseEntity.getBody();
            ResponseEntity<DaumBoard> daumDaumBoardResponseEntity = restTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/board?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=7",
                    DaumBoard.class);
            daumBoard = daumDaumBoardResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception");
        }

        model.addAttribute("searchWord", searchWord);
        model.addAttribute("web", web);
        model.addAttribute("daumBlog", daumBlog);
        model.addAttribute("daumKnowledge", daumKnowledge);
        model.addAttribute("daumBoard", daumBoard);

        return "daumSearch";
    }

    @RequestMapping("/google")
    public String getGoogle(Model model,
                          @RequestParam(name = "searchWord") String searchWord) {
        System.out.println("Testing GET METHOD (3)----------");
        RestTemplate restTemplate = new RestTemplate();
        GoogleSearch googleSearch = null;
        try {
            ResponseEntity<GoogleSearch> daumGoogleSearchResponseEntity = restTemplate.getForEntity(
                    GOOGLE_REST_SERVICE_URI + "?key=" + GOOGLE_API_KEY + "&cx=" + GOOGLE_CX + "&q=" + searchWord,
                    GoogleSearch.class);
            googleSearch = daumGoogleSearchResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception");
        }

        model.addAttribute("searchWord", searchWord);
        model.addAttribute("googleSearch", googleSearch);

        return "googleSearch";
    }
}
