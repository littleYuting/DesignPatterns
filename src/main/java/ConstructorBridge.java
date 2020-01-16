public class ConstructorBridge {
    // 女士皮包有很多种，可以按用途分、按皮质分、按品牌分、按颜色分、按大小分等，存在多个维度的变化；
    // 实现化角色1 Color
    interface Color{
        String getColor();
    }
    // 实现化角色2 Size
    interface Size{
        String getSize();
    }
    // 具体实现化角色1
    static class Red implements Color{
        public String getColor() { return "red"; }
    }
    static class Yellow implements Color{
        public String getColor() { return "yellow"; }
    }
    // 具体实现化角色2
    static class Little implements Size{
        public String getSize() { return "little"; }
    }
    static class Big implements Size{
        public String getSize() { return "big"; }
    }
    // 抽象化角色类
    abstract class Bag{
        protected Color color;
        protected Size size;
        Bag(Color color, Size size){
            this.color = color;
            this.size = size;
        }
        abstract String getName();
    }
    // 扩展抽象化角色类
    class HandBag extends Bag{
        HandBag(Color color, Size size) {
            super(color, size);
        }
        String getName() {
            return "手提包, 对应颜色：" + color.getColor() + "，对应尺寸：" + size.getSize();
        }
    }
    class Wallet extends Bag{
        Wallet(Color color, Size size) {
            super(color, size);
        }
        String getName() {
            return "钱包, 对应颜色：" + color.getColor() + "，对应尺寸：" + size.getSize();
        }
    }
    public static void main(String[] args) {
        ConstructorBridge bridge = new ConstructorBridge();
        bridge.testBridge();
    }
    public void testBridge(){
        Bag bag1 = new HandBag(new Red(),new Big());
        Bag bag2 = new Wallet(new Yellow(),new Little());
        System.out.println(bag1.getName());
        System.out.println(bag2.getName());
    }
}
