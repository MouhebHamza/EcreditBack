package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
    
@Entity
@Getter
@Setter
@Data
@Table(name = "notifications")
public class Notification  {

    @Id
    @SequenceGenerator(name = "notif_seq", sequenceName = "NOTIF_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notif_seq")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "created_at")
    private Date createdAt;


    @Column(name = "is_read")
    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


}