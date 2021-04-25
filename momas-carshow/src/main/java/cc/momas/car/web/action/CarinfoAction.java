package cc.momas.car.web.action;

import java.util.List;

import cc.momas.car.entity.Carinfo;
import cc.momas.car.service.ICarinfoService;
import cc.momas.car.util.QueryCondition;

public class CarinfoAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private ICarinfoService infoSvc;

	private List<Carinfo> infolist;
	private QueryCondition qc;
	private Carinfo carinfo;

	public String search(){
		if(qc == null){
			return main();
		}
		infolist = infoSvc.findByConditions(qc);
		return SUCCESS;
	}

	/**
	 * 查询全部数据
	 */
	public String main() {
		infolist = infoSvc.findAll();
		return SUCCESS;
	}

	/**
	 * 添加汽车
	 * 
	 * @return
	 */
	public String add() {
		if (carinfo != null) {
			try {
				infoSvc.save(carinfo);
				System.out.println("好像成功了");
			} catch (Exception e) {
				System.out.println("添加失败！");
			}
		}
		return "addsuccess";
	}

	public String toadd() {
		return "toadd";
	}

	public List<Carinfo> getInfolist() {
		return infolist;
	}

	public void setInfoSvc(ICarinfoService infoSvc) {
		this.infoSvc = infoSvc;
	}

	public void setInfolist(List<Carinfo> infolist) {
		this.infolist = infolist;
	}

	public Carinfo getCarinfo() {
		return carinfo;
	}

	public void setCarinfo(Carinfo carinfo) {
		this.carinfo = carinfo;
	}

	public QueryCondition getQc() {
		return qc;
	}

	public void setQc(QueryCondition qc) {
		this.qc = qc;
	}

}
