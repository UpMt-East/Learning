package com.learning.higashino.services;

import com.learning.higashino.components.Sample;
import com.learning.higashino.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HigashinoApplicationService {

    @Autowired
    private SampleRepository sampleRepository;

    public String getHelloMsg() {
        Sample sample = sampleRepository.getOne(1);
        return sample.getMessage();
    }
}
