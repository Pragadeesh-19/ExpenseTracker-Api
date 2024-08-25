package org.pragadeesh.secjwt.model;

import lombok.Getter;

@Getter
public class JwtResonse {

    private final String jwtToken;

    public JwtResonse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

}
