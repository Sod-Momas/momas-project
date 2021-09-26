package cc.momas.dms.service;

import cc.momas.dms.pojo.BcDecidedzone;
import cc.momas.dms.pojo.BcDecidedzoneExample;
import cc.momas.util.Pager;

import java.util.List;

public interface IDecidedZoneService {

    List<BcDecidedzone> queryAll();

    int save(BcDecidedzone decidedzone, String[] subareaId);

    Pager<BcDecidedzone, BcDecidedzoneExample> queryByPager(Pager<BcDecidedzone, BcDecidedzoneExample> pager);

    int deleteBatch(String ids);

    int update(BcDecidedzone dz, String[] subareaId);

}
