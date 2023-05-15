//BEARER TOKEN:
package com.atribus.Atribus.security;

import lombok.Data;

@Data
public class AuthCredentials {

    private String email;
    private String password;

}
