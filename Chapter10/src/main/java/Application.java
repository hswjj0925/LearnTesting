import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangkai on 18/5/22.
 */

@SpringBootApplication
@ComponentScan("com.course.MyService")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
