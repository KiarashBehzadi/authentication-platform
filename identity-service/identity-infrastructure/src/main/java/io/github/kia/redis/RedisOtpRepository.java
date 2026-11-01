package io.github.kia.redis;

import io.github.kia.model.OtpPurpose;
import io.github.kia.repository.OtpRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;


@Repository
public class RedisOtpRepository implements OtpRepository {

    private final RedisTemplate<String,String> redisTemplate;

    public RedisOtpRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void saveOtp(String phoneNumber, OtpPurpose purpose, String otp) {
        redisTemplate.opsForValue().
                set("otp:" + purpose.name() + ":" + phoneNumber,
                otp,
                Duration.ofMinutes(2));
    }

    @Override
    public Optional<String> getOtp(String phoneNumber, OtpPurpose purpose) {
        return Optional.ofNullable(
                redisTemplate
                        .opsForValue()
                        .get("otp:" + purpose.name() + ":" + phoneNumber));
    }

    @Override
    public void deleteOtp(String phoneNumber, OtpPurpose purpose) {
        redisTemplate.delete("otp:" + purpose.name() + ":" + phoneNumber);
    }


    /*
         where is this class ??
         might project does not have OtpRepository? in this case how is this?

         no we use and config redis for just otp , how about other liks login attempts and session and cache?
         Some this classes per them?

     */
}
