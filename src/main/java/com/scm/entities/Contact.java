package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String picture;
    private String description;
    private boolean favorite=false;
    //private List<String> socialLinks=new ArrayList<>();

    private String websiteLink;
    private String LinkedInLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> links=new ArrayList<>();
}
