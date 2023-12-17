package com.Carrier.GetJoB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "applicantsData")
@Builder

public class ApplicantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    public int phoneNumber;
    @Lob
    @Column(name = "imageData",length=1000)
    public byte[] imageData;
}
