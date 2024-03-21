package com.gabrieloliveira.ProjetoFarmacia.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}


    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity faz cada id se auto incrementar
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 60, nullable = false, unique = true)//tamanho - n pode null e tem que ser unico, deixei null aqui tbm pra não dar problema no banco de dados caso aconteca algum erro
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 6, max = 60)
    private String username;

    @Column(name = "username", length = 60, nullable = false)
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class}) //empty mesma coisa q o not Null e not empty, ele faz os dois ao mesmo tempo
    @Size( groups = {CreateUser.class, UpdateUser.class}, min = 6, max = 60)
    private String password;

    //private List<Task> tasks = new ArrayList<Task>();


    public User() {
    }
    

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
