public class CreatorBuilder {
    // 产品类
    static class Computer{
        private String cpu ; // cpu
        private String hardDisk ; //硬盘
        private String mainBoard ; // 主板
        private String memory ; // 内存

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public String getHardDisk() {
            return hardDisk;
        }

        public void setHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
        }

        public String getMainBoard() {
            return mainBoard;
        }

        public void setMainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
        }

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "cpu='" + cpu + '\'' +
                    ", hardDisk='" + hardDisk + '\'' +
                    ", mainBoard='" + mainBoard + '\'' +
                    ", memory='" + memory + '\'' +
                    '}';
        }
    }
    // 抽象构造类
    interface Builder{
        void createCpu(String cpu);
        void createHardDisk(String hardDisk);
        void createMainBoard(String mainBoard);
        void createMemory(String memory);
        Computer createComputer();
    }
    // 具体构造类
    static class AssemblerBuilder implements Builder{
        private Computer computer = new Computer();
        public void createCpu(String cpu) {
            computer.setCpu(cpu);
        }
        public void createHardDisk(String hardDisk) {
            computer.setHardDisk(hardDisk);
        }
        public void createMainBoard(String mainBoard) {
            computer.setMainBoard(mainBoard);
        }
        public void createMemory(String memory) {
            computer.setMemory(memory);
        }
        public Computer createComputer() {
            return computer;
        }
    }
    // 指挥类
    static class Director{
        private Builder builder;
        Director(Builder builder){
            this.builder = builder;
        }
        Computer getComputer(String cpu, String hardDisk, String mainBoard, String memory){
            this.builder.createCpu(cpu);
            builder.createHardDisk(hardDisk);
            builder.createMainBoard(mainBoard);
            builder.createMemory(memory);
            return builder.createComputer();
        }
    }
    public static void main(String[] args) {
        Builder builder = new AssemblerBuilder();
        Director director = new Director(builder);
        Computer computer = director.getComputer("Intel 酷睿i9 7900X","三星M9T 2TB （HN-M201RAD）",
                "技嘉AORUS Z270X-Gaming 7","科赋Cras II 红灯 16GB DDR4 3000");
        System.out.println(computer);
    }
}
