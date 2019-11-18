package com.sampler.common;

// Contains all our sample infos and some info methods



import com.badlogic.gdx.ApplicationListener;
import com.sampler.ApplicationListenerSample;
import com.sampler.GdxGeneratedSample;
import com.sampler.GdxModuleInfoSample;
import com.sampler.GdxReflectionSample;
import com.sampler.InputListeningSample;
import com.sampler.InputPollingSample;
import com.sampler.OrthographicCameraSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SampleInfos {

    // List of all our samples
    public static final List<SampleInfo> ALL = Arrays.asList(
            ApplicationListenerSample.SAMPLE_INFO,
            GdxGeneratedSample.SAMPLE_INFO,
            GdxModuleInfoSample.SAMPLE_INFO,
            GdxReflectionSample.SAMPLE_INFO,
            InputListeningSample.SAMPLE_INFO,
            InputPollingSample.SAMPLE_INFO,
            OrthographicCameraSample.SAMPLE_INFO

    );

    // Get the names of our samples
    public static List<String> getSampleNames() {
        // list that gets returned
        List<String> ret = new ArrayList<>();

        for(SampleInfo info : ALL) {
            ret.add(info.getName());
        }

        Collections.sort(ret);
        return ret;

    }

    // this method finds our sample in a list
    public static SampleInfo find(String name) throws IllegalAccessException {
        if (name == null || name.isEmpty()) {
            throw new IllegalAccessException("name arguement is required.");
        }

        SampleInfo ret = null;

        // for all our our samples
        for (SampleInfo info : ALL) {
            // :::IMPORTANT:::
            // equals equals operator compares references, these strings are
            // not the same references because we created a new String.
            // So we use .equals() method instead, which compares String equality.
            if (info.getName().equals(name) ) {
                ret = info;
                // found
                break;
            }
        }

        if (ret == null ) {
            throw new IllegalAccessException("Could not find sample with name = " + name);
        }

        return ret;
    }

    private SampleInfos() {};

}
