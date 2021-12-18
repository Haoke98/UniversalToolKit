package com.silurongchuang.common.model.requestBody;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
@Setter
@Getter
public class SearchRB {
    int pageNo = 1;
    int pageSize = 10;
    Integer employee = -1;//员工人数
    int fund = -1;//注册资金
    String keyword;//关键字
    String[] area;//行政区域划分代码（包三级）
    Integer[] industry;//行业代码（包三级）
    String[] buildTime;//成立时间
    String[] enterpriseStatus;//存续状态
    String[] strategicIndustryTypes;
    int contact = -1;//有无联系方式 ，1：有，0：无。
    int brand = -1;//是否拥有商标，1：拥有，0：不拥有。
    int patent = -1;//有无专利信息，1：有，0：无
    int copyright = -1;//有无软件著作权，1：有，0：无
    int iso = -1;//是否是贯标企业，1：是，0：否
    int newTech = -1;//是否是高新技术企业，1：是，0:否
    Integer[] patents;//专利密集型产业分类
    String[] nativeplace;//法人籍贯

    @Override
    public String toString() {
        return "SearchRequestBody{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", employee=" + employee +
                ", fund=" + fund +
                ", keyword='" + keyword + '\'' +
                ", area=" + Arrays.toString(area) +
                ", industry=" + Arrays.toString(industry) +
                ", buildTime=" + Arrays.toString(buildTime) +
                ", enterpriseStatus=" + Arrays.toString(enterpriseStatus) +
                ", strategicIndustryTypes=" + Arrays.toString(strategicIndustryTypes) +
                ", contact=" + contact +
                ", brand=" + brand +
                ", patent=" + patent +
                ", copyright=" + copyright +
                ", iso=" + iso +
                ", newTech=" + newTech +
                ", patents=" + Arrays.toString(patents) +
                ", nativeplace='" + nativeplace + '\'' +
                '}';
    }
}
