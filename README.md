ShortUrl
==================
>**단축 URL 생성 서비스**  
>*입력받은 URL을 짧은 단축 URL로 변환해주는 서비스*

Summary
------------------
> * 언어 : Java 1.8
> * 프레임웍 : Spring Boot, JPA
> * 빌드 : gradle
> * DB : h2
> * 템플릿엔진 : Freemarker
> * Port : 8080

Test
------------------
> 1. Application 실행 후 `http://localhost:8080/index` 접속
> 2. 생성하고자 하는 URL 입력 후 단축 URL 생성
> 3. 생성된 URL(ex@http://localhost:8080/B)을 브라우저에 입력
> 4. 단축 URL 입력 시 최초 입력한 전체 URL로 정상적으로 이동하는지 확인

Tip
------------------
> * 단축 URL 저장소로 Cache와 DB를 선택 가능(*ShortUrlService 에서 변경*)
> * 단축 URL 생성 방식을 BASE52와 BASE62를 선택 가능(요구사항에 숫자사용 가능여부 불확실)
> * 서비스 중 발생하는 오류는 error 페이지로 이동하며 오류에 대해 출력
> * 글자 수 제한은 `(52 or 62) ^ 8`은 DB 및 코드 확장에 제한이 있어 `if(String > 8)` 로 제한
> * 서비스 확장을 위해 DB 사용 시 ServiceType 사용
> * 서버가 구동된 상태에서는 unit test 불가

 

*************

