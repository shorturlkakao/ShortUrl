package kakaopay.test.demo.service;

import kakaopay.test.demo.domain.ShortUrl;
import kakaopay.test.demo.enumeration.ServiceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShortUrlService {
    @Autowired
    ShortUrlService shortUrlService;
    @Test
    public void testGetShortUrl(){
        ShortUrl shortUrl = shortUrlService.getShortUrl("facebook.com", ServiceType.DEFAULT);
        System.out.println(shortUrl);
    }
    @Test
    public void testGetFullUrlInfo(){
        ShortUrl savedItem = shortUrlService.getShortUrl("facebook.com", ServiceType.DEFAULT);
        ShortUrl shortUrl = shortUrlService.getFullUrlInfo(savedItem.getShortUrl());
        System.out.println(shortUrl);
    }
}
