package com.ecom.userDetails.userDetailsMicro.DTO;

import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailsDTO {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phomeNumber;
    private Date createdAt;
    private Date updatedAt;

}
