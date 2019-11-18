package com.sampler.common;

// this class creates our samples

import com.badlogic.gdx.utils.reflect.ClassReflection;

public class SampleFactory {

    public static SampleBase newSample(String name) throws IllegalAccessException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name param is required.");
        }

        // get sample info from our sample
        SampleInfo info = SampleInfos.find(name);

        try {
            return (SampleBase) ClassReflection.newInstance(info.getClazz());
        } catch (Exception e) {
            throw new RuntimeException("Cannot create sample with name " + name, e);
        }
    }

    // no need to instantiate this class
    private SampleFactory() {}
}
