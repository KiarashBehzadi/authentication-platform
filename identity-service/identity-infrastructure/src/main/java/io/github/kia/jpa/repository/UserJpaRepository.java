package io.github.kia.jpa.repository;

import io.github.kia.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

}
