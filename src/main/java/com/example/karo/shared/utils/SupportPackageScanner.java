package com.example.karo.shared.utils;

import com.example.karo.domain.signup.SignUpStrategy;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.List;
import java.util.stream.Collectors;

public class SupportPackageScanner
{
    public List<Class> findAllClassesOfPackage(String packagePathPrefix, Class<?> subTypesOf)
    {
        Reflections reflections = new Reflections(packagePathPrefix, new SubTypesScanner(false));
        List<Class> listOfClasses = reflections.getSubTypesOf(subTypesOf).stream().collect(Collectors.toList());

        return listOfClasses;
    }

    public List<String> findAllClassNamesOfPackage(String packagePathPrefix, Class<?> subTypesOf)
    {
        Reflections reflections = new Reflections(packagePathPrefix, new SubTypesScanner(false));
        List<String> listOfClassNames = reflections.getSubTypesOf(subTypesOf).stream().map(classItem -> classItem.getName()).collect(Collectors.toList());

        return listOfClassNames;
    }


}
