interface Executable {
    int execute(int number, int number2);
}

interface StringExecutable {
    int execute(String a);
}

class Runner{

    public void run(Executable e) {
        System.out.println("Executing code block ....");
        int value = e.execute(12, 13);
        System.out.println("Return value is: " + value);
    }

    public void run(StringExecutable e) {
        System.out.println("Executing code block ....");
        int value = e.execute("Hello");
        System.out.println("Return value is: " + value);
    }
}


public class Main {

    public static void main(String[] args) {

        int c = 100;

        int d = 77;

        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public int execute(int number, int number2) {
                System.out.println("Hello there.");
                int d = 8;
                return number + number2 + c;
            }
        });

        System.out.println("====================");

        runner.run((a, b) -> {
            System.out.println("Hello there");
            return 8 + a + b + c;
        });

        System.out.println("====================");

        Executable ex = (a, b) -> {
            System.out.println("Hello there.");
            return a + b + c;
        };

        Object codeblock = (Executable)(a, b) -> {
            System.out.println("Hello there.");
            return a + b + c;
        };

    }

}
