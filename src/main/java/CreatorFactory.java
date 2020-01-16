public class CreatorFactory {
    interface RoleFactory{
        Role creator(String name);
    }
    interface Role{ void print(); }
    static class StuWork implements Role{ public void print() { System.out.println("student work"); }}
    static class StuFun implements Role{ public void print() { System.out.println("student fun"); } }
    static class TeaWork implements Role{ public void print() { System.out.println("teacher work"); } }
    static class TeaFun implements Role{ public void print() { System.out.println("teacher fun"); } }
    static class StuFactory implements RoleFactory{
        public Role creator(String name) {
            if (name.equals("sw")) { return new StuWork(); }
            else if (name.equals("sf")) { return new StuFun(); }
            return null;
        }
    }
    static class TeaFactory implements RoleFactory{
        public Role creator(String name) {
            if (name.equals("tw")) { return new TeaWork(); }
            else if (name.equals("tf")) { return new TeaFun(); }
            return null;
        }
    }
    public static void main(String[] args) {
        RoleFactory student = new StuFactory();
        student.creator("sf").print();
        RoleFactory teacher = new TeaFactory();
        teacher.creator("tw").print();
    }
}
