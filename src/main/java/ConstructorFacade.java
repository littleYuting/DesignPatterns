public class ConstructorFacade {
    class Light{
        void makeOn(){
            System.out.println("开灯");
        }
    }
    class TV{
        void makeOpen(){
            System.out.println("打开电视");
        }
    }
    class Aircondition{
        void makeWork(){
            System.out.println("打开空调");
        }
    }
    class Facade{
        private Light light;
        private TV tv;
        private Aircondition aircondition;
        Facade(Light light, TV tv, Aircondition aircondition){
            this.light = light;
            this.tv = tv;
            this.aircondition = aircondition;
        }
        void on(){
            light.makeOn();
            tv.makeOpen();
            aircondition.makeWork();
        }
    }
    public static void main(String[] args) {
        ConstructorFacade facade = new ConstructorFacade();
        facade.testFacade();
    }
    private void testFacade(){
        Facade facade = new Facade(new Light(),new TV(),new Aircondition());
        facade.on();
    }
}
