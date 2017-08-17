package kakaopay.test.demo.exception;

public class UrlException extends RuntimeException {
    String message = "Abnormal short url Exception.";

    public UrlException() {
    }

    public UrlException(String message) {
        super(message);
        this.message = super.getMessage();
    }
}
