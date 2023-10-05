package br.com.alcoholorgasolineapp.controller;

import android.content.Context;

import br.com.alcoholorgasolineapp.model.data.local.localDataSource.LoginPreferenceData;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;
import br.com.alcoholorgasolineapp.model.repository.LoginRepository;

public class LoginController implements LoginRepository {

    private LoginEntity loginEntity = new LoginEntity();
    private LoginPreferenceData data;
    @Override
    public void save(LoginEntity login, Context context) {
        data = LoginPreferenceData.getInstance(context);
        data.saveStudent(login);
    }

    @Override
    public LoginEntity findLogin(String email, String password) {
        return null;
    }

    @Override
    public boolean authenticationLogin(LoginEntity login) {
        return false;
    }
}
