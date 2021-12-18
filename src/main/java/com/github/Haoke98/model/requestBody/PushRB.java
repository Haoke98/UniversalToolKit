package com.github.Haoke98.model.requestBody;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class PushRB {
    private Long userId;//发文账号ID
    private Long positionId;//新系统发送者唯一标志
    private String title;
    private String name;
    private String content;
    private String link;
    private String keyword;
    private String[] area;
    private Integer[] industry;
    private Integer employee;
    private Integer fund;
    private String[] buildTime;
    private Long range;
    // 新加参数
    private Integer contact;
    private Integer brand;
    private Integer patent;
    private Integer copyright;
    private Integer iso;
    private Integer newTech;
    private Integer[] patents;
    private String[] enterpriseStatus;
    private String[] strategicIndustries;
    private String[] nativeplace;

    private Integer pageNo;
    private Integer pageSize;

    private Integer check;


    @Override
    public String toString() {
        return "PushRB{" +
                "userId=" + userId +
                ", positionId=" + positionId +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", keyword='" + keyword + '\'' +
                ", area=" + Arrays.toString(area) +
                ", industry=" + Arrays.toString(industry) +
                ", employee=" + employee +
                ", fund=" + fund +
                ", buildTime=" + Arrays.toString(buildTime) +
                ", range=" + range +
                ", contact=" + contact +
                ", brand=" + brand +
                ", patent=" + patent +
                ", copyright=" + copyright +
                ", iso=" + iso +
                ", newTech=" + newTech +
                ", patents=" + Arrays.toString(patents) +
                ", enterpriseStatus=" + Arrays.toString(enterpriseStatus) +
                ", strategicIndustries=" + Arrays.toString(strategicIndustries) +
                ", nativeplace=" + Arrays.toString(nativeplace) +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", check=" + check +
                '}';
    }
}
