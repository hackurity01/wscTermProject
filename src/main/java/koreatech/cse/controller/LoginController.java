package koreatech.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/login")
public class LoginController {
    String session = "";

    @RequestMapping(method = RequestMethod.POST)
    public String login(Model model,
                        @RequestParam(value="publicKeyModulus") String publicKeyModulus,
                        @RequestParam(value="publicKeyExponent") String publicKeyExponent,
                        @RequestParam(value="rsaUserid") String rsaUserid,
                        @RequestParam(value="rsaPassword") String rsaPassword) {

        System.out.println(rsaUserid);
        return "login";
    }
}
