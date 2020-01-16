public class BehaviourState {
    //用“状态模式”设计一个学生成绩的状态转换程序。
    //包含 3 种状态，当学生的分数小于 60 分时为“不及格”状态，当分数大于等于 60 分且小于 90 分时为“中等”状态，当分数大于等于 90 分时为“优秀”状态
    class ScoreContext{
        AbstractState abstractState;
        ScoreContext(){
            abstractState = new LowState(this);
        }
        public AbstractState getAbstractState() {
            return abstractState;
        }
        public void setAbstractState(AbstractState abstractState) {
            this.abstractState = abstractState;
        }
        void add(int score){
            abstractState.addScore(score);
        }
    }
    abstract class AbstractState{
        ScoreContext context;
        String state_name;
        int score;
        public String getState_name() {
            return state_name;
        }
        public void setState_name(String state_name) {
            this.state_name = state_name;
        }
        void addScore(int num){
            score += num;
            System.out.print("加分：" + num + "，现分数为：" + score);
            checkState();
            System.out.println("，加分后状态重新调整为：" + context.getAbstractState().getState_name());
        }
        void updateState(AbstractState state){
            context = state.context;
            score = state.score;
        }
        abstract void checkState();
    }
    class LowState extends AbstractState{
        LowState(ScoreContext context){
            this.context = context;
            score = 0;
            state_name = StateName.low;
        }
        LowState(AbstractState state){
            updateState(state);
            state_name = StateName.low;
        }
        void checkState() {
            if (score > Critic.up) {
                context.setAbstractState(new HighState(this));
            }
            else if (score > Critic.low) {
                context.setAbstractState(new MiddleState(this));
            }
            else {
                context.setAbstractState(new LowState(this));
            }
        }
    }
    class MiddleState extends AbstractState{
        MiddleState(AbstractState state){
            updateState(state);
            state_name = StateName.middle;
        }
        void checkState() {
            if (score < Critic.low) {
                context.setAbstractState(new LowState(this));
            }
            else if (score > Critic.up) {
                context.setAbstractState(new HighState(this));
            }
        }
    }
    class HighState extends AbstractState{
        HighState(AbstractState state){
            updateState(state);
            state_name = StateName.high;
        }
        void checkState() {
            if (score < Critic.low) {
                context.setAbstractState(new LowState(this));
            }
            else if (score < Critic.up) {
                context.setAbstractState(new MiddleState(this));
            }
        }
    }
    static class Critic{
        static private int low;
        static private int up;
        public static void setLow(int low) {
            Critic.low = low;
        }
        public static void setUp(int up) {
            Critic.up = up;
        }
    }
    static class StateName{
        static private String low;
        static private String middle;
        static private String high;
        public static void setLow(String low) {
            StateName.low = low;
        }
        public static void setMiddle(String middle) {
            StateName.middle = middle;
        }
        public static void setHigh(String high) {
            StateName.high = high;
        }
    }
    public static void main(String[] args) {
        BehaviourState state = new BehaviourState();
        state.testState();
    }
    public void testState(){
        ScoreContext context = new ScoreContext();
        Critic.setLow(60); Critic.setUp(90);
        StateName.setLow("不及格"); StateName.setMiddle("中等"); StateName.setHigh("优秀");
        context.add(40);
        context.add(30);
        context.add(25);
        context.add(-40);
    }
}
