package cc.momas.dms.service.impl;

import cc.momas.dms.mapper.BcDecidedzoneMapper;
import cc.momas.dms.mapper.QpNoticebillMapper;
import cc.momas.dms.mapper.QpWorkbillMapper;
import cc.momas.dms.pojo.*;
import cc.momas.dms.pojo.QpNoticebillExample.Criteria;
import cc.momas.dms.service.IQpNoticebillService;
import cc.momas.util.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QpNoticebillServiceImpl implements IQpNoticebillService {

    @Autowired
    private QpNoticebillMapper nbMapper;
    @Autowired
    private BcDecidedzoneMapper decidedZoneMapper;
    @Autowired
    private QpWorkbillMapper workbillMapper;

    /**
     * 保存业务通知单,尝试根据客户所属定区自动分单给所属取派员
     */
    @Override
    public int save(QpNoticebill nb, Integer decidedzoneId) {
        int count = 0;
        if (decidedzoneId == null) {
            //没有查询到定区id
            nb.setOrdertype(QpNoticebill.ORDERTYPE_MAN);
        } else {
            //查询到了定区id,可以完成自动分单,将业务单根据所属定区分发人指定取派员
            BcDecidedzone decidedzone = decidedZoneMapper.selectByPrimaryKey(decidedzoneId);
            BcStaff staff = decidedzone.getStaff();
            nb.setStaffId(staff.getStaffId());//业务通知单关联取派员对象
            //设置分单类型为:自动分单
            nb.setOrdertype(QpNoticebill.ORDERTYPE_AUTO);
        }
        count += nbMapper.insert(nb);

        //存在定区
        if (null != decidedzoneId) {
            //为指定定区的取派员自动产生一个工单
            QpWorkbill workbill = new QpWorkbill();
            workbill.setAttachbilltimes(0);//追单次数
            workbill.setBuildtime(new Date());
            //工单关联页面通知单,该id必须要在Mapper文件中配置insert id="insert" useGeneratedKeys="true" keyProperty="noticebillId"才能取到
            workbill.setNoticebillId(nb.getNoticebillId());
            workbill.setPickstate(QpWorkbill.PICKSTATE_NO);//取件状态
            workbill.setRemark(nb.getRemark());//备注信息
            workbill.setStaffId(nb.getStaffId());
            workbill.setType(QpWorkbill.TYPE_1);
            workbillMapper.insert(workbill);
        }
        return count;
    }


    @Override
    public Object queryByPager(Pager<QpNoticebill, QpNoticebillExample> pager) {
        QpNoticebillExample example = new QpNoticebillExample();
        if (pager.getEntity() != null) {
            Criteria c = example.createCriteria();
            QpNoticebill entity = pager.getEntity();
            if (StringUtils.isNotBlank(entity.getOrdertype())) {
                c.andOrdertypeEqualTo(entity.getOrdertype());
            }
            if (StringUtils.isNotBlank(entity.getPickaddress())) {
                c.andPickaddressLike("%" + entity.getPickaddress() + "%");
            }
        }
        pager.setEntityExample(example);
        List<QpNoticebill> list = nbMapper.selectByPager(pager);
        int totalrecord = nbMapper.countByExample(example);
        pager.setList(list);
        pager.setTotalRecordCount(totalrecord);
        return pager;

    }

//	//批量添加
//	@Override
//	public int save(QpNoticebill[] nbs, Integer decidedzoneId) {
//		int count = 0;
//		for (QpNoticebill nb : nbs) {
//			count += this.save(nb, decidedzoneId);
//		}
//		return count;
//	}

}
