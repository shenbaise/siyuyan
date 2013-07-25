package org.siyuyan.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.siyuyan.module.web.common.Constant;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller("baseController")	// 没有这个注解也可以，起作用的是继承它的子类的注解
public class BaseController {
	
	public static final String COMMON_FAIL_PAGE = "/error/e-500";
	public static final String COMMON_FAIL_ALERT_KEY = "/error/e-500";
	public static final String USER_SESSION_KEY = "/error/e-500";
	
	/**
	 * 整理前台参数
	 * @param request
	 * @return
	 */
	public HashMap<String, Object> getParaMap(HttpServletRequest request){
		HashMap<String, Object> paraMap = new HashMap<String, Object>();
		Map<?, ?> m = request.getParameterMap();
        Iterator<?> ite = m.keySet().iterator();
        while (ite.hasNext()) {
            String key = (String) ite.next();
            String value = ((String[]) m.get(key))[0];
            if (StringUtils.isNotBlank(value)) {
            	paraMap.put(key, value);
			}
        }
        
        request.setAttribute("query", paraMap);
        return paraMap;
	}
	/**
	 * @param page
	 * @param size
	 * @return
	 * start pos
	 */
	public static int getStartPage(Integer page,Integer size){
		return (page-1)*size;
	}
	/**
	 * @param page
	 * @return
	 * @desc 页码
	 */
	public int getPage(Integer page){
		if(page==null)
			page = 1;
		if(page<0)
			page = 1;
		return page;
	}
	/**
	 * @param size
	 * @return
	 * @desc 每页大小
	 */
	public static int getSize(Integer size){
		if(size==null)
			size = Constant.defaultPageSize;
		if(size<=0)
			size = Constant.defaultPageSize;
		return size;
	}
	
	/**
	 * 定制参数绑定
	 * @param binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, false));
    }
}
