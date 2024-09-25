package it.arsinfo.opennms.collector.b.plugin;


public class BCollectorFactory extends AbstractCollectorFactory<BCollector> {

    public BCollectorFactory() {
        super();
    }

    @Override
    public BCollector createCollector() {
        return new BCollector();
    }

    @Override
    public String getCollectorClassName() {
        return BCollector.class.getCanonicalName();
    }

}
