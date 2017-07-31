package mengfw.rms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by MFW on 2017/5/22.
 */
@SpringBootApplication
@MapperScan(basePackages = "mengfw.rms.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
