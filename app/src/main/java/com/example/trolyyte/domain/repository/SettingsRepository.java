package com.example.trolyyte.domain.repository;

public interface SettingsRepository {
    // Lưu tốc độ đọc (Ví dụ: 0.5 là chậm, 1.0 là bình thường, 2.0 là nhanh)
    void saveTtsSpeed(float speed);

    // Lấy tốc độ đọc đã lưu.
    float getTtsSpeed();

    int getHistoryRetentionDays();
    void saveHistoryRetentionDays(int days);
}