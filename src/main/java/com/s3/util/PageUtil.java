package com.s3.util;

import lombok.ToString;

import java.util.List;

/**
 * User: jianglin
 * Date: 2022/1/4
 * Time: 9:05
 * Desc: 分页实体类
 */
@ToString
public class PageUtil<T> {

    private Integer pageSize;
    private Integer pageIndex;
    private Integer totalPage;
    private Integer totalCount;

    private List<T> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //totalPage赋值
        this.totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
