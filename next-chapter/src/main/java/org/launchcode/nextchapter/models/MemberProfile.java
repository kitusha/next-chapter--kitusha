package org.launchcode.nextchapter.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MemberProfile {

    private List<Club> Clubs;

    //@Getter
    //@Setter
   // @NoArgsConstructor
   // @AllArgsConstructor
    @Entity
    @Table(name= "MemberProfile")
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;


        @Column(name = "first_name")
        private String firstName; // Note: Java String should be capitalized

        @Column(name = "last_name") // Corrected quotation marks
        private String lastName; // Note: Java String should be capitalized

        @Column(name = "email_id")
        private String emailId; // Note: Java String should be capitalized

        public String getEmailId(String emailId) {
            return emailId;
        }

        // Getters and setters (or use Lombok for automatic generation)
        // Constructor(s), additional methods, etc.
    }


    public List<Club> getClubs() {
        List<Club> clubs;
        List<Club> Club = null;
        return Club;
    }

    public void setClubs(List<Club> clubs) {
        this.Clubs = clubs;
    }
}
