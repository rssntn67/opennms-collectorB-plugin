package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.collectors.CollectionRequest;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.resource.NodeResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableNodeResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Collector extends AbstractServiceCollector {

    private static final Logger LOG = LoggerFactory.getLogger(Collector.class);

    public Collector() {
        super();
    }

    @Override
    public void initialize() {
    }

    @Override
    public CompletableFuture<CollectionSet> collect(CollectionRequest request, Map<String, Object> attributes) {
        LOG.debug("collect: nodeid:{} ipaddr:{}, attributes:{}", request.getNodeId(), request.getAddress(), attributes);
        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(request.getNodeId()).build();

        final ImmutableCollectionSetResource.Builder<NodeResource> computeAttrBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);
        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(computeAttrBuilder.build());
        addSampleStats(resultBuilder,nodeResource);
        return CompletableFuture.completedFuture(resultBuilder.setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis()).build());
    }
}
