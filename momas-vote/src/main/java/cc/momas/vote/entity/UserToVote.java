package cc.momas.vote.entity;

public final class UserToVote {
	/**
	 * 关系id
	 */
	private Integer uvid;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 投票id
	 */
	private Integer vid;

	public Integer getUvid() {
		return uvid;
	}

	public void setUvid(Integer uvid) {
		this.uvid = uvid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

}
