package io.github.Haoke98.model.pageHelper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SpecialPage<FROM, TO> {
    private int pageNo;
    private int pageSize;
    private int pages;
    private Long total;
    private List<TO> list;

    public SpecialPage(Page<FROM> page, SpecialPage.info<FROM, TO> ii) {
        this.pageNo = page.getNumber()+1;
        this.pages = page.getTotalPages();
        this.total = page.getTotalElements();
        this.pageSize = page.getSize();
        this.list = new ArrayList<>();
        for (FROM f : page.getContent()) {
            TO to = ii.getInfo(f);
            if (to != null) {
                this.list.add(to);
            }
        }
    }

    public interface info<FROM, TO> {
        TO getInfo(FROM f);
    }
}
