/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.frankmoley.lil.fid.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configurable
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.frankmoley.lil.fid")
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
