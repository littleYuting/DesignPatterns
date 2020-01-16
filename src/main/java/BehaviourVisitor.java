import java.util.ArrayList;
import java.util.List;

public class BehaviourVisitor {
    // 如果老师教学反馈得分大于等于85分、学生成绩大于等于90分，则可以入选成绩优秀奖；如果老师论文数目大于8、学生论文数目大于2，则可以入选科研优秀奖;
    // 抽象访问者
    interface Visitor {
        void visit(Student student);
        void visit(Teacher teacher);
    }
    // 具体访问者：以成绩进行评选
    class GradeVisitor implements Visitor {
        String awardWords = "[%s]的分数为：%d，荣获成绩优秀奖";
        public void visit(Student element) {
            if (element.getGrade() > 90) {
                System.out.println(String.format(awardWords, element.getName(), element.getGrade()));
            }
        }
        public void visit(Teacher element) {
            if (element.getGrade() > 85) {
                System.out.println(String.format(awardWords, element.getName(), element.getGrade()));
            }
        }
    }
    // 具体访问者：以论文数目进行评选
    class PaperVisitor implements Visitor {
        String awardWords = "[%s]的论文数为：%d，荣获科研优秀奖";
        public void visit(Student element) {
            if (element.getPaperNum() >= 2) {
                System.out.println(String.format(awardWords, element.getName(), element.getPaperNum()));
            }
        }
        public void visit(Teacher element) {
            if (element.getPaperNum() > 8) {
                System.out.println(String.format(awardWords, element.getName(), element.getPaperNum()));
            }
        }
    }
    // 抽象元素类
    abstract class Element {
        String name;
        Integer paperNum;
        Integer grade;
        public Element(String name, Integer paperNum, Integer grade) {
            this.name = name;
            this.paperNum = paperNum;
            this.grade = grade;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getPaperNum() {
            return paperNum;
        }
        public void setPaperNum(Integer paperNum) {
            this.paperNum = paperNum;
        }
        public Integer getGrade() {
            return grade;
        }
        public void setGrade(Integer grade) {
            this.grade = grade;
        }
        abstract void accept(Visitor visitor);
    }
    // 具体元素类：老师
    class Teacher extends Element {
        public Teacher(String name, Integer paperNum, Integer grade) {
            super(name, paperNum, grade);
        }
        void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
    // 具体元素类：学生
    class Student extends Element {
        public Student(String name, Integer paperNum, Integer grade) {
            super(name, paperNum, grade);
        }
        void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
    // 元素结构类
    class ObjectConstruct {
        private List<Element> elements = null;
        Visitor visitor;
        ObjectConstruct(Visitor visitor){
            elements = new ArrayList<Element>();
            this.visitor = visitor;
        }
        void add(Element element){
            elements.add(element);
        }
        void remove(Element element){
            elements.remove(element);
        }
        void traverse(){
            for (Element e:elements) {
                e.accept(visitor);
            }
        }
    }
    public static void main(String[] args) {
        BehaviourVisitor visitor = new BehaviourVisitor();
        visitor.testVisitor();
    }
    public void testVisitor(){
        Visitor paperVisitor = new PaperVisitor();
        ObjectConstruct construct = new ObjectConstruct(paperVisitor);
        Student student = new Student("cyt", 2, 85);
        Teacher teacher = new Teacher("Jin", 7, 89);
        construct.add(student);
        construct.add(teacher);
        construct.traverse();
    }
}
