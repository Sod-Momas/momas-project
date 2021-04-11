package cc.momas.vote.entity;

public class VoteOption {
	/**
	 * 投票选项id
	 */
	private Integer voId;
	/**
	 * 投票主题id
	 */
	private Integer vid;
	/**
	 * 投票选项内容
	 */
	private String voname;

	public Integer getVoId() {
		return voId;
	}

	public void setVoId(Integer voId) {
		this.voId = voId;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVoname() {
		return voname;
	}

	public void setVoname(String voname) {
		this.voname = voname;
	}

}
