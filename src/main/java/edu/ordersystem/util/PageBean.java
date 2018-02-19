package edu.ordersystem.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页Bean
 */
public class PageBean implements Serializable {

    //默认每页查询的数据条数
    private static final int DEFAULT_PAGE_SIZE = 10;
    //每页的记录数
    private int pageSize = DEFAULT_PAGE_SIZE;
    //当前页第一条数据在List中的位置，默认从0开始
    private int startIndex = 0;
    //当前页，默认1
    private int page = 1;
    //总页数
    private int totalPage = 0;
    //总数据条数
    private int totalCount = 0;
    //记录每页显示的数据
    private List result = new ArrayList();

    public PageBean() {
    }

    public PageBean(int pageSize, int startIndex, int page, int totalPage, int totalCount) {
        this.pageSize = pageSize;
        this.startIndex = startIndex;
        this.page = page;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        //设置startIndex起始位置
        if(page>0){
            startIndex = (page-1)*pageSize;
        }
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //计算总页数
        this.totalPage = (int) Math.ceil((totalCount+pageSize-1)/pageSize);
        this.startIndex=(page-1)*pageSize;
    }

    //获取上一页页数
    public int getLastPage(){
        if(hasLastPage()){
            return page-1;
        }
        return page;
    }

    //获取下一页页数
    public int getNextPage(){
        if(hasNextPage()){
            return page+1;
        }
        return page;
    }

    //判断是否有上一页
    private boolean hasLastPage(){
        return page>1;
    }

    //判断是否有下一页
    private boolean hasNextPage(){
        return page<totalPage;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
