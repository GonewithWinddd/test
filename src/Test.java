import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println("测试1.6");
        System.out.println("测试上传的效果");

        List<String> list = new ArrayList<String>();
        list.add("数学");list.add("yy");
        List<String> res =list.stream().filter(x->x.equals("yy")).collect(Collectors.toList());
        System.out.println(res.size());
    }
}
