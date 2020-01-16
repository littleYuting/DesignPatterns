public class ConstructorProxy {
    interface Subject{
        void request();
    }
    static class RealSubject implements Subject{
        public void request() {
            System.out.println("show real information of realSubject");
        }
    }
    static class Proxy implements Subject{
        private RealSubject realSubject;
        public void request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }
            preRequest();
            realSubject.request();
            postRequest();
        }
        public void preRequest(){
            System.out.println("show the pre_request");
        }
        public void postRequest(){
            System.out.println("show the post_request");
        }
    }
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
