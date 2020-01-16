public class ConstructorAdapter {
    // 目标接口
    interface Target{
        void request();
    }
    // 适配者接口
    static class Adaptee{
        void specificRequest(){
            System.out.println("适配者中的业务代码被调用");
        }
    }
    // 类适配器接口
    static class ClassAdapter extends Adaptee implements Target{
        public void request() {
            specificRequest();
        }
    }
    // 对象适配器接口
    static class ObjectAdapter implements Target{
        private Adaptee adaptee;
        ObjectAdapter(Adaptee adaptee){
            this.adaptee = adaptee;
        }
        public void request() {
            adaptee.specificRequest();
        }
    }
    public static void main(String[] args) {
        Target target1 = new ClassAdapter();
        target1.request();

        Target target2 = new ObjectAdapter(new Adaptee());
        target2.request();
    }
}
