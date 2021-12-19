package io.github.Haoke98.model.templates.tencent;

import io.github.Haoke98.model.templates.Template;

public interface TencentTemplate extends Template {
    String getId();

    String getContent();

    String[] getParams();
}
