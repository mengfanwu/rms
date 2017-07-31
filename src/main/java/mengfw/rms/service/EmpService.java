package mengfw.rms.service;

import mengfw.rms.common.BaseService;
import mengfw.rms.model.Emp;

/**
 * Created by MFW on 2017/5/29.
 */
public interface EmpService extends BaseService<Emp> {
    Emp queryByMobile(String mobile);
}
