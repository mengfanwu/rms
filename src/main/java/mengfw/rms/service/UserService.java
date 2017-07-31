package mengfw.rms.service;

import mengfw.rms.common.BaseService;
import mengfw.rms.model.User;

/**
 * Created by MFW on 2017/5/23.
 */
public interface UserService extends BaseService<User> {
    User query(Integer id);
}
