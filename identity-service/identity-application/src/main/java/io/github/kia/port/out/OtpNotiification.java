package io.github.kia.port.out;

import io.github.kia.model.OtpPurpose;

public interface OtpNotiification {

    void sendOtp(
            String phoneNumber,
            OtpPurpose purpose,
            String otp
    );

}
