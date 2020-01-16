public class BehaviourMemento {
    // 备忘录
    class Memento {
        String state;
        Memento(String state){
            this.state = state;
        }
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
    }
    // 发起者
    class Originator {
        private String state;
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
        Memento createMemento(){
            return new Memento(state);
        }
        void storeMemento(Memento memento){
            this.setState(memento.state);
        }
    }
    // 管理者
    class CareTaker {
        private Memento memento;
        public Memento getMemento() {
            return memento;
        }
        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }
    public static void main(String[] args) {
        BehaviourMemento memento = new BehaviourMemento();
        memento.testMemento();
    }
    public void testMemento(){
        Originator originator = new Originator();
        originator.setState("初始状态");
        Memento memento = originator.createMemento();
        System.out.println(memento.getState());
        memento.setState("保存更新状态");
        originator.storeMemento(memento);
        System.out.println(memento.getState());
    }
}
