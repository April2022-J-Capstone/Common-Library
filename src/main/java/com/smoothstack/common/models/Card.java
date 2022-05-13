package com.smoothstack.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String cardNickname;

    @Column(name = "card_holder_name", length = 45)
    private String cardHolderName;

    @Column(name = "card_expiration")
    private LocalDate cardExpiration;

    @Column(name = "card_security", length = 45)
    private String cardSecurity;

    @Column(name = "card_zip_code", length = 45)
    private String cardZipCode;
}