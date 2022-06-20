package com.example.crud.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.crud.dao.ParticipantDaoImpl;
import com.example.crud.entity.*;
import javax.persistence.*;

@Entity
@Table(name = "participant")
public class Participant{

    @Id
    @Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;



	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@JoinColumn(name = "passport_id")
	@OneToOne(
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private Passport passport;

    @OneToMany(mappedBy="participant",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<MedicalResearch> medicalReasearches;


    public Participant() {
        		
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
    }
    
    public List<MedicalResearch> getResearch() {
		return medicalReasearches;
	}

	public void setMedicalResearch(List<MedicalResearch> medicalReasearches) {
		this.medicalReasearches = medicalReasearches;
	}
	
	// add convenience methods for bi-directional relationship
	
	public void add(MedicalResearch newMedicalReasearch) {
		
		if (medicalReasearches == null) {
			medicalReasearches = new ArrayList<>();
		}
		
		medicalReasearches.add(newMedicalReasearch);
		
		newMedicalReasearch.setParticipant(this);
	}






}