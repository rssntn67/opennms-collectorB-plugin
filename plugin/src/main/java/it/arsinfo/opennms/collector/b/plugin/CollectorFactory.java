package it.arsinfo.opennms.collector.b.plugin;


public class CollectorFactory extends AbstractCollectorFactory<Collector> {

    public CollectorFactory() {
        super();
    }

    @Override
    public Collector createCollector() {
        return new Collector();
    }

    @Override
    public String getCollectorClassName() {
        return Collector.class.getCanonicalName();
    }

}
