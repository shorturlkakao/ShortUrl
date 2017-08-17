package kakaopay.test.demo.controller;

import kakaopay.test.demo.domain.ShortUrl;
import kakaopay.test.demo.enumeration.ServiceType;
import kakaopay.test.demo.exception.UrlException;
import kakaopay.test.demo.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 단축 URL 생성과 관련된 Controller
 */
@Controller
public class CreateShortController {
    @Autowired
    ShortUrlService shortUrlService;

    /**
     * 단축 URL 생성 페이지 메인
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 단축 URL 생성 API
     * @param url   단축될 FULL URL
     * @return      생성 결과
     */
    @RequestMapping(value = "/short-url", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestParam String url) {
        Map<String, Object> result = new HashMap<>();
        try {
            ShortUrl shortUrl = shortUrlService.getShortUrl(url, ServiceType.DEFAULT);
            result.put("result", true);
            result.put("data", shortUrl);
        }catch (Exception e){
            result.put("result", false);
            result.put("error", e.getMessage());
        }


        return result;
    }

    @RequestMapping("/exception")
    public String exception() {
        throw new UrlException();
    }
}
