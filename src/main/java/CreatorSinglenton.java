public class CreatorSinglenton {
    public static void main(String[] args) {
//        lazySingleton();
        hungrySingleton();
    }

    public static void lazySingleton(){
        Sun sun1 = Sun.getSun();
        Sun sun2 = Sun.getSun();
        if (sun1 == sun2) {
            System.out.println("only have one sun");
        } else {
            System.out.println("singleton verify failed");
        }
    }

    public static void hungrySingleton(){
        Moon moon1 = Moon.getMoon();
        Moon moon2 = Moon.getMoon();
        if (moon1 == moon2) {
            System.out.println("only have one moon");
        }
    }
}
class Sun{
    private static volatile Sun sun = null;
    private Sun(){}
    public synchronized static Sun getSun(){
        if(sun == null){
            System.out.println("now u have only little sun");
            sun = new Sun();
        }else{
            System.out.println("sun have already created");
        }
        return sun;
    }
}
class Moon{
    private static final Moon moon = new Moon();
    private Moon(){}
    public static Moon getMoon(){
        return moon;
    }
}