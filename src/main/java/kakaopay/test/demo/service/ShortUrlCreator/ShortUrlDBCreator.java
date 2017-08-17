package kakaopay.test.demo.service.ShortUrlCreator;

import kakaopay.test.demo.common.Constants;
import kakaopay.test.demo.data.respository.ShortUrlRepository;
import kakaopay.test.demo.domain.ShortUrl;
import kakaopay.test.demo.exception.UrlException;
import kakaopay.test.demo.util.BaseEncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * DB를 사용한 단축 URL 저장소 기능
 */
@Component("ShortUrlDBCreator")
public class ShortUrlDBCreator implements ShortUrlCreator {
    @Autowired
    ShortUrlRepository shortUrlRepository;


    @Override
    @Transactional
    public ShortUrl getShortUrl(String fullUrl, int serviceType) {
        ShortUrl shortUrlDomain = new ShortUrl();
        shortUrlDomain.setFullUrl(fullUrl);

        kakaopay.test.demo.data.entity.ShortUrl shortUrlEntity = shortUrlRepository.findByFullUrl(fullUrl);
        if (shortUrlEntity == null) {
            kakaopay.test.demo.data.entity.ShortUrl newShortUrlData = new kakaopay.test.demo.data.entity.ShortUrl();
            newShortUrlData.setFullurl(fullUrl);
            newShortUrlData.setServiceType(serviceType);
            kakaopay.test.demo.data.entity.ShortUrl savedShortUrl = shortUrlRepository.save(newShortUrlData);
            String newShortUrl = BaseEncodeUtil.encode(savedShortUrl.getId(), BaseEncodeUtil.EncodeType.BASE52);
            if(newShortUrl.length() > Constants.LIMIT_SHORT_URL_LENGTH){
                throw new UrlException("더이상 단축 URL을 생성할 수 없습니다.");
            }
            shortUrlRepository.updateShortUrl(savedShortUrl.getId(), newShortUrl);
            shortUrlDomain.setShortUrl(newShortUrl);
            return shortUrlDomain;
        } else {
            return convertToDomain(shortUrlEntity);
        }
    }

    @Override
    public ShortUrl getFullUrl(String shortUrl) {
        kakaopay.test.demo.data.entity.ShortUrl shortUrlEntity = shortUrlRepository.findByShortUrl(shortUrl);
        if (shortUrlEntity == null) {
            throw new UrlException("입력하신 단축 URL 이 존재하지 않습니다.");
        }
        return convertToDomain(shortUrlEntity);
    }


    private ShortUrl convertToDomain(kakaopay.test.demo.data.entity.ShortUrl shortUrlEntity) {
        ShortUrl shortUrlDomain = new ShortUrl();
        shortUrlDomain.setShortUrl(shortUrlEntity.getShortUrl());
        shortUrlDomain.setFullUrl(shortUrlEntity.getFullUrl());
        shortUrlDomain.setId(shortUrlEntity.getId());
        return shortUrlDomain;
    }
}
