/**
 * 
 */
package org.siyuyan.module.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.action.search.SearchResponse;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author whiteme
 * controller����
 */
@Controller("testController")
@RequestMapping(value="test")
public class TestController extends BaseController {
	
	Searcher searcher = new Searcher();
	
	@RequestMapping(value="{id}/say",method=RequestMethod.GET)
	public String batchDel(@PathVariable String msg,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(msg);
		request.setAttribute("msg", msg);
		return "../test";
	}
	
	@RequestMapping(value="hi",method=RequestMethod.GET)
	public String batchDel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("hihi");
		HashMap<String, Integer> m = searcher.facet();
		request.setAttribute("facet", m);
		request.setAttribute("catgoryName","年代");
		return "index";
	}
	
	@RequestMapping(value="me",method=RequestMethod.GET)
	public String batchDeld(String s, HttpServletRequest request,HttpServletResponse response) throws Exception{
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("nd", 2010);
		SearchResponse sr = searcher.query(map2);
		System.out.println(sr.toString());
		return "index";
	}
}
