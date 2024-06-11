package by.st.introduction;


import by.st.introduction.impl.ConcreteScenarioImpl;
import by.st.introduction.impl.DefaultRoleGrouperImpl;
import by.st.introduction.initialData.SourceData;

public class playScriptMain {
    public static void main(String[] args) {
        SourceData sourceData = new SourceData();
        RoleGrouper roleGrouper = new DefaultRoleGrouperImpl();
        ConcreteScenarioImpl concreteScenarioImpl = new ConcreteScenarioImpl(sourceData.getROLES(),
                sourceData.getTEXT_LINES(),
                roleGrouper);
        concreteScenarioImpl.start();
        concreteScenarioImpl.end();
    }
}
