package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.QpWorkbillMapper;
import cc.momas.dms.pojo.QpWorkbill;
import cc.momas.dms.pojo.QpWorkbillExample;
import cc.momas.dms.pojo.QpWorkbillExample.Criteria;
import cc.momas.dms.service.IWorkBillService;
import cc.momas.util.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WorkBillServiceImpl implements IWorkBillService {

    @Autowired
    private QpWorkbillMapper wbMapper;

    @Override
    public Pager<QpWorkbill, QpWorkbillExample> queryByPager(Pager<QpWorkbill, QpWorkbillExample> pager) {
        QpWorkbillExample example = new QpWorkbillExample();
        if (pager.getEntity() != null) {
            QpWorkbill entity = pager.getEntity();
            Criteria c = example.createCriteria();
            if (Objects.nonNull(entity.getBuildtime())) {
                c.andBuildtimeEqualTo(entity.getBuildtime());
            }

        }

        pager.setEntityExample(example);
        List<QpWorkbill> list = wbMapper.selectByPager(pager);
        int totalrecord = wbMapper.countByExample(example);
        pager.setList(list);
        pager.setTotalRecordCount(totalrecord);
        return pager;

    }

    @Override
    public int updateRepeat(String ids) {
        int count = 0;
        if (!StringUtils.isEmpty(ids)) {
            String[] staffIds = ids.split(",");
            for (String id : staffIds) {
                QpWorkbill workbill = wbMapper.selectByPrimaryKey(Integer.parseInt(id));
                workbill.setAttachbilltimes(workbill.getAttachbilltimes() + 1);
                // workbill.setType(QpWorkbill.TYPE_2);
                count += wbMapper.updateByPrimaryKeySelective(workbill);
            }
        }
        return count;
    }

    @Override
    public int updateCancel(String ids) {
        int count = 0;
        if (!StringUtils.isEmpty(ids)) {
            String[] staffIds = ids.split(",");
            for (String id : staffIds) {
                QpWorkbill workbill = wbMapper.selectByPrimaryKey(Integer.parseInt(id));
                workbill.setType(QpWorkbill.TYPE_4);
                count += wbMapper.updateByPrimaryKeySelective(workbill);
            }
        }
        return count;
    }

    @Override
    public int save(QpWorkbill wb) {
        return wbMapper.insert(wb);
    }

    @Override
    public int addBatch(List<QpWorkbill> list) {
        int count = 0;
        for (QpWorkbill qpWorkbill : list) {
            count += wbMapper.insert(qpWorkbill);
        }
        return count;
    }
}
