import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

public class FirstTest {

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("FirstTest class started");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("All tests in FirstTest finished");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Test start");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("Test finished");
    }

    @Test
    public void myTest() {
        System.out.println("My first autotest running");
    }

    @Test
    public void test1() {
        System.out.println("Test №1");
    }

    @Test
    public void test2() {
        System.out.println("Test №2");
    }

    @Test
    public void test3() {
        System.out.println("Test №3");
    }

    @Test
    public void test4() {
        System.out.println("Test №4");
    }

    @Test
    public void test5() {
        System.out.println("Test №5");
    }
}

