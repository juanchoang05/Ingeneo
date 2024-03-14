package com.api.transportservices.repositories;

import com.api.transportservices.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long > {

}
