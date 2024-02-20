package org.launchcode.nextchapter.controllers;

import org.launchcode.nextchapter.data.MemberProfileRepository;
import org.launchcode.nextchapter.models.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

//import static com.sun.tools.javax.main.Option.X;

@RestController
@RequestMapping("/api/v1/member-profiles")
public class MemberProfileController {

    @Autowired
    private MemberProfileRepository memberProfileRepository;

    @GetMapping
    public List<MemberProfile> getAllMemberProfiles() {
        return (List<MemberProfile>) memberProfileRepository.findAll();
    }

    @PostMapping
    public MemberProfile createMemberProfile(@RequestBody MemberProfile memberProfile) {
        return memberProfileRepository.save(memberProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberProfile> getMemberProfileById(@PathVariable Long id) {
        MemberProfile memberProfile = memberProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member Profile not found with id: " + id));
        return ResponseEntity.ok(memberProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberProfile> updateMemberProfile(@PathVariable Long id, @RequestBody MemberProfile memberProfileDetails) {
        MemberProfile updateMemberProfile = memberProfileRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Member Profile not found with id: " + id));
        updateMemberProfile.setFirstName(memberProfileDetails.getFirstName());
        updateMemberProfile.setLastName(memberProfileDetails.getLastName());
        updateMemberProfile.setEmailId(memberProfileDetails.getEmailId());

        memberProfileRepository.save(updateMemberProfile);
        return ResponseEntity.ok(updateMemberProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMemberProfile(@PathVariable int id) {
        MemberProfile memberProfile = memberProfileRepository.findById(getId())
                .orElseThrow(() -> new ResourceNotFoundException("Member Profile not exist with id: " + id));

        memberProfileRepository.delete(memberProfile);

        return ResponseEntity.noContent().build();
    }

    private static Long getId(Long id){
        return id;
    }

    private class ResourceNotFoundException extends MemberProfile{
        public ResourceNotFoundException(String s){
        }
    }
}