package CRUD.API.WEB.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="firstname", nullable=false, length=50)
    private String firstname;

    @Column (name="surname", nullable=false, length=50)
    private String surname;

    @Column (name="telephone", nullable=false, length=50, unique = true)
    private String telephone;

    @Column (name="email", nullable=false, length=50, unique = true)
    private String email;

   @Column
    private LocalDate dateofbirthday;

    public Client() {
    }

    public Client(Long id, String firstname, String surname, String telephone, String email,LocalDate dateofbirthday) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.dateofbirthday = dateofbirthday;
    }

    public Client(String firstname, String surname, String telephone, String email, LocalDate dateofbirthday) {
        this.firstname = firstname;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.dateofbirthday = dateofbirthday;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dateofbirthday=" + dateofbirthday +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateofbirthday() {
        return dateofbirthday;
    }

    public void setDateofbirthday(LocalDate dateofbirthday) {
        this.dateofbirthday = dateofbirthday;
    }




}
