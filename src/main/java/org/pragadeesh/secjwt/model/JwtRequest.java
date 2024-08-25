package org.pragadeesh.secjwt.model;

import lombok.Data;

@Data
public class JwtRequest {

    private String username;
    private String password;

}
