package kakaopay.test.demo.service.ShortUrlCreator;

import kakaopay.test.demo.cache.Cache;
import kakaopay.test.demo.common.Constants;
import kakaopay.test.demo.domain.ShortUrl;
import kakaopay.test.demo.exception.UrlException;
import kakaopay.test.demo.util.BaseEncodeUtil;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 메모리를 사용한 단축 URL 저장소 기능
 */
@Component("ShortUrlMemoryCreator")
public class ShortUrlMemoryCreator implements ShortUrlCreator {
    private final ReentrantLock lock = new ReentrantLock();
    Cache<ShortUrl> shortUrlCache = new Cache<>();

    @Override
    public ShortUrl getShortUrl(String fullUrl, int serviceType) {

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setFullUrl(fullUrl);
        long count = shortUrlCache.getCache().stream().filter(x -> fullUrl.equals(x.getFullUrl())).count();
        if (count > 0) {
            ShortUrl storedShortUrl = shortUrlCache.getCache().stream()
                    .filter(x -> fullUrl.equals(x.getFullUrl()))
                    .findFirst()
                    .get();
            return storedShortUrl;
        } else {
            long id = 0L;
            try {
                lock.lock();
                if (!shortUrlCache.getCache().isEmpty()) {
                    id = shortUrlCache.getCache().peek().getId() + 1L;
                }

                shortUrl.setShortUrl(BaseEncodeUtil.encode(id, BaseEncodeUtil.EncodeType.BASE52));
                shortUrl.setId(id);
                if(shortUrl.getShortUrl().length() > Constants.LIMIT_SHORT_URL_LENGTH){
                    throw new UrlException("더이상 단축 URL을 생성할 수 없습니다.");
                }

                shortUrlCache.put(shortUrl);

            }catch (Exception e){
                throw e;
            }finally {
                lock.unlock();
            }

        }
        return shortUrl;
    }

    @Override
    public ShortUrl getFullUrl(String shortUrl){
        Optional<ShortUrl> result = shortUrlCache.getCache().stream()
                .filter(x -> shortUrl.equals(x.getShortUrl()))
                .findFirst();
        ShortUrl storedShortUrl = null;
        if(result.isPresent()){
            storedShortUrl = result.get();
        }

        if (storedShortUrl == null) {
            throw new UrlException("입력하신 단축 URL 이 존재하지 않습니다.");
        }
        return storedShortUrl;
    }
}
