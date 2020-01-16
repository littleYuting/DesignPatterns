public class BehaviourCommand {
    // 用命令模式实现客户去餐厅吃早餐，点餐是命令，服务员是调用者，厨师是接收者
    class Waiter{
        OrderBreakfast eatHunDun, eatJuanBing;

        public void chooseEatHunDun() {
            eatHunDun.orderInfo();
        }
        public void setEatHunDun(OrderBreakfast eatHunDun) {
            this.eatHunDun = eatHunDun;
        }
        public void chooseEatJuanBing() {
            eatJuanBing.orderInfo();
        }
        public void setEatJuanBing(OrderBreakfast eatJuanBing) {
            this.eatJuanBing = eatJuanBing;
        }
    }
    interface OrderBreakfast{
        void orderInfo();
    }
    class HunDun implements OrderBreakfast{
        Chief_HunDun chief_hunDun;
        HunDun(){
            chief_hunDun = new Chief_HunDun();
        }
        public void orderInfo() {
            chief_hunDun.print();
        }
    }
    class JuanBing implements OrderBreakfast{
        Chief_JuanBing chief_juanBing;
        JuanBing(){
            chief_juanBing = new Chief_JuanBing();
        }
        public void orderInfo() {
            chief_juanBing.print();
        }
    }
    class Chief_HunDun{
        void print(){
            System.out.println("收到一单做混沌的命令");
        }
    }
    class Chief_JuanBing{
        void print(){
            System.out.println("收到一单做卷饼的命令");
        }
    }
    public static void main(String[] args) {
        BehaviourCommand command = new BehaviourCommand();
        command.testCommand();
    }
    public void testCommand(){
        Waiter waiter = new Waiter();
        OrderBreakfast order = new JuanBing();
        waiter.setEatJuanBing(order);
        waiter.chooseEatJuanBing();
    }
}
