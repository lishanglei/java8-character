import java.util.function.Consumer;
import static java.lang.System.out;
/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class ConsumerTest {
    public static void main(String[] args) {

        Consumer<String> consumer =out::print;
        consumer.accept("abc");
    }
}
