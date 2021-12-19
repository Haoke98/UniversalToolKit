package io.github.Haoke98.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageHelper {
    /**
     * 获取分页请求
     *
     * @param pageNo   页码，范围：[0,n]
     * @param pageSize
     * @return
     */
    public static Pageable creatPageRequest(Integer pageNo, Integer pageSize) {
        //按照发布时间降序排序
        Sort.Order order = Sort.Order.desc("createdAt");
        Sort sort = Sort.by(order);
        return PageRequest.of(pageNo, pageSize, sort);
    }
}
