
    abstract class Car{
    private String engine;
    private String transmission;
    private String mileage;
    private String odometer;

    abstract void startCar();

    }

    class Honda extends Car{
        @Override
        void startCar() {
            System.out.println("Starting Honda");
        }


    public static void main(String[] args) {
        System.out.println("Hello World!");

        Honda honda = new Honda();
        honda.startCar();
    }
}