package br.com.alcoholorgasolineapp.model.repository;

import android.content.Context;

import br.com.alcoholorgasolineapp.model.entity.LoginEntity;

public interface LoginRepository {

    public void save(LoginEntity login, Context context);
    public LoginEntity findLogin(String email, String password);

    public boolean authenticationLogin(LoginEntity login);
}
