package koreatech.cse.controller.rest;


import koreatech.cse.domain.rest.cs.Item;
import koreatech.cse.domain.rest.cs.APIResult;
import domain.rest.cs.daum.blog.DaumBlog;
import domain.rest.cs.daum.board.DaumBoard;
import domain.rest.cs.daum.knowledge.DaumKnowledge;
import domain.rest.cs.daum.web.Web;
import domain.rest.cs.google.GoogleSearch;
import domain.rest.cs.naver.blog.Blog;
import domain.rest.cs.naver.cafearticle.CafeArticle;
import domain.rest.cs.naver.encyc.Encyc;
import domain.rest.cs.naver.kin.Kin;
import domain.rest.cs.naver.webkr.Webkr;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    @RequestMapping("/mix")
    public String getMix(Model model,
                         @RequestParam(name = "searchWord") String searchWord) {
        System.out.println("Testing GET METHOD (4)----------");
        RestTemplate restTemplate = new RestTemplate();
        APIResult ar = null;
        try {
            ResponseEntity<APIResult> apiResultResponseEntity = restTemplate.getForEntity(
                    "http://172.19.96.14/cs/api/" + searchWord,
                    APIResult.class);
            ar = apiResultResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException-getMix");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception-getMix");
        }
        System.out.println(ar);
        //System.out.println(ar.getItems());
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("ar", ar);

        return "mix";
    }

    @RequestMapping(value="/api/{searchWord}", method= RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<APIResult> getApi(Model model, @PathVariable("searchWord") String searchWord) {
        return new ResponseEntity<APIResult>(getJson(searchWord), HttpStatus.OK);
    }

    public APIResult getJson(String searchWord) {
        APIResult ar = new APIResult();
        RestTemplate restNaverTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", NAVER_CLIENT_ID);
        headers.add("X-Naver-Client-Secret", NAVER_CLIENT_SECRET);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Webkr webkr = new Webkr();
        Blog blog = new Blog();
        Encyc encyc = new Encyc();
        Kin kin = new Kin();
        CafeArticle cafearticle = new CafeArticle();
        try {
            ResponseEntity<Webkr> naverWebkrResponseEntity = restNaverTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/webkr.json?query=" + searchWord + "&display=4&start=1",
                    HttpMethod.GET,
                    entity,
                    Webkr.class);
            webkr = naverWebkrResponseEntity.getBody();
            ResponseEntity<Blog> naverBlogResponseEntity = restNaverTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/blog.json?query=" + searchWord + "&display=4&start=1",
                    HttpMethod.GET,
                    entity,
                    Blog.class);
            blog = naverBlogResponseEntity.getBody();
            ResponseEntity<Encyc> naverEncycResponseEntity = restNaverTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/encyc.json?query=" + searchWord + "&display=4&start=1",
                    HttpMethod.GET,
                    entity,
                    Encyc.class);
            encyc = naverEncycResponseEntity.getBody();
            ResponseEntity<Kin> naverKinResponseEntity = restNaverTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/kin.json?query=" + searchWord + "&display=4&start=1",
                    HttpMethod.GET,
                    entity,
                    Kin.class);
            kin = naverKinResponseEntity.getBody();
            ResponseEntity<CafeArticle> naverCafeArticleResponseEntity = restNaverTemplate.exchange(
                    NAVER_REST_SERVICE_URI + "/cafearticle.json?query=" + searchWord + "&display=4&start=1",
                    HttpMethod.GET,
                    entity,
                    CafeArticle.class);
            cafearticle = naverCafeArticleResponseEntity.getBody();
            System.out.println(webkr);
            System.out.println(blog);
            System.out.println(encyc);
            System.out.println(kin);
            System.out.println(cafearticle);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException-getJsonNaver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception-getJsonNaver");
        }

        RestTemplate restDaumTemplate = new RestTemplate();
        Web web = new Web();
        DaumBlog daumBlog = new DaumBlog();
        DaumKnowledge daumKnowledge = new DaumKnowledge();
        DaumBoard daumBoard = new DaumBoard();
        try {
            ResponseEntity<Web> daumWebResponseEntity = restDaumTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/web?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=5",
                    Web.class);
            web = daumWebResponseEntity.getBody();
            ResponseEntity<DaumBlog> daumDaumBlogResponseEntity = restDaumTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/blog?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=5",
                    DaumBlog.class);
            daumBlog = daumDaumBlogResponseEntity.getBody();
            ResponseEntity<DaumKnowledge> daumDaumKnowledgeResponseEntity = restDaumTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/knowledge?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=5",
                    DaumKnowledge.class);
            daumKnowledge = daumDaumKnowledgeResponseEntity.getBody();
            ResponseEntity<DaumBoard> daumDaumBoardResponseEntity = restDaumTemplate.getForEntity(
                    DAUM_REST_SERVICE_URI + "/board?apikey=" + DAUM_API_KEY + "&q=" + searchWord + "&output=json&result=5",
                    DaumBoard.class);
            daumBoard = daumDaumBoardResponseEntity.getBody();
            System.out.println(web);
            System.out.println(daumBlog);
            System.out.println(daumKnowledge);
            System.out.println(daumBoard);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException-getJsonDaum");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception-getJsonDaum");
        }


        RestTemplate restGoogleTemplate = new RestTemplate();
        GoogleSearch googleSearch1 = new GoogleSearch();
        GoogleSearch googleSearch2 = new GoogleSearch();
        try {

            ResponseEntity<GoogleSearch> googleSearchResponseEntity = restGoogleTemplate.getForEntity(
                    GOOGLE_REST_SERVICE_URI + "?key=" + GOOGLE_API_KEY + "&cx=" + GOOGLE_CX + "&q=" + searchWord + "&start=1",
                    GoogleSearch.class);
            googleSearch1 = googleSearchResponseEntity.getBody();

            googleSearchResponseEntity = restGoogleTemplate.getForEntity(
                    GOOGLE_REST_SERVICE_URI + "?key=" + GOOGLE_API_KEY + "&cx=" + GOOGLE_CX + "&q=" + searchWord + "&start=11",
                    GoogleSearch.class);
            googleSearch2 = googleSearchResponseEntity.getBody();

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            System.out.println("@@@@@HttpClientErrorException-getJsonGoogle");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("@@@@@Exception-getJsonGoogle");
        }

        System.out.println("start setting the item - getJson");
        ar.setItems(new ArrayList<Item>());

        if(webkr.getItems() != null)
            for(int i = 0; i < webkr.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(webkr.getItems().get(i).getTitle() + "(Naver)");
                temp.setLink(webkr.getItems().get(i).getLink());
                temp.setDescription(webkr.getItems().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(blog.getItems() != null)
            for(int i = 0; i < blog.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(blog.getItems().get(i).getTitle() + "(Naver)");
                temp.setLink(blog.getItems().get(i).getLink());
                temp.setDescription(blog.getItems().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(encyc.getItems() != null)
            for(int i = 0; i < encyc.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(encyc.getItems().get(i).getTitle() + "(Naver)");
                temp.setLink(encyc.getItems().get(i).getLink());
                temp.setDescription(encyc.getItems().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(kin.getItems() != null)
            for(int i = 0; i < kin.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(kin.getItems().get(i).getTitle() + "(Naver)");
                temp.setLink(kin.getItems().get(i).getLink());
                temp.setDescription(kin.getItems().get(i).getDescription());
                ar.getItems().add(temp);
            }


        if(cafearticle.getItems() != null)
            for(int i = 0; i < cafearticle.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(cafearticle.getItems().get(i).getTitle() + "(Naver)");
                temp.setLink(cafearticle.getItems().get(i).getLink());
                temp.setDescription(cafearticle.getItems().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(web.getChannel().getItem() != null)
            for(int i = 0; i < web.getChannel().getItem().size(); i++) {
                Item temp = new Item();
                temp.setTitle(web.getChannel().getItem().get(i).getTitle() + "(Daum)");
                temp.setLink(web.getChannel().getItem().get(i).getLink());
                temp.setDescription(web.getChannel().getItem().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(daumBlog.getChannel().getItem() != null)
            for(int i = 0; i < daumBlog.getChannel().getItem().size(); i++) {
                Item temp = new Item();
                temp.setTitle(daumBlog.getChannel().getItem().get(i).getTitle() + "(Daum)");
                temp.setLink(daumBlog.getChannel().getItem().get(i).getLink());
                temp.setDescription(daumBlog.getChannel().getItem().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(daumBoard.getChannel().getItem() != null)
            for(int i = 0; i < daumBoard.getChannel().getItem().size(); i++) {
                Item temp = new Item();
                temp.setTitle(daumBoard.getChannel().getItem().get(i).getTitle() + "(Daum)");
                temp.setLink(daumBoard.getChannel().getItem().get(i).getLink());
                temp.setDescription(daumBoard.getChannel().getItem().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(daumKnowledge.getChannel().getItem() != null)
            for(int i = 0; i < daumKnowledge.getChannel().getItem().size(); i++) {
                Item temp = new Item();
                temp.setTitle(daumBoard.getChannel().getItem().get(i).getTitle() + "(Daum)");
                temp.setLink(daumBoard.getChannel().getItem().get(i).getLink());
                temp.setDescription(daumBoard.getChannel().getItem().get(i).getDescription());
                ar.getItems().add(temp);
            }

        if(googleSearch1.getItems() != null)
            for(int i = 0; i < googleSearch1.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(googleSearch1.getItems().get(i).getTitle() + "(Google)");
                temp.setLink(googleSearch1.getItems().get(i).getLink());
                temp.setDescription(googleSearch1.getItems().get(i).getSnippet());
                ar.getItems().add(temp);
            }

        if(googleSearch2.getItems() != null)
            for(int i = 0; i < googleSearch2.getItems().size(); i++) {
                Item temp = new Item();
                temp.setTitle(googleSearch2.getItems().get(i).getTitle() + "(Google)");
                temp.setLink(googleSearch2.getItems().get(i).getLink());
                temp.setDescription(googleSearch2.getItems().get(i).getSnippet());
                ar.getItems().add(temp);
            }

        long seed = System.nanoTime();
        Collections.shuffle(ar.getItems(), new Random(seed));
        ar.setTotal(ar.getItems().size());

        return ar;
       /* ObjectMapper mapper = new ObjectMapper();
        System.out.println("40");
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(ar);
        } catch(Exception e) {
            System.out.println(e.getMessage() + "\n" + "@@@@@json mapper error");
        }
        System.out.println(jsonInString);
        return jsonInString;*/
    }
}
