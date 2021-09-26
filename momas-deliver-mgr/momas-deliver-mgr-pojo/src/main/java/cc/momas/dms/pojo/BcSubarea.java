package cc.momas.dms.pojo;

public class BcSubarea  {
    private Integer subareaId;
    private Integer decidedzoneId;
    private Integer regionId;
    private String addresskey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;
    
    private BcRegion region;
    private BcDecidedzone decidedzone;

    
    
    public BcSubarea() {
		super();
	}

	public BcSubarea(Integer subareaId, Integer decidedzoneId, Integer regionId, String addresskey, String startnum,
			String endnum, String single, String position, BcRegion region, BcDecidedzone decidedzone) {
		super();
		this.subareaId = subareaId;
		this.decidedzoneId = decidedzoneId;
		this.regionId = regionId;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
		this.region = region;
		this.decidedzone = decidedzone;
	}

	public Integer getSubareaId() {
        return subareaId;
    }

    public void setSubareaId(Integer subareaId) {
        this.subareaId = subareaId;
    }

    public Integer getDecidedzoneId() {
        return decidedzoneId;
    }

    public void setDecidedzoneId(Integer decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey == null ? null : addresskey.trim();
    }

    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum == null ? null : startnum.trim();
    }

    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum == null ? null : endnum.trim();
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single == null ? null : single.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

	public BcRegion getRegion() {
		return region;
	}

	public void setRegion(BcRegion region) {
		this.region = region;
	}

	public BcDecidedzone getDecidedzone() {
		return decidedzone;
	}

	public void setDecidedzone(BcDecidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}
}