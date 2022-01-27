package com.capgemini.group2.exceldemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.group2.exceldemo.models.Profile;
import com.capgemini.group2.exceldemo.repositories.ProfileRepository;

@CrossOrigin(origins = {"https://excel-project-frontend.herokuapp.com/", "http://localhost:3000/"})
@RestController
@RequestMapping("api/v1/profiles")
public class ProfileController {
	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping
	public List<Profile> getProfiles() {
		return profileRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Profile> getOneProfile(@PathVariable Integer id) {
		return profileRepository.findById(id);
	}
	
	@PostMapping
	public Profile addProfile(@RequestBody final Profile profile) {
		return profileRepository.saveAndFlush(profile);
	}
	
	@DeleteMapping("{id}")
	public void deleteProfile(@PathVariable Integer id) {
		profileRepository.deleteById(id);
	}
	
	@PutMapping("{id}")
	public Profile updateProfile(@PathVariable Integer id, @RequestBody Profile profile) {
		Profile originalProfile = profileRepository.getById(id);
		originalProfile.setFirst_name(profile.getFirst_name());
		originalProfile.setLast_name(profile.getLast_name());
		originalProfile.setLocation(profile.getLocation());
		originalProfile.setOccupation(profile.getOccupation());
		return profileRepository.saveAndFlush(originalProfile);
	}
	
	@PostMapping("list")
	public List<Profile> addAllProfiles(@RequestBody List<Profile> profile) {
		return profileRepository.saveAllAndFlush(profile);
	}
	
}
