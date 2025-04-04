package org.amms.apiexample.repository;

import org.amms.apiexample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
