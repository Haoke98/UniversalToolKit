package com.github.Haoke98.util.page;
import java.io.Serializable;
import java.util.List;

public class PageUtil implements Serializable {
    private static final long serialVersionUID = -2655755955203369822L;
    /**
     * 总个数
     */
    private int total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 每页展示多少条数据
     */
    private int pageSize;
    /**
     * 第几页
     */
    private int pageNo;
    /**
     * 分页返回的集合信息
     */
    private List<Object> list;

    public PageUtil() {
    }

    public PageUtil(List<Object> list) {
        this.total = list.size();
        this.list = list;
    }

    public void startPage(int pageNum, int pageSize) {
        pageSize = pageSize > 0 ? pageSize : 10;
        this.pages = (int) Math.ceil((double) this.total / pageSize);
        pageNo = pageNum > 0 ? pageNum : 1;
        pageNo = pageNum > pages ? 1 : pageNum;
        this.pageNo = pageNum;
        this.pageSize = pageSize;
        int startIndex = (pageNum - 1) * pageSize;
        int toIndex = startIndex + pageSize;
        if (toIndex > total) {
            setList(list.subList(startIndex, total));
        } else {
            setList(list.subList(startIndex, toIndex));
        }
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}