package cc.momas.dms.service;

import cc.momas.dms.pojo.QpNoticebill;
import cc.momas.dms.pojo.QpNoticebillExample;
import cc.momas.util.Pager;

public interface IQpNoticebillService {

    int save(QpNoticebill nb, Integer decidedzoneId);

    Object queryByPager(Pager<QpNoticebill, QpNoticebillExample> pager);

    // int save(QpNoticebill[] nbs, Integer decidedzoneId);

}
