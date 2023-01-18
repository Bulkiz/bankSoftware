package com.example.bankSoftware.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import lombok.Getter;

@Getter
public class PageCustom<T> extends PageImpl<T> {
    private static final long serialVersionUID = 2964990893469667273L;

    private long fromRow;
    private long toRow;

    public PageCustom(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);

        this.fromRow = getPageable().getOffset() + 1;
        this.toRow = getPageable().getOffset() + getNumberOfElements();
    }

    public PageCustom(Page<T> page) {
        this(page.getContent(), page.getPageable(), page.getTotalElements());
    }
}
