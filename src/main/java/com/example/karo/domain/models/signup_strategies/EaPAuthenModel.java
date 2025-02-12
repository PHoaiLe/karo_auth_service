package com.example.karo.domain.models.signup_strategies;


import com.example.karo.domain.models.AuthenticationModel;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EaPAuthenModel<ENTITY extends AuthenticationModel> extends AuthenticationModel<ENTITY>
{
    @NonNull
    protected String email;
    @NonNull
    protected String password;

    protected EaPAuthenModel() {}

    protected EaPAuthenModel(@NonNull String email, @NonNull String password)
    {
        this.email = email;
        this.password = password;
    }

    protected EaPAuthenModel(@NonNull AuthenticationModel model)
    {
        this.email = ((EaPAuthenModel) model).email;
        this.password = ((EaPAuthenModel) model).password;
    }

    @Override
    public String toString() {
        return "email='" + email + '\'' +
                ", password='" + password + '\'';
    }


}
