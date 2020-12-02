package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
@Data
@Entity
@DynamicUpdate
public class User {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;

}
