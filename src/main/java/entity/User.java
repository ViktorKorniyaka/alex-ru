package entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Entity (name = "MY_USERS")   // сделать связь один ко многим
/*@SequenceGenerator( name = "SEQ_ID", sequenceName = "users_id_seq", allocationSize = 1 )*/          //Hibernate mapping exception
public class User extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String login;
    private String password;
    private String email;
    @OneToMany
    private Collection <Client> client = new ArrayList<Client>();
    @OneToMany
    private Collection<Product> product = new ArrayList<Product>();

    public Collection<Product> getProduct() {
        return product;
    }

    public void setProducts(Collection<Product> product) {
        this.product = product;
    }

    public Collection<Client> getClient() {
        return client;
    }

    public void setClient(Collection<Client> client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
