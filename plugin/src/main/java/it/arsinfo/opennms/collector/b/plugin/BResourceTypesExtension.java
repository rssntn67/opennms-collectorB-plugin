package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.config.datacollection.ResourceType;
import org.opennms.integration.api.xml.ClassPathResourceTypesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BResourceTypesExtension implements org.opennms.integration.api.v1.config.datacollection.ResourceTypesExtension {

    private static final Logger LOG = LoggerFactory.getLogger(BResourceTypesExtension.class);

    private final ClassPathResourceTypesLoader classPathResourceTypesLoader =
            new ClassPathResourceTypesLoader(BResourceTypesExtension.class, "collector-b-resource.xml");

    @Override
    public List<ResourceType> getResourceTypes() {
        LOG.warn(classPathResourceTypesLoader.getResourceTypes().toString());
        return classPathResourceTypesLoader.getResourceTypes();
    }}
