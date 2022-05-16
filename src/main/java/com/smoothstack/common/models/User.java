package com.smoothstack.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "password", length = 45)
    private String password;

    @ManyToMany
    @JoinTable(name = "assigned_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRole> userRoles;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserInformation userInformation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CommunicationMethod> communicationMethods;

    @OneToMany
    @JoinTable(name = "driver_review",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviews;

    @OneToMany
    @JoinTable(name = "saved_card",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> savedCards;

    @OneToMany
    @JoinTable(name = "saved_locations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> savedLocations;
}