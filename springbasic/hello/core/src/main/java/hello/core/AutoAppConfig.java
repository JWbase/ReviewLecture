package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

/**
 * 컴포넌트 스캔을 사용하면 @Configuration이 붙은 설정정보도 자동으로 등록되기 때문에
 * excludeFilters를 이용해서 컴포넌트 스캔 대상에서 제외
 * 컴포넌트 스캔은 이름 그대로 @Component가 붙은 클래스를 스캔해서 빈으로 등록
 */
@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
