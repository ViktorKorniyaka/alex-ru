package entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 08.08.13
 * Time: 18:15
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity (name = "MY_CLIENT") // сделать связь много к одному
public class Client extends BaseEntity {
    @Id   @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;

    private String clientName;
    private String clientEmail;
    private String clientTelephone;
    @ManyToOne  (cascade = CascadeType.ALL)    // проверить сохранение через клиента
    private User user;
    @OneToMany
    private Collection <Product> productCollection = new ArrayList<Product>();

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }
}
