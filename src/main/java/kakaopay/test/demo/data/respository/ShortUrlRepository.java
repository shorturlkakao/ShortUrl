package kakaopay.test.demo.data.respository;

import kakaopay.test.demo.data.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 단축 URL 서비스를 위한 DB 저장소
 */
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    ShortUrl findByFullUrl(String fullUrl);

    ShortUrl findByShortUrl(String shortUrl);

    @Modifying
    @Query("UPDATE ShortUrl SET shortUrl=?2 WHERE id=?1")
    @Transactional
    int updateShortUrl(Long id, String shortUrl);

}
