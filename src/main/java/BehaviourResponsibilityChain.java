public class BehaviourResponsibilityChain {
    //用责任链模式设计一个请假条审批模块。
    //假如规定学生请假，班主任可以批准；小于或等于 7 天，系主任可以批准；小于或等于 10 天，院长可以批准；其他情况不予批准；
    abstract class Leader{
        Leader next = null;
        String name;
        Integer critic;
        Leader(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public Integer getCritic() {
            return critic;
        }
        public void setCritic(Integer critic) {
            this.critic = critic;
        }
        void setNext(Leader leader){
            next = leader;
        }
        Leader getNext(){
            return next;
        }
        void handleRequest(int leave){
            if (leave <= getCritic()) {
                System.out.println(this.getName() + "批准假期： " + leave + "天");
            } else {
                if (getNext() != null) {
                    getNext().handleRequest(leave);
                } else {
                    System.out.println("请假天数太多，没人批准该假条");
                }
            }
        }
    }

    class Teacher extends Leader{
        Teacher(String name) {
            super(name);
        }
    }
    class ChairMan extends Leader{
        ChairMan(String name) {
            super(name);
        }
    }
    class Dean extends Leader{
        Dean(String name) {
            super(name);
        }
    }
    public static void main(String[] args) {
        BehaviourResponsibilityChain chain = new BehaviourResponsibilityChain();
        chain.testResponsibility();
    }
    public void testResponsibility(){
        Leader dean = new Dean("院长");
        dean.setCritic(10);
        Leader chairMan = new ChairMan("系主任");
        chairMan.setCritic(7);
        Leader teacher = new Teacher("班主任");
        teacher.setCritic(2);
        dean.setNext(null);
        chairMan.setNext(dean);
        teacher.setNext(chairMan);
        teacher.handleRequest(5);
    }
}
