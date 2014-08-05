package com.springmvc.test.entity;

import com.springmvc.test.common.AbstractEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "t_user")
public class User extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(nullable = false, name = "user_name")
    @Pattern(regexp = "[A-Za-z0-9]{5,20}", message = "{username}")
    private String username;
    @Column(name = "pass_word")
    private String password;
    @Column(name = "email")
    @Email(message = "{email}")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
