package br.com.alcoholorgasolineapp.model.data.local.localDataSource;

import android.content.Context;
import android.content.SharedPreferences;

import br.com.alcoholorgasolineapp.constants.Constants;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;

public class LoginPreferenceData {
    SharedPreferences preferences;

    private static LoginPreferenceData instance;

    LoginEntity entity;


    public LoginPreferenceData(LoginEntity entity) {
        this.entity = entity;
    }

    private LoginPreferenceData(Context context) {
        preferences = context.getSharedPreferences(Constants.LOGIN_PREFERENCE, Context.MODE_PRIVATE);
        this.entity = new LoginEntity();
    }

    public static synchronized LoginPreferenceData getInstance(Context context) {
        if (instance == null) {
            instance = new LoginPreferenceData(context);
        }
        return instance;
    }

    public void saveLogin(LoginEntity entityLogin) {
        SharedPreferences.Editor save = preferences.edit();
        entity = entityLogin;
        save.putString("name", entity.getName());
        save.putString("email", entity.getEmail());
        save.putString("password", entity.getPassword());
        save.apply();
    }

    public LoginEntity findLogin() {
        entity = new LoginEntity();
        entity.setEmail(preferences.getString("name", "NA"));
        entity.setPassword(preferences.getString("password", "NA"));
        return entity;
    }

}
