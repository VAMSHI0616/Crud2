package com.example.crud.entity;


import javax.persistence.*;

@Entity
    @Table(name="medicalresearch")
    public class MedicalResearch{


        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name="title")
        private String title;

        @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
        @JoinColumn(name="participant_id")
        private Participant participant;

        public MedicalResearch() {

        }

        public MedicalResearch(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Participant getInstructor() {
            return participant;
        }

        public void setParticipant(Participant participant) {
            this.participant = participant;
        }

        @Override
        public String toString() {
            return "Course [id=" + id + ", title=" + title + "]";
        }


    }

