package com.example.trolyyte.domain.usecase;

import com.example.trolyyte.domain.model.NlpResult;
import com.example.trolyyte.domain.repository.NlpRepository;

public class ProcessTextUseCaseImpl implements ProcessTextUseCase {

    private final NlpRepository nlpRepository;

    public ProcessTextUseCaseImpl(NlpRepository nlpRepository) {
        this.nlpRepository = nlpRepository;
    }

    @Override
    public void execute(String text, Callback callback) {
        // Validate Input (Business Rule đơn giản)
        if (text == null || text.trim().isEmpty()) {
            callback.onFailure("Văn bản đầu vào không hợp lệ");
            return;
        }

        // Pre-processing (Chuẩn hóa sơ bộ trước khi gửi xuống Repository)
        String cleanText = text.trim().toLowerCase();

        // Gọi Repository để xử lý
        nlpRepository.processText(cleanText, new NlpRepository.NlpCallback() {
            @Override
            public void onSuccess(NlpResult result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(String error) {
                callback.onFailure(error);
            }
        });
    }
}