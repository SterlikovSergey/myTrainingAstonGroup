package by.st.introduction.impl;

import by.st.introduction.RoleGrouper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultRoleGrouperImpl implements RoleGrouper {
    @Override
    public String groupLinesByRoles(String[] roles, String[] textLines) {
        Map<String, List<String>> roleLinesMap = new LinkedHashMap<>();
        for (String role : roles) {
            roleLinesMap.put(role, new ArrayList<>());
        }
        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            for (String role : roles) {
                if (line.startsWith(role + ":")) {
                    String text = line.substring(role.length() + 1).trim();
                    roleLinesMap.get(role).add((i + 1) + ") " + text);
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (String role : roles) {
            result.append(role).append(":\n");
            List<String> lines = roleLinesMap.get(role);
            for (String line : lines) {
                result.append(line).append("\n");
            }
            result.append("\n");
        }
        return result.toString().trim();
    }
}
