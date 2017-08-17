package kakaopay.test.demo.service;

import kakaopay.test.demo.data.respository.ShortUrlRepository;
import kakaopay.test.demo.domain.ShortUrl;
import kakaopay.test.demo.enumeration.ServiceType;
import kakaopay.test.demo.service.ShortUrlCreator.ShortUrlCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 단축 URL 관련 서비스
 */
@Service
public class ShortUrlService {
    @Autowired
    ShortUrlRepository shortUrlRepository;
    @Autowired
//    @Qualifier("ShortUrlDBCreator")
    @Qualifier("ShortUrlMemoryCreator")
    ShortUrlCreator shortUrlCreator;


    @Transactional
    public ShortUrl getShortUrl(String fullUrl, ServiceType serviceType){
        return shortUrlCreator.getShortUrl(fullUrl, serviceType.getType());
    }
    public ShortUrl getFullUrlInfo(String shortUrl){
        return shortUrlCreator.getFullUrl(shortUrl);
    }
}
