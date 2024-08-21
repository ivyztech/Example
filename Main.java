public class Main {

    public static String greet(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        String userName = "World";
        if (args.length > 0) {
            userName = args[0];
        }
        System.out.println(greet(userName));
    }
}
