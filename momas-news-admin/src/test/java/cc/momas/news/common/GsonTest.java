package cc.momas.news.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cc.momas.news.web.ResponseEntity;

import org.junit.Test;

import java.util.Date;

public class GsonTest {

    @Test
    public void toJson(){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(new Date());
        System.out.println(json);
    }
    
    @Test
    public void entity() {
    	ResponseEntity<String> ok = ResponseEntity.ok();
    	String json = JsonUtil.toJson(ok);
    	System.out.println(json);
    }
    
  
}
