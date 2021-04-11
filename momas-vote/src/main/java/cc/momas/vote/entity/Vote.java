package cc.momas.vote.entity;

public final class Vote {
	/**
	 * 投票id
	 */
	private Integer vid;
	/**
	 * 投票标题
	 */
	private String vtitle;
	/**
	 * 投票类型 <br/>
	 * 1.单选<br/>
	 * 2.多选<br/>
	 */
	private Integer vtype;

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVtitle() {
		return vtitle;
	}

	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}

	public Integer getVtype() {
		return vtype;
	}

	public void setVtype(Integer vtype) {
		this.vtype = vtype;
	}

}
