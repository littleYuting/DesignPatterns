import java.util.ArrayList;
import java.util.List;

public class ConstructComposite {
    // 构建一棵文件树
    abstract class File{
        protected String name;
        File(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public abstract void display();
    }
    class Folder extends File{
        private List<File> files = new ArrayList<File>();
        Folder(String name) {
            super(name);
        }
        public void display() {
            System.out.println("该文件夹包括：");
            for (File f:files) {
                System.out.println(f.getClass().getName() + "_" + f.getName());
            }
        }
        public void addFile(File file){
            files.add(file);
        }
        public void deleteFile(File file){
            files.remove(file);
        }
    }
    class TextFile extends File{
        TextFile(String name) {
            super(name);
        }
        public void display() {
            System.out.println("文本类文件" + this.name);
        }
    }
    class ImageFile extends File{
        ImageFile(String name) {
            super(name);
        }
        public void display() {
            System.out.println("图片类文件" + this.name);
        }
    }
    public static void main(String[] args) {
        ConstructComposite composite = new ConstructComposite();
        composite.testComposite();
    }
    public void testComposite(){
        Folder folder_1 = new Folder("总文件夹");
        folder_1.addFile(new TextFile("文本"));
        folder_1.addFile(new ImageFile("照片"));
        Folder folder_2 = new Folder("子文件夹");
        folder_1.addFile(folder_2);
        folder_1.display();
    }
}
