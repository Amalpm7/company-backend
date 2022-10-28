package com.nestdigital.companybackend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaves")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveModel {

    @Id
    @GeneratedValue
    private int id;
    private String type;
    private int emp_id;
    private String description;
    private String applyDate;
    private String leaveDate;
    private int Status;

}
