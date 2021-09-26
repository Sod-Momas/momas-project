package cc.momas.dms.pojo;

import java.util.Date;

public class QpWorkbill {
    private Integer workbillId;
    private Integer noticebillId;
    private Integer staffId;
    private String type;
    private String pickstate;
    private Date buildtime;
    private Integer attachbilltimes;//追单次数
    private String remark;
    
    private BcStaff staff;
    
    public static final String TYPE_1 ="新单";
    public static final String TYPE_2 ="追单";
    public static final String TYPE_3 ="改单";
    public static final String TYPE_4 ="销单";
    
    public static final String PICKSTATE_NO ="未取件";
    public static final String PICKSTATE_RUNNING ="取件中";
    public static final String PICKSTATE_YES ="已取件";
    
    
    
    public QpWorkbill() {
		super();
	}

	public QpWorkbill(Integer workbillId, Integer noticebillId, Integer staffId, String type, String pickstate,
			Date buildtime, Integer attachbilltimes, String remark, BcStaff staff) {
		super();
		this.workbillId = workbillId;
		this.noticebillId = noticebillId;
		this.staffId = staffId;
		this.type = type;
		this.pickstate = pickstate;
		this.buildtime = buildtime;
		this.attachbilltimes = attachbilltimes;
		this.remark = remark;
		this.staff = staff;
	}

	public BcStaff getStaff() {
		return staff;
	}

	public void setStaff(BcStaff staff) {
		this.staff = staff;
	}

	public Integer getWorkbillId() {
        return workbillId;
    }

    public void setWorkbillId(Integer workbillId) {
        this.workbillId = workbillId;
    }

    public Integer getNoticebillId() {
        return noticebillId;
    }

    public void setNoticebillId(Integer noticebillId) {
        this.noticebillId = noticebillId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPickstate() {
        return pickstate;
    }

    public void setPickstate(String pickstate) {
        this.pickstate = pickstate == null ? null : pickstate.trim();
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getAttachbilltimes() {
        return attachbilltimes;
    }

    public void setAttachbilltimes(Integer attachbilltimes) {
        this.attachbilltimes = attachbilltimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}