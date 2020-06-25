package com.example.demo.logs;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOGS")
public class JobName implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="JOB_NAME")
    private String Job_Name;

    public String getJob_Name() {
        return Job_Name;
    }
    public void setJob_Name(String job_Name) {
        Job_Name = job_Name;
    }

}
