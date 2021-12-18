package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class InviteCompanyToGroupRB {


    private Long key;//当前用户在群里的memberID，可以间接地获取群ID
    private Integer pageNo = 1;//第几页，页码
    private Integer pageSize = 10;//一次请求中能返回的最多数量
    private Integer contact = -1;
    private Integer brand = -1;
    private Integer patent = -1;
    private Integer copyright = -1;
    private Integer iso = -1;
    private Integer newTech = -1;
    private String keyword = "";
    private int fund = -1;
    private int employee = -1;
    private String[] area;
    private Integer[] industry;
    private Integer[] patents;//专利密集型产业代码列表（仅包含两级）
    private List<Integer> keyIndustry;
    private List<Integer> strategicIndustries;
    private List<Integer> type;
    private String[] enterpriseStatus;
    private String[] buildTime;//成立时间（最多2个，起和止）
    private String[] nativeplace;//法人籍贯代码列表（包含两级，最多3级）

    public Boolean checkForGroupAdd() {
        return key != null;
    }
}
