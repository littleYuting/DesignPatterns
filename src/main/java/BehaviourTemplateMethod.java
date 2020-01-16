public class BehaviourTemplateMethod {
    abstract class FryVegetable{
        public final void process(){
            this.pourOil();
            this.heatOil();
            this.pourVegetable();
            this.pourSource();
            this.fry();
        }
        void pourOil(){
            System.out.println("倒油");
        }
        void heatOil(){
            System.out.println("热油");
        }
        abstract void pourVegetable();
        abstract void pourSource();
        void fry(){
            System.out.println("炒菜");
        }
    }
    class FryCabbage extends FryVegetable{
        void pourVegetable() {
            System.out.println("倒入包菜");
        }
        void pourSource() {
            System.out.println("加入蚝油");
        }
    }
    class FryCarrot extends FryVegetable{
        void pourVegetable() {
            System.out.println("倒入胡萝卜");
        }
        void pourSource() {
            System.out.println("加入料酒");
        }
    }
    public static void main(String[] args) {
        BehaviourTemplateMethod method = new BehaviourTemplateMethod();
        method.testCook();
    }
    public void testCook(){
        FryVegetable cabbage = new FryCabbage();
        cabbage.process();
        FryVegetable carrot = new FryCarrot();
        carrot.process();
    }
}
