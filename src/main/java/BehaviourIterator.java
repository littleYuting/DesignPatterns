import java.util.ArrayList;
import java.util.List;

public class BehaviourIterator {
    // 实现一个自定义迭代器

    // 抽象聚合类
    interface AbstractAggregate {
        void add(Object obj);
        void remove(Object obj);
        MyIterator getIterator();
    }
    // 具体聚合类
    class ConcreteAggregate implements AbstractAggregate{
        List<Object> objects;
        ConcreteAggregate(){
            objects = new ArrayList<Object>();
        }
        public void add(Object obj) {
            objects.add(obj);
        }
        public void remove(Object obj) {
            objects.remove(obj);
        }
        public MyIterator getIterator() {
            return new concreteIterator(objects);
        }
    }
    // 抽象迭代器
    interface MyIterator {
        Object first();
        Object next();
        Boolean hasNext();
    }
    // 具体迭代器
    class concreteIterator implements MyIterator{
        List<Object> objects = null;
        int index = -1;
        concreteIterator(List<Object> objects){
            this.objects = objects;
        }
        public Object first() {
            return objects.get(0);
        }
        public Object next() {
            if (hasNext()) {
                index += 1;
                return objects.get(index);
            }
            return null;
        }
        public Boolean hasNext() {
            if (index < objects.size() - 1) {
                return true;
            } else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        BehaviourIterator iterator = new BehaviourIterator();
        iterator.testIterator();
    }
    public void testIterator(){
        AbstractAggregate aggregate = new ConcreteAggregate();
        aggregate.add("cyt");
        aggregate.add("cyb");
        aggregate.add("zgx");
        aggregate.add("cjf");
        aggregate.remove("cyt");
        MyIterator iterator = aggregate.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
