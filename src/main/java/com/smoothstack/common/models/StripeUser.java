package com.smoothstack.common.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stripe.model.Charge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "stripe_user")
public class StripeUser {

    @Id
    @Column(name = "users_id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "stripe_id")
    private String stripe_id;
}
