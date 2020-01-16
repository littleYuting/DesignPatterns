public class ConstructorDecorator {
    // 不同咖啡豆和不同流质可生成不同口味的组合的咖啡饮料
    // 抽象构件
    interface Beverage{
        String getDescription();
        Double getPrice();
    }
    // 具体构件1
    class CoffeeBean1 implements Beverage{
        private String description = "第一种咖啡豆";
        public String getDescription() {
            return description;
        }
        public Double getPrice() {
            return 50.0;
        }
    }
    // 具体构件2
    class CoffeeBean2 implements Beverage{
        private String description = "第二种咖啡豆";
        public String getDescription() {
            return description;
        }
        public Double getPrice() {
            return 100.0;
        }
    }
    // 抽象装饰类
    class Decorator implements Beverage{
        protected Beverage beverage;
//        Decorator(Beverage beverage){
//            this.beverage = beverage;
//        }
        public String getDescription() {
            return beverage.getDescription();
        }
        public Double getPrice() {
            return beverage.getPrice();
        }
    }
    // 装饰角色1
    class Milk extends Decorator{
        private Beverage beverage = null;
        Milk(Beverage beverage) {
//            super(beverage); // 会报空指针异常
            this.beverage = beverage;
        }
        public String getDescription() {
            return beverage.getDescription() + addFunc();
        }
        public Double getPrice() {
            return beverage.getPrice() + 10;// 10 为牛奶的价格
        }
        public String addFunc(){
            return  ",加了牛奶";
        }
    }
    // 装饰角色2
    class Mocha extends Decorator{
        private Beverage beverage = null;
        Mocha(Beverage beverage) {
            this.beverage = beverage;
        }
        public String getDescription() {
            return beverage.getDescription() + addFunc();
        }
        public Double getPrice() {
            return beverage.getPrice() + 20;
        }
        public String addFunc(){
            return ",加了摩卡";
        }
    }
    // 装饰角色3
    class Soy extends Decorator{
        private Beverage beverage = null;
        Soy(Beverage beverage) {
            this.beverage = beverage;
        }
        public String getDescription() {
            return beverage.getDescription() + addFunc();
        }
        public Double getPrice() {
            return beverage.getPrice() + 30;
        }
        public String addFunc(){
            return ",加了豆浆";
        }
    }
    public static void main(String[] args) {
        ConstructorDecorator decorator = new ConstructorDecorator();
        decorator.testDecorator();
    }
    public  void testDecorator(){
         Beverage beverage = new CoffeeBean1();
         beverage = new Milk(beverage);
         beverage = new Soy(beverage);
         System.out.println(beverage.getDescription() + ",总价格为：" + beverage.getPrice());
    }
}
