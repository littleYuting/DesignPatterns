public class CreatorAbstractFactory {
   static class Role{
        private Work work; private Fun fun;
        Role(Work work, Fun fun){
           this.work = work;
           this.fun = fun;
        }
        void printInfo(){
            System.out.println("show composed role:");
            work.print();
            fun.print();
        }
   }
    interface RoleFactory{
        Work makerWork();
        Fun makerFun();
    }
    static class stuFactory implements RoleFactory{
        public Work makerWork() { return new StuWork(); }
        public Fun makerFun() { return new StuFun(); }
    }
    static class teaFactory implements RoleFactory{
        public Work makerWork() {
            return new TeaWork();
        }
        public Fun makerFun() {
            return new TeaFun();
        }
    }
    interface Work{ void print();}
    interface Fun{ void print();}
    static class StuWork implements Work{
        public void print() {
            System.out.println("创建 student work");
        }
    }
    static class TeaWork implements Work{
        public void print() {
            System.out.println("创建 teacher work");
        }
    }
    static class StuFun implements Fun{
        public void print() {
            System.out.println("创建 student fun");
        }
    }
    static class TeaFun implements Fun{
        public void print() {
            System.out.println("创建 teacher fun");
        }
    }
    public static void main(String[] args) {
        RoleFactory student = new stuFactory();
        Work stuWork = student.makerWork();
        RoleFactory teacher = new teaFactory();
        Fun teaFun = teacher.makerFun();
        Role role = new Role(stuWork, teaFun);
        role.printInfo();
    }
}
