package kakaopay.test.demo.service.ShortUrlCreator;

import kakaopay.test.demo.domain.ShortUrl;

/**
 * 단축 URL 생성기 인터페이스
 */
public interface ShortUrlCreator {
    /**
     * 단축 URL을 생성 및 조회
     * <pre>
     *  -. 기 존재 시 기존 정보 조회
     *  -. 최초 등록 시 싱규 생성
     *  </pre>
     * @param fullUrl       생성될 전체 URL
     * @param serviceType   서비스타입({@link kakaopay.test.demo.enumeration.ServiceType})
     * @return {@link ShortUrl}
     */
    ShortUrl getShortUrl(String fullUrl, int serviceType);

    /**
     * 단축 URL로 해당 정보 조회
     * @param shortUrl  단축 URL
     * @return  {@link ShortUrl}
     */
    ShortUrl getFullUrl(String shortUrl);
}
