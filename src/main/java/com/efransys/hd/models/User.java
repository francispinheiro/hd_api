package com.efransys.hd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.Objects;

@Entity
@Table(name = "User.TABLE_NAME")
public class User {

    public interface CreateUser {
    }

    public interface UpdateUser {
    }

    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "usu_nome", length = 100, nullable = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 4, max = 100)
    private String userName;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", length = 200, nullable = false)
    @NotNull(groups = { CreateUser.class, UpdateUser.class })
    @NotEmpty(groups = { CreateUser.class, UpdateUser.class })
    @Size(groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 200)
    private String password;

    // private List<Task> tasks = new ArrayList<Task>();

    public User() {
    }

    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
