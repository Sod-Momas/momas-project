package cc.momas.news.web;

import cc.momas.news.common.JsonUtil;

/**
 * 统一响应实体,所有返回给前端的值都要设置到这个实体里再序列化给前端
 * 
 * @author Sod-Momas
 *
 * @param <T> 不同的返回数据类型
 */
public class ResponseEntity<T> {
	/**
	 * 请求状态, 成功为200, 参考http状态, 不够用时可以定义, 定义的值最好是放在一个常量里
	 */
	public int status = 200;
	/**
	 * 附带消息, 报告请求处理情况, 成功为 OK
	 */
	public String message = "OK";
	/**
	 * 请求的数据, 装在这个字段里.
	 */
	public T data;

	/*--------------------
	 |  static method    |
	 |  工具方法          |
	 ---------------------*/
	public static ResponseEntity<String> ok() {
		return new ResponseEntity<>();
	}

	public static ResponseEntity<String> error() {
		return error("请求失败");
	}

	public static ResponseEntity<String> error(String message) {
		return error(message, 400);
	}

	public static ResponseEntity<String> error(String message, int status) {
		ResponseEntity<String> resp = new ResponseEntity<>();
		resp.message = message;
		resp.status = status;
		return resp;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

}
