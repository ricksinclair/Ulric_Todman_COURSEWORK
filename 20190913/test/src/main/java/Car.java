
    abstract class Car{
    private String engine;
    private String transmission;
    private String mileage;
    private String odometer;

    abstract void startCar();

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getTransmission() {
            return transmission;
        }

        public void setTransmission(String transmission) {
            this.transmission = transmission;
        }

        public String getMileage() {
            return mileage;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
        }

        public String getOdometer() {
            return odometer;
        }

        public void setOdometer(String odometer) {
            this.odometer = odometer;
        }
    }

    class Honda extends Car{
        @Override
        void startCar() {
            System.out.println("Starting Honda");
        }


    public static void main(String[] args) {
        System.out.println("Hello World!");

        Car honda = new Honda();
        honda.startCar();

        honda.setEngine("2.5L V4");
        honda.setTransmission("Automatic");

    }
}