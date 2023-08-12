package com.vf.dev.msuniversidadaulas.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        var model= new ModelMapper();
        model.getConfiguration().setAmbiguityIgnored(true);
        return (ModelMapper) model;
    }
}
