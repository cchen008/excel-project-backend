package com.capgemini.group2.exceldemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.group2.exceldemo.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
