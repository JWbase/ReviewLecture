package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler); //handler는 컨트롤러를 말함, 어댑터가 해당컨트롤러를 처리할 수 있는지 판단하는 메서드

    /**
     * 어댑터는 실제컨트롤러를 호출하고, 그 결과로 ModelView를 반환
     * 실제컨트롤러가 ModelView를 반환하지못하면 어댑터가 ModelView를 직접생성해서라도 반환
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
    
}
