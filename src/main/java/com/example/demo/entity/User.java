package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Objects;

@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @CreatedDate
    @Column(name = "create_time", updatable = false, nullable = false, columnDefinition = "datetime(3)")
    private Timestamp createTime;

    @LastModifiedDate
    @Column(name = "update_time", nullable = false, columnDefinition = "datetime(3)")
    private Timestamp updateTime;

    @Column(name = "username", nullable = false, unique = true, columnDefinition = "varchar(30)")
    private String userName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "gender", columnDefinition = "tinyint default 0")
    private int gender;

    @Column(name = "birthday", columnDefinition = "datetime(3) default '1970-01-01'")
    private Timestamp birthday;

    @Column(name = "role", columnDefinition = "tinyint default 0")
    private int role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
