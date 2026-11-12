package com.example.trolyyte.presentation.common;

import com.example.trolyyte.domain.model.ResponseKey;

public interface ResponseTextProvider {

    // Lấy phản hồi theo tên hành động hội thoại.
    String getText(String key);

    default String getText(ResponseKey key) {
        return getText(key.name());
    }
}