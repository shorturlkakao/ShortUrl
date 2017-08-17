package kakaopay.test.demo.repository;

import kakaopay.test.demo.data.entity.ShortUrl;
import kakaopay.test.demo.data.respository.ShortUrlRepository;
import kakaopay.test.demo.enumeration.ServiceType;
import kakaopay.test.demo.util.BaseEncodeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShortUrlRespository {
    @Autowired
    ShortUrlRepository shortUrlRepository;

    @Test
    public void testFindByFullUrl(){
        try {
            ShortUrl shortUrl = shortUrlRepository.findByFullUrl("www.naver.com");
            System.out.println("result=" + shortUrl);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void testFindByShortUrl(){
        try {
            ShortUrl shortUrl = shortUrlRepository.findByShortUrl("A");
            System.out.println("result=" + shortUrl);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void testSaveShortUrl(){
        try {
            ShortUrl target = new ShortUrl();
            target.setServiceType(ServiceType.DEFAULT.getType());
            target.setFullurl("naver.com");
            target.setShortUrl("A");

            ShortUrl shortUrl = shortUrlRepository.save(target);
            System.out.println("savedObject=" + shortUrl.toString());
            ShortUrl result = shortUrlRepository.findOne(shortUrl.getId());
            System.out.println("selectedObject=" + shortUrl.toString());
            Assert.assertNotNull(result);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void testUpdateShortUrl(){
        try {
            ShortUrl target = new ShortUrl();
            target.setServiceType(ServiceType.DEFAULT.getType());
            target.setFullurl("daum.com");

            ShortUrl shortUrl = shortUrlRepository.save(target);
            System.out.println("savedObject=" + shortUrl.toString());
            Assert.assertTrue(shortUrl.getShortUrl() == null);


            String endcodingText = BaseEncodeUtil.encode(shortUrl.getId(), BaseEncodeUtil.EncodeType.BASE52);
            int count = shortUrlRepository.updateShortUrl(shortUrl.getId(), endcodingText);
            System.out.println("selectedObject=" + shortUrl.toString());
            Assert.assertTrue(count > 0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}
