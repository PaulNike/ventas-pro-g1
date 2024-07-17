package com.codigo.msventaspro.service;

import com.codigo.msventaspro.aggregates.request.SignInRequest;
import com.codigo.msventaspro.aggregates.request.SignUpRequest;
import com.codigo.msventaspro.aggregates.response.AuthenticationResponse;
import com.codigo.msventaspro.entities.Usuario;

import java.util.List;

public interface AuthenticationService {
    Usuario signUpUser(SignUpRequest signUpRequest);
    Usuario signUpAdmin(SignUpRequest signUpRequest);
    List<Usuario> todos();

    AuthenticationResponse signin(SignInRequest signInRequest);

}
