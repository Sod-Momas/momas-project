package cc.momas.news.web.listener;

import java.io.InputStream;

public class LoadResourceTest {


    public static void main(String[] args) {
//		ApplicationListener listener = new ApplicationListener();
        InputStream is = ApplicationListener.class.getClassLoader().getResourceAsStream("./application.properties");
        System.out.println(is);
    }
}
