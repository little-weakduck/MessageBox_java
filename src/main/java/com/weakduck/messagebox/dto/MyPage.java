package com.weakduck.messagebox.dto;

import java.util.List;

public class MyPage<T> {
    private int page;
    private int pageSize;
    private long total;
    private List<T> data;

    public MyPage(int page, int size, long total, List<T> data) {
        this.page = page;
        this.pageSize = size;
        this.total = total;
        this.data = data;
    }

    // Getters and Setters

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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
