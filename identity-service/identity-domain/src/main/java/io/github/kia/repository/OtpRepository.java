package io.github.kia.repository;

import io.github.kia.model.User;

import java.util.Optional;

public interface OtpRepository {

    void saveOtp(String phoneNumber, String otp);

    Optional<String>  getOtp(String phoneNumber);

    void deleteOtp(String phoneNumber);
}
