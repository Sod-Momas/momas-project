package cc.momas.dms.pojo;

public class AuthFunction {
    private Integer authFuctionId;
    private String pid;
    private String name;
    private String code;
    private String description;
    private String page;
    private String generatemenu;
    private Integer zindex;
    
    private AuthFunction parentFunc;

	public AuthFunction getParentFunc() {
		return parentFunc;
	}

	public void setParentFunc(AuthFunction parentFunc) {
		this.parentFunc = parentFunc;
	}

	public Integer getAuthFuctionId() {
        return authFuctionId;
    }

    public void setAuthFuctionId(Integer authFuctionId) {
        this.authFuctionId = authFuctionId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getGeneratemenu() {
        return generatemenu;
    }

    public void setGeneratemenu(String generatemenu) {
        this.generatemenu = generatemenu == null ? null : generatemenu.trim();
    }

    public Integer getZindex() {
        return zindex;
    }

    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }
}