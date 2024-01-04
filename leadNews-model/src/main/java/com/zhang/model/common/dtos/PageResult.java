package com.zhang.model.common.dtos;

import java.io.Serializable;

public class PageResult extends Result implements Serializable {
    private Integer currentPage;
    private Integer size;
    private Integer total;

    public PageResult(Integer currentPage, Integer size, Integer total) {
        this.currentPage = currentPage;
        this.size = size;
        this.total = total;
    }

    public PageResult() {

    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
