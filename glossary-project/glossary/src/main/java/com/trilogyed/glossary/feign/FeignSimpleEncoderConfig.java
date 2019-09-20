package com.trilogyed.glossary.feign;

import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;

import java.beans.Encoder;

public class FeignSimpleEncoderConfig {
    @Bean
    public FormEncoder encoder() {
        return  new FormEncoder();
    }
}