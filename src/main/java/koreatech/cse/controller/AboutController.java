package koreatech.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 성준이 on 2016-12-13.
 */

@Controller
@RequestMapping("/aboutApi")
public class AboutController {
    @RequestMapping
    public String aboutApi(Model model) {

        return "aboutApi";
    }
}
