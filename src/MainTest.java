public class MainTest {

    public static void main(String[] args) {
        testGreet();
    }

    public static void testGreet() {
        assert Main.greet("World").equals("Hello, World!") : "Test failed: greet('World')";
        assert Main.greet("Jenkins").equals("Hello, Jenkins!") : "Test failed: greet('Jenkins')";
        System.out.println("All tests passed.");
    }
}
