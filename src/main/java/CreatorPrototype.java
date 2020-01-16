import java.io.*;
import java.util.Arrays;


public class CreatorPrototype {
    public static void main(String[] args) {
        shadowClone();
//        deepClone();
    }

    public static void shadowClone(){
        class Shadow extends CloneClass implements Cloneable{
            @Override
            public Shadow clone(){
                Shadow s = null;
                try {
                    s = (Shadow) super.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                return s;
            }
        }
        Shadow s1 = new Shadow();
        s1.setA(10);
        s1.setB("original");
        s1.setC(new int[]{1000});
        System.out.println("s1 克隆前：" + s1);
        Shadow s2 = s1.clone();
        s2.setA(20);
        s2.setB("shadowClone");
        int[] c1 = s2.getC();
        c1[0] = 500;
        s2.setC(c1);
        System.out.println("克隆的 s2：" + s2);
        System.out.println("s1 克隆后：" + s1);
    }

    public static void deepClone(){
        // still have error
        class Deep extends CloneClass implements Serializable {}
        class Test{
            public Object deepClone(Object src){
                Object o = null;
                try
                {
                    if (src != null)
                    {
                        ByteArrayOutputStream baos =new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(baos);
                        oos.writeObject(src);
                        oos.close();
                        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                        ObjectInputStream ois = new ObjectInputStream(bais);
                        o = ois.readObject();
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return o;
            }
        }

        Deep s1 = new Deep();
        s1.setA(10);
        s1.setB("original");
        s1.setC(new int[]{1000});
        System.out.println("s1 克隆前：" + s1);
        Deep s2 = (Deep) new Test().deepClone(s1);
        System.out.println(s2.getC());
        System.out.println(s2.getA());
        s2.setA(20);
        s2.setB("shadowClone");
        int[] c1 = s2.getC();
        c1[0] = 500;
        s2.setC(c1);
        System.out.println("克隆的 s2：" + s2);
        System.out.println("s1 克隆后：" + s1);
    }
}
class CloneClass{
    int a;
    String b;
    int[] c;
    CloneClass(){}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int[] getC() {
        return c;
    }

    public void setC(int[] c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "CloneClass{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + Arrays.toString(c) +
                '}';
    }
}