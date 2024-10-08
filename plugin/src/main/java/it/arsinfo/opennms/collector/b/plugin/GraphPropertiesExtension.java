package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.config.datacollection.graphs.PrefabGraph;
import org.opennms.integration.api.xml.ClassPathGraphPropertiesLoader;

import java.util.List;

public class GraphPropertiesExtension implements org.opennms.integration.api.v1.config.datacollection.graphs.GraphPropertiesExtension {

    private final ClassPathGraphPropertiesLoader graphPropertiesLoader = new ClassPathGraphPropertiesLoader(GraphPropertiesExtension.class,
            "b-graph.properties");

    @Override
    public List<PrefabGraph> getPrefabGraphs() {
        return graphPropertiesLoader.getGraphProperties();
    }
}
