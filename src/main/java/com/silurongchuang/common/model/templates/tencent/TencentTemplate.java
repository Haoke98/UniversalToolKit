package com.silurongchuang.common.model.templates.tencent;

import com.silurongchuang.common.model.templates.Template;

public interface TencentTemplate extends Template {
    String getId();

    String getContent();

    String[] getParams();
}
