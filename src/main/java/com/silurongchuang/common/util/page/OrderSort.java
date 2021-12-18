package com.silurongchuang.common.util.page;

import java.util.HashMap;

public class OrderSort extends HashMap<String, Object> implements Comparable<OrderSort>{

    private static final long serialVersionUID = 911804349332893049L;
    private String name;

    private Integer members;

    private Object groupId;

    private int order;

    private int status;

    public OrderSort(String name, Integer members, Object groupId, int order, int status) {
        this.name = name;
        this.members = members;
        this.groupId = groupId;
        this.order = order;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Object getGroupId() {
        return groupId;
    }

    public void setGroupId(Object groupId) {
        this.groupId = groupId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int compareTo(OrderSort orderSort) {
        return orderSort.order - this.order;
    }
}
