package cc.momas.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class FileUtil {

	/** 
     * 下载文件时，针对不同浏览器，进行附件名的编码 
     * 
     * @param filename 
     *            下载文件名 
     * @param agent 
     *            客户端浏览器f 
     * @return 编码后的下载附件名 
	 * @throws UnsupportedEncodingException 
     * @throws IOException 
     */  
    public static String encodeDownloadFilename(String filename, String agent) throws UnsupportedEncodingException  {  
    	if (null != agent) {
			if (agent.contains("Firefox")) {
				filename = "=?UTF-8?B?"
						+ (new String(org.apache.commons.codec.binary.Base64.encodeBase64(filename.getBytes(StandardCharsets.UTF_8))))
						+ "?=";
			} else if (agent.contains("Chrome")) {
				filename = new String(filename.getBytes(), "ISO8859-1");
			} else {
				filename = java.net.URLEncoder.encode(filename, StandardCharsets.UTF_8);
				filename = filename.replace("+", "");
			}
		} 

		return filename;

	}
 
}
