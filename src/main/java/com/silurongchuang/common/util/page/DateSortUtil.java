package com.silurongchuang.common.util.page;

import com.silurongchuang.common.util.DateUtils;

import java.util.*;

/**
 * 排序工具类
 *
 */
public class DateSortUtil {

    /**
     * 降序排列
     * @param enterList
     * @return
     */
    public static List<Object> SortOut(List<Object> enterList) {
        // 进行排序
        List<DateSort> sortOutList = new ArrayList<>();
        List<Object> sortOutList1 = new ArrayList<>();
        for (Object map1 : enterList) {
            Map<String, Object> map = (Map<String, Object>) map1;
            sortOutList.add(new DateSort((String) map.get("id"),(String) map.get("groupName")
                    ,(Integer) map.get("ways"),(Date) map.get("addTime"),(String) map.get("phone")
                    ,(String) map.get("fullName"),(String) map.get("weChat"),(String) map.get("company")
                    ,(String) map.get("positions"),(Integer) map.get("key"),(String) map.get("email")
                    ,(String) map.get("remarks")));
        }

        sortOutList.sort(new Comparator<DateSort>() {
            @Override
            public int compare(DateSort o1, DateSort o2) {
                return o2.getAddTime().compareTo(o1.getAddTime()); //按日期排序
            }
        });
        System.out.println(sortOutList);

        // 初始化时间
        for (DateSort sortOut : sortOutList) {
            Map<String, Object> map = new HashMap<>();
            if (sortOut.getAddTime() != null) {
                String times = DateUtils.dateTime2(sortOut.getAddTime());
                map.put("addTime", times);
                map.put("fullName",sortOut.getFullName());
                map.put("groupName",sortOut.getGroupName());
                map.put("ways",sortOut.getWays());
                map.put("phone",sortOut.getPhone());
                map.put("id",sortOut.getId());
                map.put("weChat",sortOut.getWeChat());
                map.put("positions",sortOut.getPositions());
                map.put("key",sortOut.getKey());
                map.put("email",sortOut.getEmail());
                map.put("remarks",sortOut.getRemarks());
                map.put("company",sortOut.getCompany());
            }
            sortOutList1.add(map);
        }
        return sortOutList1;
    }


    /**
     * 降序排列
     * @param creditList
     * @return
     */
    public static List<Object> SortOutCredit(List<Object> creditList) {
        // 进行排序
        List<CreditSort> sortOutList = new ArrayList<>();
        List<Object> sortOutList1 = new ArrayList<>();
        for (Object map1 : creditList) {
            Map<String, Object> map = (Map<String, Object>) map1;
            // 获取当前一周的前后时间
            Map<String, Date> weekDate = DateUtils.getWeekDate();
            Date mondayDate = weekDate.get("mondayDate");
            Date sundayDate = weekDate.get("sundayDate");
            boolean effectiveDate = DateUtils.isEffectiveDate((Date) map.get("time"), mondayDate, sundayDate);
            if (effectiveDate) {
                sortOutList.add(new CreditSort((Integer) map.get("change"), (Date) map.get("time"), (String) map.get("reason")));
            }
        }

        Collections.sort(sortOutList);
        System.out.println(sortOutList);

        // 初始化时间
        for (CreditSort creditSort : sortOutList) {
            Map<String, Object> map2 = new HashMap<>();
            if (creditSort.getTime() != null) {
                String times = DateUtils.dateTime2(creditSort.getTime());
                map2.put("change", creditSort.getChange());
                map2.put("time",times);
                map2.put("reason",creditSort.getReason());
            }
            sortOutList1.add(map2);
        }
        return sortOutList1;
    }


    /**
     * 降序排列
     * @param orderList
     * @return
     */
    public static List<Map<String, Object>> orderSort(List<Map<String, Object>> orderList) {
        List<OrderSort> orderSortList = new ArrayList<>();
        List<Map<String, Object>> orderSortList1 = new ArrayList<>();

        for (Map<String, Object> map : orderList) {
            orderSortList.add(new OrderSort((String)map.get("name"),(Integer) map.get("companyCount"),map.get("key")
                    ,(Integer)map.get("order"),(Integer)map.get("status")));
        }
        Collections.sort(orderSortList);
        System.out.println(orderSortList);

        for (OrderSort orderSort : orderSortList) {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", orderSort.getName());
            map2.put("companyCount", orderSort.getMembers());
            map2.put("key", orderSort.getGroupId());
            map2.put("order", orderSort.getOrder());
            map2.put("status", orderSort.getStatus());
            orderSortList1.add(map2);

        }
        return orderSortList1;
    }

    /**
     * 降序排列
     * @param orderList
     * @return
     */
    public static List<Object> orderSort1(List<Map<String, Object>> orderList) {
        List<OrderSort> orderSortList = new ArrayList<>();
        List<Object> orderSortList1 = new ArrayList<>();

        for (Map<String, Object> map : orderList) {
            orderSortList.add(new OrderSort((String)map.get("name"),(Integer) map.get("members"),map.get("key")
                    ,(Integer)map.get("order"),(Integer)map.get("status")));
        }
        Collections.sort(orderSortList);
        System.out.println(orderSortList);

        for (OrderSort orderSort : orderSortList) {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", orderSort.getName());
            map2.put("members", orderSort.getMembers());
            map2.put("key", orderSort.getGroupId());
            map2.put("order", orderSort.getOrder());
            map2.put("status", orderSort.getStatus());
            orderSortList1.add(map2);

        }
        return orderSortList1;
    }
}
