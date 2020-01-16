import java.util.HashMap;

public class ConstructorFlyWeight {
    // 非享元角色
    class UnsharedFlyWeight{
        private String info;
        UnsharedFlyWeight(String info){
            this.info = info;
        }
        public String getInfo() {
            return info;
        }
        public void setInfo(String info) {
            this.info = info;
        }
    }
    // 抽象享元角色
    interface FlyWeight{
        void operation(UnsharedFlyWeight unsharedFlyWeight);
    }
    // 具体享元角色
    class ConcreteFlyWeight implements FlyWeight{
         private String key;
         ConcreteFlyWeight(String key){
             this.key = key;
             System.out.println("享元" + key + "被创建");
         }
         public void operation(UnsharedFlyWeight unsharedFlyWeight) {
            System.out.println("具体享元" + key + "被调用");
            unsharedFlyWeight.getInfo();
        }
    }
    // 享元工厂
    class FlyWeightFactory{
        HashMap<String, FlyWeight> map = new HashMap<String, FlyWeight>();
        FlyWeight createFlyWeight(String key){
            FlyWeight flyWeight = map.get(key);
            if (flyWeight != null) {
                System.out.println("具体享元" + key + "已被创建");
            } else {
                flyWeight = new ConcreteFlyWeight(key);
                map.put(key, flyWeight);
            }
            return flyWeight;
        }
    }
    public static void main(String[] args) {
        ConstructorFlyWeight flyWeight = new ConstructorFlyWeight();
        flyWeight.testFlyWeight();
    }
    public void testFlyWeight(){
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight fw1 = factory.createFlyWeight("A");
        fw1.operation(new UnsharedFlyWeight("A_INFO"));
        FlyWeight fw2 = factory.createFlyWeight("B");
        fw2.operation(new UnsharedFlyWeight("B_INFO"));
        FlyWeight fw3 = factory.createFlyWeight("A");
    }
}
