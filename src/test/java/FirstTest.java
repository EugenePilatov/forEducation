import org.junit.After;
import org.junit.Assert;
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
        Assert.assertEquals(1/0, 1);
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, 2+2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, 2+2);
    }

    @Test
    public void test3() {
        Assert.assertTrue(2+2==4);
    }

    @Test
    public void test4() {
        Assert.assertTrue(2+2==5);
    }

    @Test
    public void test5() {
       Assertions.assertAll(
               () -> Assert.assertEquals(4, 2+2),
               () -> Assert.assertEquals(5, 2+2),
               () -> Assert.assertTrue(2+2==4),
               () -> Assert.assertTrue(2+2==5)
       );
    }
}

