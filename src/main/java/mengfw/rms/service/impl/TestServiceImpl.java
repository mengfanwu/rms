package mengfw.rms.service.impl;

import mengfw.rms.service.TestService;
import org.springframework.stereotype.Component;

/**
 * Created by mengfw on 2017/7/28.
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public void print() {
        System.out.println("print test");
    }
}
