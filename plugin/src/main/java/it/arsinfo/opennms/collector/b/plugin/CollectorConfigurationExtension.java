package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.config.collector.Collector;
import org.opennms.integration.api.v1.config.collector.Package;
import org.opennms.integration.api.xml.ClasspathCollectorConfigurationLoader;

import java.util.List;

public class CollectorConfigurationExtension implements org.opennms.integration.api.v1.config.collector.CollectorConfigurationExtension {

    private final org.opennms.integration.api.v1.config.collector.CollectorConfigurationExtension collectorConfiguration = new ClasspathCollectorConfigurationLoader(
            CollectorConfigurationExtension.class, "",
            "collector-configuration.xml"
    ).getCollectorConfiguration();

    @Override
    public List<Package> getPackages() {
        return this.collectorConfiguration.getPackages();
    }

    @Override
    public List<Collector> getCollectors() {
        return this.collectorConfiguration.getCollectors();
    }
}
