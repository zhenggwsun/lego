package com.zhangweinan.model.common;

import java.util.List;

/**
 * 分页模型
 * Created by Eric on 2019/4/18.
 */
public class PaginationModel<T> extends PageModel{

    private List<T> list;

    private Integer total;


    public PaginationModel() {
    }

    public PaginationModel(List<T> list, Integer total) {
        this.list = list;
        this.total = total;
    }

    public void fillPageModel(int pageNum, int pageSize, int total){
        setPageNum(pageNum);
        setPageSize(pageSize);
        if (total % pageSize != 0){
            setTotalPages(total/pageSize +1);
        }else {
            setTotalPages(total/pageSize);
        }
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
