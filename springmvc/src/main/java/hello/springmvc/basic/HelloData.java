package hello.springmvc.basic;

import lombok.Data;

//@Data -> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor를 자동적용
@Data
public class HelloData {
    private String username;
    private int age;
}
