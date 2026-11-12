package com.example.trolyyte.domain.usecase;

import com.example.trolyyte.domain.model.UserProfile;
import com.example.trolyyte.domain.repository.UserProfileRepository;

public class SaveUserProfileUseCase {

    private final UserProfileRepository repository;

    public SaveUserProfileUseCase(UserProfileRepository repository) {
        this.repository = repository;
    }

    public void execute(UserProfile profile) {
        // Tên hồ sơ không được để trống.
        if (profile.getName() == null || profile.getName().trim().isEmpty()) {
            profile.setName("Ông/Bà");
        }

        // Gọi xuống Repository để thực hiện lưu trữ (Repository sẽ lo việc set id = 1)
        repository.saveProfile(profile);
    }
}