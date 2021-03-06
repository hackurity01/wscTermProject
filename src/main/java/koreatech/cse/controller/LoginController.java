package koreatech.cse.controller;

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
import koreatech.cse.domain.Assi;
import koreatech.cse.domain.Clss;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.snu.ids.ha.ma.MorphemeAnalyzer;
import org.snu.ids.ha.ma.Sentence;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YDK on 2016-12-08.
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final String NAVER_CLIENT_ID = "zzfxWt08wZ83tKDkkQG5";
    private static final String NAVER_CLIENT_SECRET = "uOX0hfGJU2";
    private static final String NAVER_REST_SERVICE_URI = "https://openapi.naver.com/v1/search";
    private static final String DAUM_API_KEY = "3290ef3cd3ab379e6491a313800f28e7";
    private static final String DAUM_REST_SERVICE_URI = "https://apis.daum.net/search";
    private static final String GOOGLE_REST_SERVICE_URI = "https://www.googleapis.com/customsearch/v1";
    private static final String GOOGLE_API_KEY = "AIzaSyBvjZSmEnhIbjoOS3Y5gMHtNHwOlDo1Tfo";
    private static final String GOOGLE_CX = "016904682003137614969:vx9ytdzgvoq";

    @RequestMapping(method = RequestMethod.POST)
    public String login(Model model,
                        @RequestParam(value = "publicKeyModulus") String publicKeyModulus,
                        @RequestParam(value = "publicKeyExponent") String publicKeyExponent,
                        @RequestParam(value = "rsaUserid") String rsaUserid,
                        @RequestParam(value = "rsaPassword") String rsaPassword,
                        @RequestParam(value = "session") String session,
                        @RequestParam(value = "userID") String userID,
                        @RequestParam(value = "userPW") String userPW) {
        /* 리스트 변수 */
        ArrayList<Clss> clsList = new ArrayList<Clss>(); //파싱으로 얻은 과제리스트 완성본. 과목을 의미하는 Clss 객체 내부에 과제를 의미하는 Alss 어레이 리스트가 존재함.
        ArrayList<Assi> Alist; //각 과제의 정보를 담고있는 Assi 객체의 어레이리스트. 나중에 Clss 객체에 통째로 저장됨.
        Clss cls; //Class, 즉 과목을 의미하는 클래스. 클래스 이름인 name 필드와 과제 정보 리스트인 Alist 어레이 리스트를 가지고 있음.
        Assi a; //Assignment, 즉 과제를 의미하는 클래스. 과제의 제목인 title 필드와 과제 내용인 content필드, 그리고 LectureValue를 가지고 있다.(왜 있는지는 모르겠음 유동균이 만들어서)
        String searchKey = "";
        ArrayList<String> contentList = new ArrayList<String>();

        try {
            /////////////////////////////////// 로그인 하기 //////////////////////////////////
            String cookies = session;
            URL login_url = new URL("http://el.koreatech.ac.kr/loginProc.do");
            URLConnection conn = login_url.openConnection();
            conn.setDoOutput(true);
            conn.setUseCaches(false);

            conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
            conn.setRequestProperty("Origin", "http://el.koreatech.ac.kr");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Referer", "http://el.koreatech.ac.kr/intro.do?language=kr");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Cookie", cookies);
            System.out.println("getRequestProp : " + conn.getRequestProperties());

            String data = URLEncoder.encode("publicKeyModulus", "UTF-8") + "=" + URLEncoder.encode(publicKeyModulus, "UTF-8");
            data += "&" + URLEncoder.encode("publicKeyExponent", "UTF-8") + "=" + URLEncoder.encode(publicKeyExponent, "UTF-8");
            data += "&" + URLEncoder.encode("rsaUserid", "UTF-8") + "=" + URLEncoder.encode(rsaUserid, "UTF-8");
            data += "&" + URLEncoder.encode("rsaPassword", "UTF-8") + "=" + URLEncoder.encode(rsaPassword, "UTF-8");
            data += "&" + URLEncoder.encode("login_id", "UTF-8") + "=" + URLEncoder.encode(userID, "UTF-8");
            data += "&" + URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(userID, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(userPW, "UTF-8");

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            wr.close();

            InputStream is = conn.getInputStream();
            Scanner scan = new Scanner(is);
            while (scan.hasNext()) {
                String source_line = scan.nextLine();
                System.out.println(source_line);
            }
            scan.close();

            System.out.println("[[[" + conn.getHeaderFields() + "]]]");

            ///////////////////////////// 홈 화면으로 가기 //////////////////////////////
            URL logined_url = new URL("http://stu04.el.koreatech.ac.kr/main.do?language=kr");
            conn = logined_url.openConnection();
            conn.setDoOutput(true);
            conn.setUseCaches(false);

            conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
            conn.setRequestProperty("Origin", "http://el.koreatech.ac.kr");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Referer", "http://el.koreatech.ac.kr/intro.do?language=kr");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Cookie", cookies);
            System.out.println("getRequestProp : " + conn.getRequestProperties());

            data = URLEncoder.encode("publicKeyModulus", "UTF-8") + "=" + URLEncoder.encode(publicKeyModulus, "UTF-8");
            data += "&" + URLEncoder.encode("publicKeyExponent", "UTF-8") + "=" + URLEncoder.encode(publicKeyExponent, "UTF-8");
            data += "&" + URLEncoder.encode("rsaUserid", "UTF-8") + "=" + URLEncoder.encode(rsaUserid, "UTF-8");
            data += "&" + URLEncoder.encode("rsaPassword", "UTF-8") + "=" + URLEncoder.encode(rsaPassword, "UTF-8");
            data += "&" + URLEncoder.encode("login_id", "UTF-8") + "=" + URLEncoder.encode(userID, "UTF-8");
            data += "&" + URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(userID, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(userPW, "UTF-8");

            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            wr.close();

            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String thisLine = null;
            while ((thisLine = in.readLine()) != null) {
                sb.append(thisLine);
                sb.append("\n");
            }
            in.close();

            // el. 과 stu04.el. 이랑 세션이 달라서 다시 가져와야됨
            Map m = conn.getHeaderFields();
            Collection c = (Collection) m.get("Set-Cookie");
            String cookie = "";
            for (Iterator i = c.iterator(); i.hasNext(); ) {
                cookie = ((String) i.next()).split(";")[0];
                if (cookie.contains("JSESSIONID")) {
                    session = cookie;
                    System.out.println("////cookie set : " + cookie);
                }
            }

            System.out.println("((((((((" + conn.getHeaderFields() + "))))))))");


            ///////////////////////// 각 과목 반복 /////////////////////////
            String html = sb.toString();
            Document doc = Jsoup.parse(html);
            Elements class_datas = doc.select("div.title_wrap");
            for (Element class_data : class_datas) {
                Alist = new ArrayList<Assi>();
                /////원래주석
                cls = new Clss();
                //cls.setName(class_data.select("[name=\"lectureLectureValue\"]").val());
                cls.setName(class_data.select("strong").text()); //과목명으로 csl 객체의 name 설정
                System.out.println(cls.getName());

                //System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[["+cls.getName()+"]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
                System.out.println("\n===========\n[" + class_data.select("[name=\"lectureLectureValue\"]").val() + "]");
                //System.out.println("\n" + class_data.select("strong").text());

                String lectureLectureValue = class_data.select("[name=\"lectureLectureValue\"]").val();

                /*Assi
                //a = new Assi(class_data.select("strong").text(), class_data.select("[name=\"lectureLectureValue\"]").val());
                System.out.println("Alss의 타이틀 : " + a.getTitle());
                System.out.println("Alss의 LectureValue : " + a.getLectureLectureValue());
                System.out.println("class_data.select"+class_data.select("strong").text());
                */

                ////////////////////////////// 특정 과목의 메인 페이지 요청 ////////////////////////////////
                URL url = new URL("http://stu04.el.koreatech.ac.kr/class/main.do");
                conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setUseCaches(false);

                conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                conn.setRequestProperty("Origin", "http://stu04.el.koreatech.ac.kr");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Referer", "http://stu04.el.koreatech.ac.kr/main.do");
                conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
                conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
                conn.setRequestProperty("Cookie", session);

                data = URLEncoder.encode("lectureSeq", "UTF-8") + "=" + URLEncoder.encode(lectureLectureValue, "UTF-8");
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                wr.close();

                //conn.connect();


                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                sb = new StringBuffer();
                thisLine = null;
                while ((thisLine = in.readLine()) != null) {
                    sb.append(thisLine);
                    sb.append("\n");
                }
                in.close();


                ////////////////////// 과제 리스트 페이지 요청 ////////////////////////////////
                url = new URL("http://stu04.el.koreatech.ac.kr/class/room/report/list.do");
                conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setUseCaches(false);

                conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                conn.setRequestProperty("Origin", "http://stu04.el.koreatech.ac.kr");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Referer", "http://stu04.el.koreatech.ac.kr/main.do");
                conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
                conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
                conn.setRequestProperty("Cookie", session);

                data = URLEncoder.encode("lectureSeq", "UTF-8") + "=" + URLEncoder.encode(lectureLectureValue, "UTF-8");
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                wr.close();

                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                sb = new StringBuffer();
                thisLine = null;
                while ((thisLine = in.readLine()) != null) {
                    sb.append(thisLine);
                    sb.append("\n");
                }
                in.close();


                //Assi ass = new Assi();
                ////////////////////////////// 각 과제 반복 //////////////////////////////
                System.out.println("각 과제 반복 -------------------------");
                String report_html = sb.toString();
                Document report_doc = Jsoup.parse(report_html);
                Elements report_datas = report_doc.select("td.title");
                //Elements report_datas = report_doc.select("td.title");

                String regex1 = "\\<.*?\\>";
                String regex2 = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
                //String html = "가<aaa>나</bbb>다<ccc/>라<한글>마<ddd >바< eee >사< img src=\"한글\" >아\n";


                System.out.println("td.title : " + report_datas);

                String test = report_datas.select("a.viewBtn").toString().replaceAll(regex1, "");
                test = test.replace("\n","/");
                // split을 이용한 문자열 분리
                System.out.println(test);
                System.out.println("test의 길이 " + test.length());
                String[] titleList = test.split("/") ;
                System.out.println("[split 이용]") ;
                for(int i=0; i < titleList.length; i++){
                    if(titleList[i].length() > 2) {
                        a = new Assi();
                        a.setTitle(titleList[i]);
                        a.setLectureLectureValue(lectureLectureValue);
                        //System.out.println("Alss의 타이틀 : " + a.getTitle());
                        Alist.add(a);
                    }
                }
                System.out.println("alist size : " + Alist.size());

                //System.out.println("test : " + test);

                //String title = report_datas.toString().replaceAll(regex1, "");
                //System.out.println(title);
                //System.out.println(report_datas.toString().replaceAll(regex2, ""));

                // ass.setTitle(report_doc.select("td.title"));
                int i = 0;
                for (Element report_data : report_datas) {
                    System.out.println("report_data.select : "+ report_data.select("[name=\"reportSeqValue\"]").val());
                    ////////////////////////////// 과제 내용 페이지 요청 /////////////////////////////
                    url = new URL("http://stu04.el.koreatech.ac.kr/class/room/report/write.do");
                    conn = url.openConnection();
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);

                    conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    conn.setRequestProperty("Origin", "http://stu04.el.koreatech.ac.kr");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Referer", "http://stu04.el.koreatech.ac.kr/main.do");
                    conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
                    conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
                    conn.setRequestProperty("Cookie", session);

                    data = URLEncoder.encode("reportSeq", "UTF-8") + "=" + URLEncoder.encode(report_data.select("[name=\"reportSeqValue\"]").val(), "UTF-8");
                    wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();
                    wr.close();

                    in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    sb = new StringBuffer();
                    thisLine = null;
                    while ((thisLine = in.readLine()) != null) {
                        sb.append(thisLine);
                        sb.append("\n");
                    }
                    in.close();

                    //////////// 과제 내용 파싱 ////////////
                    System.out.println("과제 내용 파싱 -------------------------");
                    String write_html = sb.toString();
                    Document write_doc = Jsoup.parse(write_html);
                    String content = write_doc.select("div.class_qna .board_view tr:eq(3) td").text();
                    Alist.get(i).setContent(content);
                    System.out.println("get " + i + "는 : " + Alist.get(i).getContent());
                    i++;
                    //a.setContent(content);
                    //System.out.println("write_doc.select 디브 : " + content);

                    //String searchKey = "";


                    /*
                    ////////////////////////// 키워드 추출 ////////////////////////////////
                    System.out.println("키워드 추출 -------------------------");
                    try {
                        MorphemeAnalyzer ma = new MorphemeAnalyzer();
                        ma.createLogger(null);
                        List ret = ma.analyze(content);
                        ret = ma.postProcess(ret);
                        ret = ma.leaveJustBest(ret);
                        List stl = ma.divideToSentences(ret);

                        for (int i = 0; i < stl.size(); i++) {
                            Sentence st = (Sentence) stl.get(i);
                            if (st.getSentence().length() < 1) {
                                System.out.println("length : 0\n");
                                continue;
                            }
                            System.out.println("===>  " + st.getSentence());
                            for (int j = 0; j < st.size(); j++) {
                                if (st.get(j).toString().length() < 1) {
                                    System.out.println("length : 0\n");
                                    continue;
                                }
                                Pattern pattern = Pattern.compile("[0-9]+/([^\\+]*)/NNG");
                                Matcher matcher = pattern.matcher(st.get(j).toString());
                                String key = "";
                                while (matcher.find()) {
                                    key += matcher.group(1);
                                }
                                searchKey += key + " ";
                                System.out.println("key : " + key);
                            }
                        }
                        //검색
                        System.out.println("searchKey : " + searchKey);
                        //a.setContent(searchKey);
                        contentList.add(searchKey);
                        /////원래주석
                        //cls.addAss(a);
                        ////
                        //ma.closeLogger();
                    } catch (Exception e) {
                        System.out.println("트라이캐치");
                        e.printStackTrace();
                        System.exit(0);
                    }*/
                } // 과제 반복 끝

                //System.out.println("aa/");
                //원래주석
                cls.setAList(Alist);
                clsList.add(cls);
                //
            }
        } catch (MalformedURLException e) {
            System.out.println("The URL address is incorrect.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("It can't connect to the web page.");
            e.printStackTrace();
        }

        //MorphemeAnalyzer 클래스의 객체 ma의 closeLogger 때문에 콘솔창에 더이상 출력이 안되는거였음
        //찾아보니까 굳이 close할필요도 없더만...그냥 주석처리

        ////////////////////////////////////////과제리스트 작성 결과 /////////////////////////////
        System.out.println("clsList : " + clsList);
        System.out.println("content list : " + contentList);

        for(int i = 0; i < clsList.size(); i++) {
            System.out.println("=========과목 명 " + clsList.get(i).getName());
            for(int j = 0; j < clsList.get(i).getAList().size(); j++) {
                System.out.println("title : " + clsList.get(i).getAList().get(j).getTitle());
                System.out.println("content : " + clsList.get(i).getAList().get(j).getContent());
                System.out.println("LectureValue : " + clsList.get(i).getAList().get(j).getLectureLectureValue());
            }
            System.out.println("==========");
        }


        model.addAttribute("clsList", clsList);



        return "login";
    }
}
















