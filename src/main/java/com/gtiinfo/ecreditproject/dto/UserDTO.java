package com.gtiinfo.ecreditproject.dto;


import com.gtiinfo.ecreditproject.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    @NotNull
    @Email(message = "Email should be valid", regexp = "^[\\w.\\-]+@([\\w.\\-]+\\.)+[\\w.]{2,4}$")
    private String email;

    private Role role;

    @NotBlank
    @NotNull
    private String firstname;

    @NotBlank
    @NotNull
    private String lastname;

    private String tel;

    private String agence;

    private Date dateNais;

    private LocalDateTime creationDate;

    private LocalDateTime lastEdited;

}
