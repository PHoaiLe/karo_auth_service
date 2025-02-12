package com.example.karo.application.signup.strategies;

import com.example.karo.domain.signup.SignUpStrategy;
import com.example.karo.domain.signup.dto.strategies.EaPSignUpInput;
import com.example.karo.domain.signup.dto.to_models.ToEaPAuthenEntityRecord;
import com.example.karo.domain.signup.exceptions.SignUpException;
import com.example.karo.infrastructure.repositories.authentications.entities.EaPAuthenEntity;
import com.example.karo.infrastructure.repositories.authentications.cores.MySqlJpaEaPAuthen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EaPAuthenSignupStrategy extends SignUpStrategy<EaPAuthenEntity, EaPSignUpInput, ToEaPAuthenEntityRecord>
{
    private static final Class INPUT_TO_HANDLE = EaPSignUpInput.class;
    private MySqlJpaEaPAuthen jpaEaPAuthenRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EaPAuthenSignupStrategy(MySqlJpaEaPAuthen jpaEaPAuthenRepository, PasswordEncoder passwordEncoder)
    {
        super(INPUT_TO_HANDLE);
        this.jpaEaPAuthenRepository = jpaEaPAuthenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected EaPAuthenEntity genModelFrom(ToEaPAuthenEntityRecord record) {
        return EaPAuthenEntity.getInstance(record.getEmail(), record.getHashedPassword());
    }

    @Override
    public EaPAuthenEntity signUp(EaPSignUpInput input) throws SignUpException
    {
        Optional<EaPAuthenEntity> isAuthInfoExisting = jpaEaPAuthenRepository.findByEmail(input.getEmail());
        if(isAuthInfoExisting.isEmpty() == false)
        {
            throw SignUpException.AUTH_INFO_ALREADY_EXISTED;
        }

        String hashedPassword = passwordEncoder.encode(input.getPassword());

        ToEaPAuthenEntityRecord toEaPAuthenEntityRecord = ToEaPAuthenEntityRecord.builder()
                        .email(input.getEmail())
                                .hashedPassword(hashedPassword)
                                        .build();

        return jpaEaPAuthenRepository.save(this.genModelFrom(toEaPAuthenEntityRecord));
    }
}
