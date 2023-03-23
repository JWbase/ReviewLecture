package hello.servlet.web.frontcontroller.v4;

import java.util.Map;


/**
 * @param paramMap
 * @pram model
 * @return viewName
 * model객체가 파라미터로 전달되기 때문에 view이름만 반환해주면 된다.
 */
public interface ControllerV4 {
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
