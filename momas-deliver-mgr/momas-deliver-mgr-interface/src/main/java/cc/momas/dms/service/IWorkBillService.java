package cc.momas.dms.service;

import cc.momas.dms.pojo.QpWorkbill;
import cc.momas.dms.pojo.QpWorkbillExample;
import cc.momas.util.Pager;

import java.util.List;

public interface IWorkBillService {

    Pager<QpWorkbill, QpWorkbillExample> queryByPager(Pager<QpWorkbill, QpWorkbillExample> pager);

    int updateRepeat(String ids);

    int updateCancel(String ids);

    int save(QpWorkbill wb);

    int addBatch(List<QpWorkbill> list);

}
