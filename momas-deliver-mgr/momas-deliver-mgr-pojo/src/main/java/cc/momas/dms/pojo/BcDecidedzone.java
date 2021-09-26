package cc.momas.dms.pojo;

public class BcDecidedzone  {
    private Integer decidedzoneId;
    private Integer staffId;
    private String name;

    private BcStaff staff;
    
    public BcStaff getStaff() {
		return staff;
	}

	public void setStaff(BcStaff staff) {
		this.staff = staff;
	}

	public Integer getDecidedzoneId() {
        return decidedzoneId;
    }

    public void setDecidedzoneId(Integer decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}