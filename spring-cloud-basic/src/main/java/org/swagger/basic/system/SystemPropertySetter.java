package org.swagger.basic.system;

import java.util.Properties;

public class SystemPropertySetter {

    public static void setNetworkInterfaceSelectionProperties() {
        Properties systemProperties = System.getProperties();
        systemProperties.put("spring.cloud.inetutils.ignored-interfaces[0]", ".*VMware.*|.*Hamachi.*");
    }
}
