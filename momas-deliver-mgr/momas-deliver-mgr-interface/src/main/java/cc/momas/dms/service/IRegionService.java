package cc.momas.dms.service;

import cc.momas.dms.pojo.BcRegion;
import cc.momas.dms.pojo.BcRegionExample;
import cc.momas.util.Pager;

import java.util.List;

public interface IRegionService {

    Pager<BcRegion, BcRegionExample> queryByPager(Pager<BcRegion, BcRegionExample> pager);

    int updateById(BcRegion region);

    int save(BcRegion region);

    int deleteBatch(String ids);

    int importExcel(List<BcRegion> list);

    List<BcRegion> findAll();

    List<BcRegion> findListByTj(String tj);

    List<BcRegion> queryAll();

}
