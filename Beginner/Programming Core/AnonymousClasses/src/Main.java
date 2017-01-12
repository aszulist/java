class Machine {
    public void start() {
        System.out.println("Starting machine ...");
    }
}

interface Plant {
    void grown();
}

public class Main {

    public static void main(String[] args) {

        Machine machine1 = new Machine() {
            @Override
            public void start() {
                System.out.println("Camera snapping ...");
            }
        };

        machine1.start();

        Plant plant1 = new Plant() {

            @Override
            public void grown() {
                System.out.println("Plant is growing...");
            }
        };

        plant1.grown();

    }
}
