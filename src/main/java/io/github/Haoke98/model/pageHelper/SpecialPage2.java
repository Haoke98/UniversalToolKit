package io.github.Haoke98.model.pageHelper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SpecialPage2<FROM, TO> {
    private int pageNo;
    private int pageSize;
    private int pages;
    private Long total;
    private Boolean sorted;
    private final Boolean paged = Boolean.TRUE;
    private Boolean first;
    private Boolean last;
    private Boolean empty;
    private List<TO> content;

    public SpecialPage2(Page<FROM> from, info<FROM, TO> ii) {
        this.pageNo = from.getNumber() + 1;
        this.pageSize = from.getSize();
        this.pages = from.getTotalPages();
        this.total = from.getTotalElements();
        this.sorted = from.getSort().isSorted();
        this.first = from.isFirst();
        this.last = from.isLast();
        this.empty = from.isEmpty();
        this.content = new ArrayList<>();

        for (FROM f :
                from.getContent()) {
            TO to = ii.getInfo(f);
            if (to != null) {
                this.content.add(to);
            }
        }

    }

    public interface info<FROM, TO> {
        TO getInfo(FROM f);
    }
}
