package com.smoothstack.common.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_information")
public class UserInformation {
    @Id
    @Column(name = "users_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "phone_number", length = 45)
    private String phoneNumber;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "veteran_status")
    private Boolean veteranStatus;

    @Column(name = "email_confirmed")
    private Boolean emailConfirmed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "communication_type_id")
    private CommunicationMethod communicationType;
}