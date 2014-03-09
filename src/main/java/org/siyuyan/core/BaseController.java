package org.siyuyan.core;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.mapper.object.ObjectMapper.Nested;
import org.siyuyan.module.web.common.Constant;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller("baseController")	// 没有这个注解也可以，起作用的是继承它的子类的注解
public class BaseController {
	
	public static final String COMMON_FAIL_PAGE = "/html/500";
	public static final String COMMON_FAIL_ALERT_KEY = "/html/500";
	public static final String USER_SESSION_KEY = "/html/500";
	
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
        binder.registerCustomEditor(String.class, new PropertyEditor() {
			private String v;
			@Override
			public boolean supportsCustomEditor() {
				return false;
			}
			
			@Override
			public void setValue(Object arg0) {
				v = String.valueOf(arg0);
			}
			
			@Override
			public void setAsText(String arg0) throws IllegalArgumentException {
				v = String.valueOf(arg0);
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener arg0) {
				
			}
			
			@Override
			public void paintValue(Graphics arg0, Rectangle arg1) {
				
			}
			
			@Override
			public boolean isPaintable() {
				return false;
			}
			
			@Override
			public Object getValue() {
				return v;
			}
			
			@Override
			public String[] getTags() {
				return new String[]{v};
			}
			
			@Override
			public String getJavaInitializationString() {
				return String.valueOf(v);
			}
			
			@Override
			public Component getCustomEditor() {
				return null;
			}
			
			@Override
			public String getAsText() {
				return String.valueOf(v);
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener arg0) {
				
			}
		});
    }
}
