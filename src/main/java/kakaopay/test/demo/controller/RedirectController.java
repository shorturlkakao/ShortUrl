package kakaopay.test.demo.controller;

import kakaopay.test.demo.domain.ShortUrl;
import kakaopay.test.demo.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RedirectController {
    @Autowired
    ShortUrlService shortUrlService;

    @RequestMapping("/{url}")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String redirect(HttpServletRequest request,
                           HttpServletResponse response, HttpStatus httpStatus,
                           @PathVariable String url) {
        ShortUrl shortUrlInfo = shortUrlService.getFullUrlInfo(url);
        if (shortUrlInfo != null) {
            if (shortUrlInfo.getFullUrl().contains("http")) {
                return "redirect:" + shortUrlInfo.getFullUrl();
            }
            return "redirect:http://" + shortUrlInfo.getFullUrl();
        }
        return "error";
    }

}
