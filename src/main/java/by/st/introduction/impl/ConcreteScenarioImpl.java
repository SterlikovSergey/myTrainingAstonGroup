package by.st.introduction.impl;

import by.st.introduction.RoleGrouper;
import by.st.introduction.Scenario;

import java.util.*;

public class ConcreteScenarioImpl implements Scenario {
    private final String[] roles;
    private final String[] textLines;
    private final RoleGrouper roleGrouper;
    private String result;


    public ConcreteScenarioImpl(String[] roles, String[] textLines, RoleGrouper roleGrouper) {
        this.roles = roles;
        this.textLines = textLines;
        this.roleGrouper = roleGrouper;
    }

    @Override
    public void start() {
        System.out.println("application is running");
        System.out.println("Sample Input:  " +  Arrays.toString(getRoles()) + " " + Arrays.toString(getTextLines()));
    }

    @Override
    public void end() {
        result = roleGrouper.groupLinesByRoles(roles,textLines);
        System.out.println(result);
    }

    public String getResult() {
        return result;
    }

    public String[] getRoles() {
        return roles;
    }

    public String[] getTextLines() {
        return textLines;
    }
}