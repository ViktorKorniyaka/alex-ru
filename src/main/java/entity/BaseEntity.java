package entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 04.11.13
 * Time: 9:10
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class BaseEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID") //или над getId*/      //error SEQUENCE
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
