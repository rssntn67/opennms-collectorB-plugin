package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.config.datacollection.ResourceType;
import org.opennms.integration.api.xml.ClassPathResourceTypesLoader;

import java.util.List;

public class ResourceTypesExtension implements org.opennms.integration.api.v1.config.datacollection.ResourceTypesExtension {

    private final ClassPathResourceTypesLoader classPathResourceTypesLoader =
            new ClassPathResourceTypesLoader(ResourceTypesExtension.class, "collector-b-resource.xml");

    @Override
    public List<ResourceType> getResourceTypes() {
        return classPathResourceTypesLoader.getResourceTypes();
    }}
