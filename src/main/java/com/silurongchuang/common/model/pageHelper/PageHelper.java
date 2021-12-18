package com.silurongchuang.common.model.pageHelper;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 修改mybatis的分页插件，增加属性用于自己项目使用
 *
 * @param <T>
 */
public class PageHelper<T> extends PageInfo<T> {
    private static final long serialVersionUID = 3517512105632158209L;

    private int pageNo;

    private Long totalCount;

    private int totalPage;

    private int range;

    public PageHelper(List<T> list) {
        super(list);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
