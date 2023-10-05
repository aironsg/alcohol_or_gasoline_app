package br.com.alcoholorgasolineapp.utils;

import br.com.alcoholorgasolineapp.model.entity.LoginEntity;

public interface ValidateLogin {
    public LoginEntity getLoginEntityData();
    public boolean validateRegister();
}
