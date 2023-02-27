package io.github.jvitosousa.domain.repositories;

import io.github.jvitosousa.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
