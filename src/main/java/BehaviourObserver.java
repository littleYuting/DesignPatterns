import java.util.*;

public class BehaviourObserver {
    //利用观察者模式设计一个学校铃声的事件处理程序

    //铃声事件类：用于封装事件源及一些与事件相关的参数
    class RingEvent extends EventObject{
        private boolean sound;
        public RingEvent(Object source, boolean sound) {
            super(source);
            this.sound = sound;
        }
        public boolean isSound() {
            return sound;
        }
        public void setSound(boolean sound) {
            this.sound = sound;
        }
    }
    //目标类：事件源，铃
    class BellEventSource {
        private List<BellEventListener> listeners;
        BellEventSource(){
            listeners = new ArrayList<BellEventListener>();
        }
        // 监听器的绑定与解除
        void addListener(BellEventListener listener){
            listeners.add(listener);
        }
        void removeListener(BellEventListener listener){
            listeners.remove(listener);
        }
        // 铃声事件触发器
        public void ring(Boolean sound){
            String ring_type = sound ? "上课铃" : "下课铃";
            System.out.println(ring_type + "响");
            RingEvent event = new RingEvent(this, sound);
            notifies(event);
        }
        public void notifies(RingEvent event){
            for (BellEventListener listener:listeners) {
                listener.hearRing(event);
            }
        }
    }
    //抽象观察者类：铃声事件监听器
    interface BellEventListener extends EventListener {
        void hearRing(RingEvent event);
    }
    //具体观察者类：老师事件监听器
    class TeacherListener implements BellEventListener{
        public void hearRing(RingEvent event) {
            if (event.isSound()) {
                System.out.println("老师上课了");
            } else {
                System.out.println("老师下课啦");
            }
        }
    }
    //具体观察者类：学生事件监听器
    class StudentListener implements BellEventListener{
        public void hearRing(RingEvent event) {
            if (event.isSound()) {
                System.out.println("学生上课了");
            } else {
                System.out.println("学生下课啦");
            }
        }
    }
    public static void main(String[] args) {
        BehaviourObserver observer = new BehaviourObserver();
        observer.testObserver();
    }
    public void testObserver(){
        BellEventSource source = new BellEventSource();
        source.addListener(new TeacherListener());
        source.addListener(new StudentListener());
        source.ring(true);
        source.ring(false);
    }
}
