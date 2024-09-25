package it.arsinfo.opennms.collector.b.plugin;

import org.opennms.integration.api.v1.collectors.immutables.ImmutableNumericAttribute;
import org.opennms.integration.api.v1.collectors.immutables.ImmutableStringAttribute;
import org.opennms.integration.api.v1.collectors.resource.GenericTypeResource;
import org.opennms.integration.api.v1.collectors.resource.NumericAttribute;
import org.opennms.integration.api.v1.collectors.resource.Resource;
import org.opennms.integration.api.v1.collectors.resource.StringAttribute;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableGenericTypeResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableNodeResource;

public abstract class AbstractServiceCollector implements ServiceCollector {

    public static final String SERVICE_INTERVAL = "SERVICE_INTERVAL";


    public AbstractServiceCollector() {
    }

    public static void addNumAttr(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                                  String name, Number value) {
        if(value != null) {
            builder.addNumericAttribute(createNumAttr(groupId, name, value.doubleValue()));
        }

    }

    public static void addNumAttr(ImmutableCollectionSetResource.Builder<? extends Resource> builder, String groupId,
                            String name, Number value, long milliseconds) {
        if(value != null) {
            builder.addNumericAttribute(createNumAttr(groupId, name, value.doubleValue() * 1000 / milliseconds));
        }
    }

    public static StringAttribute createStringAttribute(String groupId, String name, String value) {
        return ImmutableStringAttribute.newBuilder().setGroup(groupId).setName(name).setValue(value).build();
    }

    public static NumericAttribute createNumAttr(String groupId, String name, double value) {
        return ImmutableNumericAttribute.newBuilder().setGroup(groupId).setName(name).setValue(value)
                .setType(NumericAttribute.Type.GAUGE).build();
    }

    public static ImmutableCollectionSetResource.Builder<GenericTypeResource> getBuilderForResource(int i, ImmutableNodeResource nodeResource, String group) {
        return
                ImmutableCollectionSetResource.newBuilder(GenericTypeResource.class).setResource(
                                ImmutableGenericTypeResource.newBuilder().setNodeResource(nodeResource)
                                        .setType("B")
                                        .setInstance("instance"+i)
                                        .build())
                        .addStringAttribute(createStringAttribute(group, "resourceName", "instance-name-"+i));
    }

    public static void addSampleStats(ImmutableCollectionSet.Builder builder, ImmutableNodeResource nodeResource) {
        final String group ="collectorBStats";
        for (int i=10;i <15; i++) {
            final ImmutableCollectionSetResource.Builder<GenericTypeResource> appResourceBuilder =
                    getBuilderForResource(i, nodeResource, group);

            addNumAttr(appResourceBuilder, group, "Value", i);

            builder.addCollectionSetResource(appResourceBuilder.build());

        }
    }

}
