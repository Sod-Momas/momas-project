package cc.momas.dms.service;

import cc.momas.dms.pojo.BcSubarea;
import cc.momas.dms.pojo.BcSubareaExample;
import cc.momas.dms.pojo.ProvCount;
import cc.momas.util.Pager;

import java.util.List;

public interface ISubAreaService {

    int add(BcSubarea sub);

    Pager<BcSubarea, BcSubareaExample> queryByPager(Pager<BcSubarea, BcSubareaExample> pager);

    int deleteBatch(String ids);

    int update(BcSubarea sub);

    int importExcel(List<BcSubarea> sublist);

    List<BcSubarea> queryAll();

    List<BcSubarea> queryNotBeAssociated();

    List<BcSubarea> queryByDecidedId(Integer id);

    List<ProvCount> findSubareasGroupByProvince();

}
