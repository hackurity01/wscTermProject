package koreatech.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YDK on 2016-12-08.
 */

@Controller
@RequestMapping("/")
public class IndexController {
    String session = "";
    @RequestMapping
    public String index(Model model) {
        try {
            URL url = new URL("http://el.koreatech.ac.kr/intro.do");
            URLConnection conn = url.openConnection();

            conn.connect();

            Map m = conn.getHeaderFields();
            Collection c = (Collection) m.get("Set-Cookie");
            String cookie = "";
            for(Iterator i = c.iterator(); i.hasNext();){
                cookie = ((String)i.next()).split(";")[0];
                if(cookie.contains("JSESSIONID")) {
                    session = cookie;
                }
            }

            String publicKeyModulus = "";
            String publicKeyExponent = "";

            InputStream is = conn.getInputStream();
            Scanner scan = new Scanner(is);
            while (scan.hasNext()) {
                String source_line = scan.nextLine();
                if(source_line.contains("id=\"publicKeyModulus\""))
                    publicKeyModulus = source_line.split("id=\"publicKeyModulus\" value=\"")[1].split("\"/>")[0];
                if(source_line.contains("id=\"publicKeyExponent\""))
                    publicKeyExponent = source_line.split("id=\"publicKeyExponent\" value=\"")[1].split("\"/>")[0];
            }
            scan.close();

            model.addAttribute("publicKeyModulus", publicKeyModulus);
            model.addAttribute("publicKeyExponent", publicKeyExponent);

        } catch (MalformedURLException e) {
            System.out.println("The URL address is incorrect.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("It can't connect to the web page.");
            e.printStackTrace();
        }
        return "index";
    }
}
