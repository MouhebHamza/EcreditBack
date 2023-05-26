package com.gtiinfo.ecreditproject.entities;

import com.gtiinfo.ecreditproject.services.DemandeService;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @NotNull
    @Email(message = "Email should be valid", regexp = "^[\\w.\\.]+@([\\w.]+\\.)+[\\w.]{2,4}$")
    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "nom")

    @NotBlank
    @NotNull
    private String firstname;

    @Column(name = "prenom",unique = true)
    @NotBlank
    @NotNull

    private String lastname;

    private String tel;

    private String agence;
    @Column(name = "date_nais")

    private Date dateNais;
    @Column(name = "creation_date")

    private LocalDateTime creationDate;

    @Column(name = "last_edited")
    private LocalDateTime lastEdited;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
        lastEdited = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastEdited = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }



    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Demande> demandes = new HashSet<>();


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Simulation> simulations = new HashSet<>();;

//    @OneToMany(mappedBy = "user")
//    private List<RendezVous> rdv;
//
//    @OneToMany(mappedBy = "user")
//    private List<Notification> notifications;





    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}