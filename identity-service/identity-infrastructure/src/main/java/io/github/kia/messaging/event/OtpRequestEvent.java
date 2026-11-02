package io.github.kia.messaging.event;

import io.github.kia.model.OtpPurpose;

public class OtpRequestEvent {

    private String phoneNumber;
    private String otp;
    private OtpPurpose purpose;

    public OtpRequestEvent() {
    }

    public OtpRequestEvent(String phoneNumber, String otp, OtpPurpose purpose) {
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.purpose = purpose;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOtp() {
        return otp;
    }

    public OtpPurpose getPurpose() {
        return purpose;
    }
}
