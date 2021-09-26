package cc.momas.dms.service;

import cc.momas.dms.pojo.BcStaff;
import cc.momas.dms.pojo.BcStaffExample;
import cc.momas.util.Pager;

import java.util.List;

public interface IStaffService {

    int deleteBatch(String ids);

    int save(BcStaff staff);

    int restoreBatch(String ids);

    Pager<BcStaff, BcStaffExample> queryByPager(Pager<BcStaff, BcStaffExample> pager);

    int updateById(BcStaff staff);

    List<BcStaff> findAll();

    List<BcStaff> findListByTj(String tj);

}
