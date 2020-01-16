public class BehaviourMediator {
    // 有两个类A和B，类中各有一个数字，并且要保证类B中的数字永远是类A中数字的100倍，即类A类B互相影响（同事类）；
    abstract class AbstractColleague{
        protected int number;
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
        public abstract void dealWork(int number, Mediator mediator);
    }
    class ColleagueA extends AbstractColleague{
        public void dealWork(int number, Mediator mediator) {
            this.number = number;
            mediator.affectB();
        }
    }
    class ColleagueB extends AbstractColleague{
        public void dealWork(int number, Mediator mediator) {
            this.number = number;
            mediator.affectA();
        }
    }
    abstract class Mediator {
        protected ColleagueA colleagueA;
        protected ColleagueB colleagueB;
        Mediator(ColleagueA colleagueA, ColleagueB colleagueB){
            this.colleagueA = colleagueA;
            this.colleagueB = colleagueB;
        }
        abstract void affectA();
        abstract void affectB();
    }
    class ConcreteMediator extends Mediator{
        ConcreteMediator(ColleagueA colleagueA, ColleagueB colleagueB) {
            super(colleagueA, colleagueB);
        }
        void affectA() {
            int number = colleagueB.getNumber();
            colleagueA.setNumber(number/100);
        }
        void affectB() {
            int number = colleagueA.getNumber();
            colleagueB.setNumber(number*100);
        }
    }
    public static void main(String[] args) {
        BehaviourMediator mediator = new BehaviourMediator();
        mediator.testMediator();
    }
    public void testMediator(){
        ColleagueA colleagueA = new ColleagueA();
        ColleagueB colleagueB = new ColleagueB();
        Mediator mediator = new ConcreteMediator(colleagueA, colleagueB);
        System.out.println("通过设置 A 类 来影响 B 类");
        colleagueA.dealWork(30, mediator);
        System.out.println("A 类的值为：" + colleagueA.getNumber());
        System.out.println("B 类的值为：" + colleagueB.getNumber());
        System.out.println("通过设置 B 类 来影响 A 类");
        colleagueB.dealWork(100, mediator);
        System.out.println("A 类的值为：" + colleagueA.getNumber());
        System.out.println("B 类的值为：" + colleagueB.getNumber());
    }
}
