package io.github.kia.repository;

import io.github.kia.model.OtpPurpose;
import io.github.kia.model.User;

import java.util.Optional;

public interface OtpRepository {

    void saveOtp(String phoneNumber, OtpPurpose purpose, String otp);

    Optional<String>  getOtp(String phoneNumber, OtpPurpose purpose);

    void deleteOtp(String phoneNumber, OtpPurpose purpose);
}
