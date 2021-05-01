package cc.momas.housetenacy.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String ctx;

	public String getCtx() {
		return ServletActionContext.getRequest().getContextPath();
	}
	
	public Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
}
