package kakaopay.test.demo.data.entity;

import javax.persistence.*;

/**
 * DB 단축 URL Entity
 */
@Entity
//@Table(name = "SHORTURL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    @Column(name = "SERVICETYPE")
    private Integer serviceType;

    //    @Column(name = "SHORTURL")
    private String shortUrl;

    //    @Column(name = "FULLURL")
    private String fullUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullurl(String fullurl) {
        this.fullUrl = fullurl;
    }



    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", serviceType=" + serviceType +
                ", shortUrl='" + shortUrl + '\'' +
                ", fullUrl='" + fullUrl + '\'' +
                '}';
    }
}