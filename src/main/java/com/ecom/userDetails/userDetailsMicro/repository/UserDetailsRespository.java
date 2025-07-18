package com.ecom.userDetails.userDetailsMicro.repository;

import com.ecom.userDetails.userDetailsMicro.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRespository extends JpaRepository<UserDetails,Integer> {

}
