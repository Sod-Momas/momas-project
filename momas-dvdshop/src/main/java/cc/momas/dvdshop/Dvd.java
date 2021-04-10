package cc.momas.dvdshop;

public class Dvd {
	/** 是否已经借出 */
	private boolean isLoaned;
	/** 借出次数 */
	private int loanCount;
	/** DVD名字 */
	private String name;

	/** 默认构造器 */
	public Dvd() {
	}

	/** 带三个参数的构造器 */
	public Dvd(String name, int loanCount, boolean isLoaned) {
		this.name = name;
		this.loanCount = loanCount;
		this.isLoaned = isLoaned;
	}

	public int getLoanCount() {
		return loanCount;
	}

	public String getName() {
		return name;
	}

	public boolean isLoaned() {
		return this.isLoaned;
	}

	public void setLoanCount(int loanCount) {
		this.loanCount = loanCount;
	}

	public void setLoaned(boolean isLoaned) {
		this.isLoaned = isLoaned;
	}

	public void setName(String name) {
		this.name = name;
	}

}
