package com.silurongchuang.common.model.templates.ali;

import com.silurongchuang.common.model.templates.Template;

public interface AliTemplate extends Template {
    String getCode();

    String getContent();

    String getParamsAsJson();
}
