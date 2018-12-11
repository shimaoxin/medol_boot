package model.boot_mybatis.commom.page;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author smx
 * @date : 2018/12/11
 */
public class PagedList<T> {

    private int page;

    private int pageSize;

    private long totalCount;

    private List<T> list;

    public PagedList(List<T> list) {
        Page<T> pagedList = (Page<T>) list;
        this.setList(list);
        this.setPage(pagedList.getPageNum());
        this.setPageSize(pagedList.getPageSize());
        this.setTotalCount(pagedList.getTotal());
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}