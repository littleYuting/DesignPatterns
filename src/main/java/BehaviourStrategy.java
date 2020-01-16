public class BehaviourStrategy {
    interface Strategy{
        Integer calculate(int a, int b);
    }
    class AddStrategy implements Strategy{
        public Integer calculate(int a, int b) {
            return a + b;
        }
    }
    class SubtractStrategy implements Strategy{
        public Integer calculate(int a, int b) {
            return a - b;
        }
    }
    class Context{
        Strategy strategy;
        Context(Strategy strategy){
            this.strategy = strategy;
        }
        void dynamicReplace(Strategy applyStrategy){
            this.strategy = applyStrategy;
        }
        Integer calculate(int a, int b){
            return strategy.calculate(a,b);
        }
    }
    public static void main(String[] args) {
        BehaviourStrategy strategy = new BehaviourStrategy();
        strategy.testStrategy();
    }
    public void testStrategy(){
        Strategy add = new AddStrategy();
        Context context = new Context(add);
        context.dynamicReplace((Strategy) new SubtractStrategy());
        System.out.println(context.calculate(10,2));
    }
}
