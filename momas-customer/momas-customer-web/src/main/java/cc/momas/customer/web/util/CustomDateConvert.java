package cc.momas.customer.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class CustomDateConvert implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor cde = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class,cde);

	}

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		this.initBinder(binder);
	}
}
