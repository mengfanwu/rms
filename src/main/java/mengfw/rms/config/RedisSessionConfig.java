package mengfw.rms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by MFW on 2017/5/31.
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
