package com.example.trolyyte.domain.repository;

import com.example.trolyyte.domain.model.NlpResult;

public interface NlpRepository {

    interface NlpCallback {
        void onSuccess(NlpResult result);
        void onError(String error);
    }

    void processText(String text, NlpCallback callback);
}