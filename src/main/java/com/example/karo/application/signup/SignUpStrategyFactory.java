package com.example.karo.application.signup;

import com.example.karo.domain.signup.SignUpStrategy;
import com.example.karo.shared.utils.SupportPackageScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SignUpStrategyFactory
{
    private final String PATH_PREFIX_OF_SIGNUP_STRATEGIES = "com.example.karo.application.signup.strategies";
    private ApplicationContext applicationContext;
    private Map<Class, SignUpStrategy> strategyMap;

    @Autowired
    public SignUpStrategyFactory(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
        strategyMap = new HashMap<>();

        this.init();
    }

    private void init()
    {
        SupportPackageScanner supportPackageScanner = new SupportPackageScanner();
        List<Class> listOfClassNames = supportPackageScanner.findAllClassesOfPackage(this.PATH_PREFIX_OF_SIGNUP_STRATEGIES, SignUpStrategy.class);

        for(int i = 0; i < listOfClassNames.size(); i++)
        {
            Class strategyClass = listOfClassNames.get(i);
            SignUpStrategy strategy = (SignUpStrategy) this.applicationContext.getBean(strategyClass);

            this.strategyMap.put(strategy.getClassOfInput(), strategy);
        }
    }

    public SignUpStrategy getStrategy(Class signUpInputClass)
    {
        return this.strategyMap.get(signUpInputClass);
    }
}
