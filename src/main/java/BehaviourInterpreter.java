import java.util.HashSet;
import java.util.Set;

public class BehaviourInterpreter {
    // 设计一个“京津通”公交车卡的读卡器程序
    interface AbstractExpression{
        Boolean interpreter(String info);
    }
    class TerminalExpression implements AbstractExpression{
        private Set<String> expression = new HashSet<String>();
        TerminalExpression(String[] array){
            for (String e : array) {
                expression.add(e);
            }
        }
        public Boolean interpreter(String info) {
            if (expression.contains(info)) {
                return true;
            } else {
                return false;
            }
        }
    }
    class NoTerminalExpression implements AbstractExpression{
        AbstractExpression city;
        AbstractExpression person;
        NoTerminalExpression(AbstractExpression city, AbstractExpression person){
            this.city = city;
            this.person = person;
        }
        public Boolean interpreter(String info) {
            String[] s = info.split("的");
            return city.interpreter(s[0]) && person.interpreter(s[1]);
        }
    }
    class Context{
        String[] array_city = {"北京", "天津"};
        String[] array_person = {"老人", "妇女", "儿童"};
        AbstractExpression city_person;
        Context(){
            AbstractExpression city = new TerminalExpression(array_city);
            AbstractExpression person = new TerminalExpression(array_person);
            city_person = new NoTerminalExpression(city, person);
        }
        Boolean freeRide(String info){
            return city_person.interpreter(info);
        }
        void print(Context context, String info){
            if (context.freeRide(info)) {
                System.out.println(info + "可以免费乘车");
            } else {
                System.out.println(info + "不可以免费乘车");
            }
        }
    }
    public static void main(String[] args) {
        BehaviourInterpreter interpreter = new BehaviourInterpreter();
        interpreter.testInterpreter();
    }
    public void testInterpreter(){
        Context context = new Context();
        String info1 = "北京的老人";
        String info2 = "天津的青年";
        context.print(context, info1);
        context.print(context, info2);
    }
}
