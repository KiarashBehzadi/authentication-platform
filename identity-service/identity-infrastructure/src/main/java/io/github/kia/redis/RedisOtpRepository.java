package io.github.kia.redis;

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
    public void saveOtp(String phoneNumber, String otp) {
        redisTemplate.opsForValue().
                set("otp:" + phoneNumber,
                otp,
                Duration.ofMinutes(2));
    }

    @Override
    public Optional<String> getOtp(String phoneNumber) {
        return Optional.ofNullable(
                redisTemplate
                        .opsForValue()
                        .get("otp:" + phoneNumber));
    }

    @Override
    public void deleteOtp(String phoneNumber) {
        redisTemplate.delete(phoneNumber);
    }

    /*
         where is this class ??
         might project does not have OtpRepository? in this case how is this?

         no we use and config redis for just otp , how about other liks login attempts and session and cache?
         Some this classes per them?

     */
}
