CREATE TABLE ShortUrl
(
    `id`           BIGINT           NOT NULL    AUTO_INCREMENT,
    `serviceType`  INT              NULL,
    `shortUrl`     VARCHAR(8)       NULL,
    `fullUrl`      VARCHAR(1000)    NULL,
    PRIMARY KEY (id)
);
create index IDX_SHORTURL_FULLURL on ShortUrl (fullUrl);
create index IDX_SHORTURL_SHORTURL on ShortUrl (shortUrl);


