package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.config.datacollection.ResourceType;
import org.opennms.integration.api.xml.ClassPathResourceTypesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResourceTypesExtension implements org.opennms.integration.api.v1.config.datacollection.ResourceTypesExtension {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceTypesExtension.class);

    private final ClassPathResourceTypesLoader classPathResourceTypesLoader =
            new ClassPathResourceTypesLoader(ResourceTypesExtension.class, "collector-b-resource.xml");

    public ResourceTypesExtension() {
        for (ResourceType resourceType: classPathResourceTypesLoader.getResourceTypes())
            LOG.warn(resourceType.getName());
    }

    @Override
    public List<ResourceType> getResourceTypes() {
        return classPathResourceTypesLoader.getResourceTypes();
    }}
