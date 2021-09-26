package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.BcDecidedzoneMapper;
import cc.momas.dms.mapper.BcSubareaMapper;
import cc.momas.dms.pojo.BcDecidedzone;
import cc.momas.dms.pojo.BcDecidedzoneExample;
import cc.momas.dms.pojo.BcSubarea;
import cc.momas.dms.service.IDecidedZoneService;
import cc.momas.util.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecidedZoneServiceImpl implements IDecidedZoneService {

    @Autowired
    private BcDecidedzoneMapper dzMapper;
    @Autowired
    private BcSubareaMapper subareaMapper;

    @Override
    public List<BcDecidedzone> queryAll() {
        return dzMapper.selectByExample(null);
    }

    @Override
    public Pager<BcDecidedzone, BcDecidedzoneExample> queryByPager(Pager<BcDecidedzone, BcDecidedzoneExample> pager) {
        BcDecidedzoneExample example = new BcDecidedzoneExample();
        // 条件查询
        if (pager.getEntity() != null) {
            BcDecidedzone dz = pager.getEntity();
            // ...Criteria
            if (StringUtils.isNotBlank(dz.getName())) {
                example.createCriteria().andNameLike(new StringBuilder().append('%').append(dz.getName()).toString());
            }
        }

        pager.setEntityExample(example);
        List<BcDecidedzone> list = dzMapper.selectByPager(pager);
        int totalRecord = dzMapper.countByExample(example);
        pager.setList(list);
        pager.setTotalRecordCount(totalRecord);
        return pager;
    }

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] _ids = ids.split(",");
        for (int i = 0; i < _ids.length; i++) {
            dzMapper.deleteByPrimaryKey(Integer.valueOf(_ids[i]));
        }
        return count;
    }

    // @Override
    // public int update(BcDecidedzone dz) {
    // return dzMapper.updateByPrimaryKeySelective(dz);
    // }

    @Override
    public int save(BcDecidedzone decidedzone, String[] subareaId) {
        // 插入定区,这里插入之后可以得到id(主键),是在Mapper里面实现的
        int count = dzMapper.insert(decidedzone);
        // 把选中的分区(SubArea)修改,使分区关联到插入的这个定区
        for (String id : subareaId) {
            BcSubarea bcSubarea = new BcSubarea();
            bcSubarea.setDecidedzoneId(decidedzone.getDecidedzoneId());
            bcSubarea.setSubareaId(Integer.parseInt(id));
            subareaMapper.updateByPrimaryKeySelective(bcSubarea);
        }
        return count;
    }

    /**
     * 1.把数据更新
     * 2.把以前关联的分区解除关联
     * 3.把新关联的分区添加进来关联
     */
    @Override
    public int update(BcDecidedzone dz, String[] subareaId) {
        //更新基础数据
        int count = dzMapper.updateByPrimaryKeySelective(dz);

        //设置decided字段这空
        subareaMapper.setDecidedzoneIdNull(dz.getDecidedzoneId());

        //新分区关联
        for (String id : subareaId) {
            BcSubarea bcSubarea = new BcSubarea();
            bcSubarea.setDecidedzoneId(dz.getDecidedzoneId());
            bcSubarea.setSubareaId(Integer.parseInt(id));
            subareaMapper.updateByPrimaryKeySelective(bcSubarea);
        }
        return count;
    }

}