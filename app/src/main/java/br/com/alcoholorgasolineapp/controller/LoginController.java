package br.com.alcoholorgasolineapp.controller;

import android.content.Context;
import android.widget.Toast;

import br.com.alcoholorgasolineapp.R;
import br.com.alcoholorgasolineapp.model.data.local.localDataSource.LoginPreferenceData;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;
import br.com.alcoholorgasolineapp.model.repository.LoginRepository;

public class LoginController implements LoginRepository {

    private LoginEntity loginEntity;
    private LoginPreferenceData data;

    @Override
    public void save(LoginEntity entity, Context context) {
        data = LoginPreferenceData.getInstance(context);
        data.saveLogin(entity);
    }

    @Override
    public boolean findLogin(String email, String password, Context context) {
        data = LoginPreferenceData.getInstance(context);
        loginEntity = data.findLogin();
        if (loginEntity.getEmail().equals(email) && loginEntity.getPassword().equals(password)) {

            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean authenticationLogin(Context context) {
        data = LoginPreferenceData.getInstance(context);
        loginEntity = data.findLogin();
        if (!loginEntity.getEmail().equals("NA") && !loginEntity.getPassword().equals("NA") &&
                !loginEntity.getEmail().isEmpty() && !loginEntity.getPassword().isEmpty()) {
            Toast.makeText(context, R.string.txt_authorizationSuccess, Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}
