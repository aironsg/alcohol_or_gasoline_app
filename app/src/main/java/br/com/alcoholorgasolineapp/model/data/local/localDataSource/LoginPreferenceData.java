package br.com.alcoholorgasolineapp.model.data.local.localDataSource;

import android.content.Context;
import android.content.SharedPreferences;

import br.com.alcoholorgasolineapp.constants.Constants;
import br.com.alcoholorgasolineapp.model.entity.LoginEntity;

public class LoginPreferenceData {
    SharedPreferences preferences;

    private static LoginPreferenceData instance;

    LoginEntity login;


    public LoginPreferenceData(LoginEntity login) {
        this.login = login;
    }

    private LoginPreferenceData(Context context) {
        preferences = context.getSharedPreferences(Constants.LOGIN_PREFERENCE, Context.MODE_PRIVATE);
        this.login = new LoginEntity();
    }

    public static synchronized LoginPreferenceData getInstance(Context context) {
        if (instance == null) {
            instance = new LoginPreferenceData(context);
        }
        return instance;
    }

    public void saveStudent(LoginEntity login) {
        SharedPreferences.Editor save = preferences.edit();
        save.putString("name", login.getName());
        save.putString("email", login.getEmail());
        save.putString("password", login.getPassword());
        save.apply();
    }

}
