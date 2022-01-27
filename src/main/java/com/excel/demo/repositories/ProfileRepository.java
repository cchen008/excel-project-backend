package com.excel.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.demo.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
