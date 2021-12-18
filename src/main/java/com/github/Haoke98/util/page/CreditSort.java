package com.github.Haoke98.util.page;

import java.util.Date;
import java.util.HashMap;

public class CreditSort extends HashMap<String, Object> implements Comparable<CreditSort>{

    private static final long serialVersionUID = -3070303946499361688L;


    private Integer change;

    private Date time;

    private String reason;

    public CreditSort(Integer change, Date time, String reason){
        this.change = change;
        this.time = time;
        this.reason = reason;
    }


    public Integer getChange() {
        return change;
    }

    public void setChange(Integer change) {
        this.change = change;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int compareTo(CreditSort creditSort) {
        return (int) (creditSort.time.getTime() - this.time.getTime());
    }
}
