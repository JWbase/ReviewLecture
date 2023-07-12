package hello.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " pirce = " + price);
        this.price = price; //여기가 문제가 발생할 수 있다.
    }

    public int getPrice() {
        return price;
    }
}
