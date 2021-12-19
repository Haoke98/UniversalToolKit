package io.github.Haoke98.model.templates.ali;

import io.github.Haoke98.model.templates.Template;

public interface AliTemplate extends Template {
    String getCode();

    String getContent();

    String getParamsAsJson();
}
