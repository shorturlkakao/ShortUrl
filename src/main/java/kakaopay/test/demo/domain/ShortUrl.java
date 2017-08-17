package kakaopay.test.demo.domain;

/**
 * 단축 URL 도메인 Class
 */
public class ShortUrl {
    /**
     * 단축될 전체 URL
     */
    String fullUrl;

    /**
     * 단축된 URL
     */
    String shortUrl;

    /**
     * 고유값
     */
    Long id;

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "fullUrl='" + fullUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", id=" + id +
                '}';
    }
}
