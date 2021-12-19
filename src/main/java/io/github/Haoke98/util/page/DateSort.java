package io.github.Haoke98.util.page;

import java.util.Date;
import java.util.HashMap;

/**
 * 时间类排序
 */
public class DateSort extends HashMap<String, Object> implements Comparable<DateSort> {

    private static final long serialVersionUID = 71278964498301243L;
    private String id;

    private String groupName;
    private Integer ways;
    private Date addTime;
    private String phone;
    private String fullName;
    private String weChat;
    private String company;
    private String positions;
    private Integer key;
    private String email;
    private String remarks;

    public DateSort() {
    }

    public DateSort(String id, String groupName, Integer ways, Date addTime, String phone
            , String fullName, String weChat, String company, String positions, Integer key
            , String email, String remarks) {
        this.id = id;
        this.groupName = groupName;
        this.ways = ways;
        this.addTime = addTime;
        this.phone = phone;
        this.fullName = fullName;
        this.weChat = weChat;
        this.company = company;
        this.positions = positions;
        this.key = key;
        this.email = email;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getWays() {
        return ways;
    }

    public void setWays(Integer ways) {
        this.ways = ways;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public int compareTo(DateSort dateSort) {
        return (int) (dateSort.addTime.getTime() - this.addTime.getTime());
    }
}
