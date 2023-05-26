package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Table(name = "rdv")
public class RendezVous {
    @Id
    @SequenceGenerator(name = "rdv_seq", sequenceName = "RDV_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rdv_seq")
    private Long id;
    @Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "end")
    private LocalDateTime end;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "canceled_at")
    private LocalDateTime canceledAt;

    @OneToOne
    @JoinColumn(name = "id_canceler")
    private User canceler;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
