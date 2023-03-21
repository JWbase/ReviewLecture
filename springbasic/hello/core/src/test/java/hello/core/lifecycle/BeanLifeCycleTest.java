package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *  스프링 빈의 이벤트 라이프 사이클
 *  스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
 *  초기화 콜백 : 빈이 생성되고, 빈의 의존관계 주입이 완료 된 후 호출
 */

/**
 * @PostConstruct, @PreDestroy 어노테이션 특징
 * 스프링이 권장하는 방식
 * 자바표준 -> 스프링이 아닌 다른컨테이너에서도 동작
 * 컴포넌트 스캔과 어울림
 * 단점은 외부 라이브러리에 적용하지 못하기 때문에 외부라이브러리는 @Bean()기능사용
 */
public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //스프링 컨테이너 종료, ConfigurableApplicationContext 필요
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }

}
