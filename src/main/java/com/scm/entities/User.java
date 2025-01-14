package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String about;
    @Column(name = "profile_pic")
    private String profilePic;
    @Column(name = "phone_number")
    private String phoneNumber;
    // information
    private boolean enabled = false;
    @Column(name = "email-verified")
    private boolean emailVerified = false;
    @Column(name = "phone-verified")
    private boolean phoneVerified = false;

    // self signup, or google, or facebook, or twitter
    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    @Column(name = "profile-user-id")
    private String provideUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
}
