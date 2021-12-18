package com.github.Haoke98.model.templates.tencent;

import com.github.Haoke98.model.templates.Template;

public interface TencentTemplate extends Template {
    String getId();

    String getContent();

    String[] getParams();
}
