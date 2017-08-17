package kakaopay.test.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 서비스 전체 오류처리를 담당
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 단축 URL 관련 오류 처리
     * @param e
     * @return
     */
    @ExceptionHandler(value = UrlException.class)
    public ModelAndView urlException(UrlException e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("exception", e);
        return mav;
    }

    /**
     * 알 수 없는 오류에 대한 처리
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return "error";
    }


}
