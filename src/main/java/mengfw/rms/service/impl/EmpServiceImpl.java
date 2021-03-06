package mengfw.rms.service.impl;

import mengfw.rms.common.BaseServiceImpl;
import mengfw.rms.model.Emp;
import mengfw.rms.service.EmpService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by MFW on 2017/5/29.
 */
@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements EmpService {
    @Override
    public Emp queryByMobile(String mobile) {
        Example example = new Example(Emp.class);
        example.createCriteria().andEqualTo("mobile",mobile);
        List<Emp> emps = mapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(emps)){
            return emps.get(0);
        }
        return null;
    }
}
