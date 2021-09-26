package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.BcRegionMapper;
import cc.momas.dms.pojo.BcRegion;
import cc.momas.dms.pojo.BcRegionExample;
import cc.momas.dms.pojo.BcRegionExample.Criteria;
import cc.momas.dms.service.IRegionService;
import cc.momas.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private BcRegionMapper regionMapper;

    @Override
    public Pager<BcRegion, BcRegionExample> queryByPager(Pager<BcRegion, BcRegionExample> pager) {
        List<BcRegion> list = regionMapper.selectByPager(pager);
        int totalrecord = regionMapper.countByExample(null);
        pager.setTotalRecordCount(totalrecord);
        pager.setList(list);
        return pager;
    }

    @Override
    public int updateById(BcRegion region) {
        return regionMapper.updateByPrimaryKeySelective(region);
    }

    @Override
    public int save(BcRegion region) {
        return regionMapper.insert(region);
    }

    @Override
    public int deleteBatch(String ids) {
        int count = 0;
        String[] _ids = ids.split(",");
        for (int i = 0; i < _ids.length; i++) {
            count += regionMapper.deleteByPrimaryKey(Integer.valueOf(_ids[i]));
        }
        return count;
    }

    @Override
    public int importExcel(List<BcRegion> list) {
        int i = 0;
        for (; i < list.size(); i++) {
            regionMapper.insert(list.get(i));
        }
        return i;
    }

    @Override
    public List<BcRegion> findAll() {
        return regionMapper.selectByExample(new BcRegionExample());
    }

    @Override
    public List<BcRegion> findListByTj(String tj) {
        BcRegionExample example = new BcRegionExample();
        Criteria c = null;

        c = example.createCriteria();
        example.or(c.andProvinceLike("%" + tj + "%"));
        c = example.createCriteria();
        example.or(c.andCitycodeLike("%" + tj + "%"));
        c = example.createCriteria();
        example.or(c.andDistrictLike("%" + tj + "%"));
        c = example.createCriteria();
        example.or(c.andPostcodeLike("%" + tj + "%"));
        c = example.createCriteria();
        example.or(c.andShortcodeLike("%" + tj + "%"));

        return regionMapper.selectByExample(example);
    }

    @Override
    public List<BcRegion> queryAll() {
        return regionMapper.selectByExample(null);
    }


}
