package cc.momas.dvdshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DVDShop implements DvdUtil {
	
	/**输入器*/
	private Scanner input;
	/** DVD列表 */
	private Dvd[] DVDs = new Dvd[50];

	// 默认构造器
	public DVDShop() {
		this.initial();
		this.showDVDs();
	}

	/** 初始化内容 */
	private void initial() {
		if (this.DVDs == null) {
			// System.err.println("<!>数组未初始化");
			this.DVDs = new Dvd[50];
		}
		
		addDVD("浪漫满屋", 0, false);
		addDVD("变形金刚", 2, false);
		addDVD("迷雾", 1, true);
	}

	/** 显示欢迎信息 */
	public void showFeatureList() {
		// 功能列表
		String[] featureList = {"租借dvd", "还dvd", "添加dvd", "删除dvd", "退出商店",};
		for (int i = 0; i < featureList.length; i++) {
			System.out.println((i + 1) + "." + featureList[i]);
		}
	}

	/** 显示电影列表 */
	public void showDVDs() {
		System.out.println("___________________________");
		System.out.println("序号\t片名\t借出次数\t状态");
		for (int i = 0; i < DVDs.length && DVDs[i] != null; i++) {
			System.out.println((i + 1) + "\t" + DVDs[i].getName() + "\t" + DVDs[i].getLoanCount() + "\t"
					+ (DVDs[i].isLoaned() ? "已借出" : "未借出"));
		}
		System.out.println("___________________________");
	}

	/** 功能列表选择 */
	public void featureSelect() {
		showFeatureList();
		boolean toggle = true;// 循环开关

		do {
			System.out.print("请选择项目:(输入项目前的数字)");
			input = new Scanner(System.in);
			int i = input.nextInt();

			switch (i) {
			case 1:
				toGetDVD();
				break;
			case 2:
				toReturnDVD();
				break;
			case 3:
				toAddDVD();
				break;
			case 4:
				toDelDVD();
				break;
			case 5:
				System.out.println("[√]欢迎下次光临");
				toggle = false;
				break;
			default:
				System.err.println("<!>没有这个选项");
				break;
			}
		} while (toggle);

	}

	private void toGetDVD() {
		System.out.print("请输入要借的电影的片名：");
		input = new Scanner(System.in);
		String name = input.nextLine();
		String[] ns = extractString(DVDs);
		int result = catchString(ns, name);

		if (result == -1) {
			// 没有找到
			System.err.println("<!>租借失败！没有找到影片！");
			return;
		}

		if (getDVD(result)) {
			System.out.println("租借成功！");
		} else {
			System.err.println("<!>租借失败！可能是电影已经借出");
		}
		showDVDs();
		featureSelect();

	}

	private void toReturnDVD() {
		System.out.print("请输入要归还的电影片名：");
		input = new Scanner(System.in);
		String name = input.nextLine();
		String[] ns = extractString(DVDs);
		int result = catchString(ns, name);
		if (result == -1) {
			// 没有找到
			System.err.println("<!>归还失败！没有找到影片！");
			return;
		}
		if (returnDVD(result)) {
			System.out.print("请输入借书日期(yyyy-MM-dd)：");
			input = new Scanner(System.in);
			String bDate = input.nextLine();
			System.out.print("请输入归还日期(yyyy-MM-dd):");
			String rDate = input.nextLine();
			System.out.println("[￥]您应该还：" + calcFee(bDate, rDate) * 5 + "元");
			System.out.println("[√]归还成功");
		} else {
			System.err.println("<!>归还失败！()");
		}
		showDVDs();
		featureSelect();
	}

	private void toAddDVD() {
		System.out.print("请输入要添加的电影的片名：");
		input = new Scanner(System.in);
		String name = input.nextLine();
		if (addDVD(name,0,false)) {
			System.out.println("[√]添加成功！");
		} else {
			System.err.println("[√]添加失败！可能是由于电影重名或数组满了");
		}
		showDVDs();
		featureSelect();
	}

	private void toDelDVD() {
		System.out.print("请输入要删除的电影片名：");
		input = new Scanner(System.in);
		String name = input.nextLine();
		String[] ns = extractString(DVDs);
		int result = catchString(ns, name);
		if (result == -1) {
			// 没有找到
			System.err.println("<!>删除失败！没有找到影片！");
			return;
		}
		if (delDVD(result)) {
			System.out.println("[√]删除成功");
		} else {
			System.err.println("<!>删除失败！(电影是未归还或移除失败)");
		}
		showDVDs();
		featureSelect();
	}

	@Override
	public boolean addDVD(String name, int loanCount, boolean isLoaned) {
		// 本来还想做个不能重名的判断，太麻烦了算了
		for (int i = 0; i < DVDs.length; i++) {
			if (DVDs[i] == null) {
				DVDs[i] = new Dvd(name, loanCount, isLoaned);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delDVD(int index) {
		if (DVDs[index].isLoaned()) {
			return false;
		}
		removeEle(DVDs, index);
		return true;
	}

	@Override
	public boolean returnDVD(int index) {
		// 无论是否已经归还，都要了
		DVDs[index].setLoaned(false);
		return true;
	}

	@Override
	public boolean getDVD(int index) {
		// 已经借出
		if (DVDs[index].isLoaned()) {
			return false;
		} else {
			DVDs[index].setLoanCount(DVDs[index].getLoanCount() + 1);// 租借次数+1
			DVDs[index].setLoaned(true);// 设置为已经借出
			return true;
		}
	}

	/** 移除数组中某元素的算法 */

	private void removeEle(Dvd[] d2, int index) {
		d2[index] = null;
		for (int i = index; i < d2.length; i++) {
			if (d2 != null && i < d2.length - 1) {
				d2[i] = d2[i + 1];
			} else if (i < d2.length - 2) {
				d2[i + 1] = null;
			}
		}

	}

	/** 从DVD数组里提取出DVD们的名字并存在String数组中返回 */
	private String[] extractString(Dvd[] ds) {
		String[] ns = new String[ds.length];
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null)
				ns[i] = ds[i].getName();
		}
		return ns;
	}

	/**
	 * 在String [] 中匹配 String
	 * 
	 * @param sa
	 *            匹配对象数据
	 * @param s
	 *            匹配关键字
	 * @return 匹配结果(-1表示没有找到，正整数表示s存在的数组下标)
	 */
	private int catchString(String[] sa, String s) {
		int index = -1;
		for (int i = 0; i < sa.length; i++) {
			if (s.equals(sa[i])) {
				index = i;
				// 这里可以再添加一行作为退出，防止CPU空转
			}
		}
		return index;
	}

	/**
	 * 计算日期相差多少天
	 * 
	 * @throws ParseException
	 */
	private int calcFee(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date sdate = null;
		Date edate = null;
		try {
			sdate = sdf.parse(startDate);
			edate = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return (int) (edate.getTime() - sdate.getTime()) / (1000 * 60 * 60 * 24);

	}
}
