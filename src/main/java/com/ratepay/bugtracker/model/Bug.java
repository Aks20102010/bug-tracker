package com.ratepay.bugtracker.model;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "bug")
public class Bug implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bug_id")
    private Long id;
    private String name;
    private String description;
    private Date bugOpened;
    private String createdBy;

}
