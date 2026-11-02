package io.github.kia.service;


import io.github.kia.model.OtpPurpose;
import io.github.kia.repository.OtpRepository;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class OtpService {

    private static final int OTP_LENGTH = 6;

    private final SecureRandom secureRandom = new SecureRandom();

    private final OtpRepository otpRepository;

//    private final OtpEventPublisher eventPublisher;

    public OtpService(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }


    public void generateOtp(String phoneNumber, OtpPurpose purpose) {

        String otp = generateRandomOtp();

        otpRepository.saveOtp(phoneNumber, purpose, otp);

    }




    // method to generate randomOtp
    private String generateRandomOtp() {

        int bound = (int) Math.pow(10, OTP_LENGTH);

        int otp = secureRandom.nextInt(bound);

        return String.format("%0" + OTP_LENGTH + "d", otp);
    }



}
