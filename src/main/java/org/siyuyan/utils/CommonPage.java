/**
 * 
 */
package org.siyuyan.utils;

import org.siyuyan.common.Cacheable;

/**
 * @author shenbaise(shenbaise1001@126.com)
 * @date 2012-1-12
 * TODO
 */
public class CommonPage implements Cacheable {


	private static final long serialVersionUID = 8439018851733928939L;
	
	public static final int PAGESIZE = 20;
	
	private String pageLable;
	
	private Integer currentPage;
	
	private Integer recordCount;
	
	private Integer pageCount;
	
	private Integer pageSize;
	
	public static Integer limitStart;
	
	public static Integer limitEnd;
	
	public CommonPage() {
		super();
		this.pageSize = PAGESIZE;
	}
	/**
	 * 构造函数
	 * @param result
	 * @param recordCount
	 * @param currentPage
	 */
	public CommonPage(Integer recordCount,Integer currentPage){
		this.recordCount = recordCount;
		this.pageSize = PAGESIZE;
		this.currentPage = currentPage;
		//计算总页数、限制页数范围
		countPage();
        if (this.currentPage == null || this.currentPage > this.pageCount || this.currentPage < 1) {
           this.currentPage = 1;
        }
        //下页请求数据范围
        limitStart = new Integer((this.currentPage - 1) * this.pageSize );
        limitEnd = new Integer(this.currentPage * this.pageSize);
        init();
	}
	
	/**
	 * 构造函数
	 * @param result
	 * @param recordCount
	 * @param currentPage
	 */
	public CommonPage(Integer recordCount,Integer currentPage,Integer pageSize){
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		//计算总页数、限制页数范围
		countPage();
        if (null == this.currentPage || this.currentPage > this.pageCount || this.currentPage < 1) {
           this.currentPage = 1;
        }
        //下页请求数据范围
        limitStart = new Integer((this.currentPage - 1) * this.pageSize );
        limitEnd = new Integer(this.pageSize);
        init();
	}
	
	/**
	 * 构造分页信息
	 */
	public void init(){

		StringBuilder sb = new StringBuilder();
		
		 //表格开始
		sb.append("<div align=\"left\" style=\"width:30%; margin-left:5\">");
        sb.append("<table border=\"0\" style=\"border-collapse: collapse\" class=\"page\" id=\"table1\" cellpadding=\"2\">");
        sb.append("<tr><td nowrap>");
        sb.append("共 <span class=\"num\">").append(recordCount).append("</span>").append(" 条记录，每页显示\n");
        
        sb.append("<select name=\"perPageNum\" id=\"perPageNum\" onchange=\"perPageNum();\">")
          .append("<option value=\"20\">20</option>")
          .append("<option value=\"30\">30</option>")
          .append("<option value=\"50\">50</option>")
          .append("<option value=\"100\">100</option>")
          .append("</select>\n 条，当前第 <span class=\"num\">").append(currentPage).append("/").append(pageCount).append("</span> 页，")
          .append("<input id=\"totalPages\" type=\"hidden\" name=\"totalPages\" value=\"")
          .append(pageCount).append("\"/>");
        
        
        //首页 上一页
        if (currentPage > 1 && recordCount > 0) {
            sb.append("<a href=\"#\" onclick=\"_GO_PAGE('1')\">首页</a>&nbsp;");
            sb.append("<a href=\"#\" onclick=\"_GO_PAGE('"
                      + (currentPage - 1) + "')\">上一页</a>&nbsp;");
        } else {
            sb.append("首页&nbsp;");
            sb.append("上一页&nbsp;");
        }
       
        //下一页 末页
        if (currentPage < pageCount && recordCount > 0) {
            sb.append("<a href=\"#\" onclick=\"_GO_PAGE('" + (currentPage + 1) + "')\">下一页</a>&nbsp;");
            sb.append("<a href=\"#\" onclick=\"_GO_PAGE('" + pageCount + "')\">末页</a>&nbsp;");
        } else {
            sb.append("下一页&nbsp;");
            sb.append("末页&nbsp;");
            
        }
        
      //跳转翻页
        sb.append(" 跳转至&nbsp;");
        sb.append("<input size=\"4\" maxlength=\"8\" type=\"text\" id=\"goPage\" value=\"\" />");
        sb.append("&nbsp;页&nbsp;");
        sb.append("<input type=\"button\" onclick=\"_GO_BUTTON()\" value=\"go\" class=\"button\"/>");
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table></div>");
        this.pageLable = sb.toString();
	}


	public String getPageLable() {
		return pageLable;
	}

	

	//计算页数
    private void countPage() {
        pageCount = (recordCount + pageSize - 1) / pageSize;
    }
    
    
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setPageLable(String pageLable) {
		this.pageLable = pageLable;
	}
	public int getCachedSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
