package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.ServiceCollectorFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


abstract public class AbstractCollectorFactory<T extends AbstractServiceCollector> implements ServiceCollectorFactory<T> {

    public AbstractCollectorFactory() {
    }

    @Override
    public Map<String, Object> getRuntimeAttributes(CollectionRequest collectionRequest, Map<String, Object> parameters) {
        return new HashMap<>(parameters);
    }

    @Override
    public Map<String, String> marshalParameters(Map<String, Object> parameters) {
        return parameters.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()));
    }

    @Override
    public Map<String, Object> unmarshalParameters(Map<String, String> parameters) {
        return parameters.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
