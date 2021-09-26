package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.BcSubareaMapper;
import cc.momas.dms.pojo.BcSubarea;
import cc.momas.dms.pojo.BcSubareaExample;
import cc.momas.dms.pojo.BcSubareaExample.Criteria;
import cc.momas.dms.pojo.ProvCount;
import cc.momas.dms.service.ISubAreaService;
import cc.momas.util.Pager;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubAreaServiceImpl implements ISubAreaService {

    @Autowired
    private BcSubareaMapper subMapper;

    @Override
    public int add(BcSubarea sub) {
        return subMapper.insert(sub);
    }

    @Override
    public Pager<BcSubarea, BcSubareaExample> queryByPager(Pager<BcSubarea, BcSubareaExample> pager) {
        BcSubareaExample example = new BcSubareaExample();
        Criteria c = example.createCriteria();
        if (pager.getEntity() != null) {
            BcSubarea entity = pager.getEntity();
            if (!StringUtils.isEmpty(entity.getAddresskey())) {
                c.andAddresskeyLike('%' + entity.getAddresskey() + '%');
            }
            if (!StringUtils.isEmpty(entity.getEndnum())) {
                c.andEndnumLessThan(entity.getEndnum());
            }
            if (!StringUtils.isEmpty(entity.getPosition())) {
                c.andPositionLike('%' + entity.getPosition() + '%');
            }
            if (!StringUtils.isEmpty(entity.getSingle())) {
                c.andSingleEqualTo(entity.getSingle());
            }
            if (!StringUtils.isEmpty(entity.getStartnum())) {
                c.andStartnumGreaterThan(entity.getStartnum());
            }
        }
        pager.setEntityExample(example);
        List<BcSubarea> sublist = subMapper.selectByPager(pager);
        int totalrecord = subMapper.countByExample(pager.getEntityExample());//这里可能为空,不知道会不会报错
        pager.setList(sublist);
        pager.setTotalRecordCount(totalrecord);
        return pager;
    }

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] _ids = ids.split(",");
        for (String id : _ids) {
            subMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return count;
    }

    @Override
    public int update(BcSubarea sub) {
        return subMapper.updateByPrimaryKeySelective(sub);
    }

    @Override
    public int importExcel(List<BcSubarea> sublist) {
        int i = 0;
        for (; i < sublist.size(); i++) {
            subMapper.insert(sublist.get(i));
        }
        return i;
    }

    @Override
    public List<BcSubarea> queryAll() {
        return subMapper.selectByExample(null);
    }

    @Override
    public List<BcSubarea> queryNotBeAssociated() {
        BcSubareaExample example = new BcSubareaExample();
        example.createCriteria().andDecidedzoneIdIsNull();
        return subMapper.selectByExample(example);
    }

    @Override
    public List<BcSubarea> queryByDecidedId(Integer id) {
        BcSubareaExample example = new BcSubareaExample();
        example.or().andDecidedzoneIdEqualTo(id);
        return subMapper.selectByExample(example);
    }

    //查询饼图所需要的数据
    @Override
    public List<ProvCount> findSubareasGroupByProvince() {
        List<ProvCount> list = subMapper.selectSubareasGroupByProvince();
        System.err.println(list);
        return list;
    }


}
