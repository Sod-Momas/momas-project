package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.BcStaffMapper;
import cc.momas.dms.pojo.BcStaff;
import cc.momas.dms.pojo.BcStaffExample;
import cc.momas.dms.service.IStaffService;
import cc.momas.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private BcStaffMapper staffMapper;

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] _ids = ids.split(",");
        BcStaff staff = new BcStaff();
        for (int i = 0; i < _ids.length; i++) {
            staff.setStaffId(Integer.valueOf(_ids[i]));
            staff.setDeltag("1");
            count += staffMapper.updateByPrimaryKeySelective(staff);
        }
        return count;
    }

    @Override
    public int save(BcStaff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public int restoreBatch(String ids) {
        int count = 0;
        String[] _ids = ids.split(",");
        BcStaff staff = new BcStaff();
        for (int i = 0; i < _ids.length; i++) {
            staff.setStaffId(Integer.valueOf(_ids[i]));
            staff.setDeltag("0");
            count += staffMapper.updateByPrimaryKeySelective(staff);
        }
        return count;
    }

    @Override
    public Pager<BcStaff, BcStaffExample> queryByPager(Pager<BcStaff, BcStaffExample> pager) {
        List<BcStaff> list = staffMapper.selectByPager(pager);
        int totalRecord = staffMapper.countByExample(new BcStaffExample());
        pager.setTotalRecordCount(totalRecord);
        pager.setList(list);
        return pager;
    }

    @Override
    public int updateById(BcStaff staff) {
        return staffMapper.updateByPrimaryKeySelective(staff);
    }

    @Override
    public List<BcStaff> findAll() {
        return staffMapper.selectByExample(null);
    }

    @Override
    public List<BcStaff> findListByTj(String tj) {
        BcStaffExample example = new BcStaffExample();
        tj = new StringBuilder().append('%').append(tj).append('%').toString();

        example.or().andNameLike(tj);
        example.or().andTelephoneLike(tj);
        example.or().andHaspdaLike(tj);
        example.or().andStationLike(tj);
        example.or().andStandardLike(tj);

        return staffMapper.selectByExample(example);
    }

}
