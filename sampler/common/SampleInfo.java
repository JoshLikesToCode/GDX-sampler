package com.sampler.common;

// hybrid class that holds info about our sample
//          aka Sample Definition

public class SampleInfo {

    // name of our sample
    private final String name;
    private final Class<? extends SampleBase> clazz;

    public SampleInfo(Class<? extends SampleBase> clazz) {
        this.clazz = clazz;
        // class name. Use simpleName() so we dont display the full
        // class name full of mumbojumbo
        name = clazz.getSimpleName();
    }

    public String getName() {
        return name;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
