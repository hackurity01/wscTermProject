package koreatech.cse.controller;

import koreatech.cse.domain.Assignment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;
import org.snu.ids.ha.ma.MorphemeAnalyzer;
import org.snu.ids.ha.ma.Sentence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(method = RequestMethod.POST)
    public String login(Model model,
                        @RequestParam(value="publicKeyModulus") String publicKeyModulus,
                        @RequestParam(value="publicKeyExponent") String publicKeyExponent,
                        @RequestParam(value="rsaUserid") String rsaUserid,
                        @RequestParam(value="rsaPassword") String rsaPassword,
                        @RequestParam(value="session") String session,
                        @RequestParam(value="userID") String userID,
                        @RequestParam(value="userPW") String userPW) {
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
            System.out.println("getRequestProp : "+conn.getRequestProperties());

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

            System.out.println("[[["+conn.getHeaderFields()+"]]]");

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
            System.out.println("getRequestProp : "+conn.getRequestProperties());

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
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            StringBuffer sb = new StringBuffer();
            String thisLine = null;
            while( (thisLine = in.readLine())!=null ){
                sb.append(thisLine);
                sb.append("\n");
            }
            in.close();

            // el. 과 stu04.el. 이랑 세션이 달라서 다시 가져와야됨
            Map m = conn.getHeaderFields();
            Collection c = (Collection) m.get("Set-Cookie");
            String cookie = "";
            for(Iterator i = c.iterator(); i.hasNext();){
                cookie = ((String)i.next()).split(";")[0];
                if(cookie.contains("JSESSIONID")) {
                    session = cookie;
                    System.out.println("////cookie set : " + cookie);
                }
            }

            System.out.println("(((((((("+conn.getHeaderFields()+"))))))))");

            ///////////////////////// 각 과목 반복 /////////////////////////
            String html = sb.toString();
            Document doc = Jsoup.parse(html);
            Elements class_datas = doc.select("div.title_wrap");
            for (Element class_data: class_datas){
                System.out.println("\n===========\n["+class_data.select("[name=\"lectureLectureValue\"]").val()+"]");
                System.out.println("\n"+class_data.select("strong").text());

                Assignment a = new Assignment(class_data.select("strong").text(), class_data.select("[name=\"lectureLectureValue\"]").val());

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

                data = URLEncoder.encode("lectureSeq", "UTF-8") + "=" + URLEncoder.encode(a.getLectureLectureValue(), "UTF-8");
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                wr.close();

                //conn.connect();


                in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                sb = new StringBuffer();
                thisLine = null;
                while( (thisLine = in.readLine())!=null ){
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

                data = URLEncoder.encode("lectureSeq", "UTF-8") + "=" + URLEncoder.encode(a.getLectureLectureValue(), "UTF-8");
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                wr.close();

                in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                sb = new StringBuffer();
                thisLine = null;
                while( (thisLine = in.readLine())!=null ){
                    sb.append(thisLine);
                    sb.append("\n");
                }
                in.close();

                ////////////////////////////// 각 과제 반복 //////////////////////////////
                String report_html = sb.toString();
                Document report_doc = Jsoup.parse(report_html);
                Elements report_datas = report_doc.select("td.title");
                System.out.println(report_doc.select("td.title"));
                for (Element report_data: report_datas){
                    System.out.println(report_data.select("[name=\"reportSeqValue\"]").val());

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

                    in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                    sb = new StringBuffer();
                    thisLine = null;
                    while( (thisLine = in.readLine())!=null ){
                        sb.append(thisLine);
                        sb.append("\n");
                    }
                    in.close();

                    //////////// 과제 내용 파싱 ////////////
                    String write_html = sb.toString();
                    Document write_doc = Jsoup.parse(write_html);
                    System.out.println(write_doc.select("div.class_qna .board_view tr:eq(3) td").text());

                    ////////////////////////// 키워드 추출 ////////////////////////////////
                    try {
                        String content = write_doc.select("div.class_qna .board_view tr:eq(3) td").text();
                        MorphemeAnalyzer ma = new MorphemeAnalyzer();
                        ma.createLogger(null);
                        List ret = ma.analyze(content);
                        ret = ma.postProcess(ret);
                        ret = ma.leaveJustBest(ret);
                        List stl = ma.divideToSentences(ret);
                        for (int i = 0; i < stl.size(); i++) {
                            Sentence st = (Sentence) stl.get(i);
                            System.out.println("===>  " + st.getSentence());
                            for (int j = 0; j < st.size(); j++) {
                                Pattern pattern = Pattern.compile("[0-9]+/([^\\+]*)/NNG"); //img 태그 src 추출 정규표현식
                                Matcher matcher = pattern.matcher(st.get(j).toString());
                                String key = "";
                                while (matcher.find()) {
                                    key += matcher.group(1);
                                }
                                System.out.println(key);
                            }
                        }
                        ma.closeLogger();
                    } catch (Exception e) {
                        System.out.println("트라이캐치");
                        e.printStackTrace();
                        System.exit(0);
                    }
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("The URL address is incorrect.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("It can't connect to the web page.");
            e.printStackTrace();
        }
        return "login";
    }
}
