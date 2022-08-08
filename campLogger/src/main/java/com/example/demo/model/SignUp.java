package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Table
@Getter
@Setter
@Entity

public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Min(value = 0)
    @Max(23)
    private int currentTime;

    @ManyToOne

    private Camper camper;

    @ManyToOne

    private Activity activity;


    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @Override
    public String toString() {
        return "SignUp{" + "id=" + id + ", currentTime=" + currentTime + ", camper=" + camper + ", activity=" + activity + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
