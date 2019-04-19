package com.tsinghuait.st0717.hospitalsystem.dto;
/**
 * Diagnosis generated by MyEclipse - Hibernate Tools
 */
public class Diagnosis   implements java.io.Serializable{
    // Fields    
     private Integer id;
     private String type;
     private String info;
     private Integer doctorId;
     private Integer patientId;
    public Diagnosis() {
    }
    public Diagnosis(Integer id) {
        this.id = id;
    }
    public Diagnosis(Integer id, String type, String info, Integer doctorId, Integer patientId) {
        this.id = id;
        this.type = type;
        this.info = info;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }   
    // Property accessors
    public Integer getId() {
        return this.id;
    }    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getInfo() {
        return this.info;
    }    
    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getDoctorId() {
        return this.doctorId;
    }
    
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return this.patientId;
    }
    
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
   








}