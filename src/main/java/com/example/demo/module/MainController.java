package com.example.demo.module;

import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "home")
public class MainController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping(path = "/addProfile")
    public @ResponseBody
    String addNewProfile(
            @RequestParam String username,
            @RequestParam String bio,
            @RequestParam String email) {
        Profile profile = new Profile();
        profile.setUsername(username);
        profile.setBio(bio);
        profile.setEmail(email);

        profileRepository.save(profile);

        return "Sukses GAN ! ! !";
    }

    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<Profile> getAllProfile() {
        return profileRepository.findAll();
    }
}
