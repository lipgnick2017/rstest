/*
 * Class: RestApplication
 * Description:
 * Version: 1.0
 * Author: nick
 * Creation date: Jan 5, 2018
 * (C) Copyright 2018 IBM Corporation. All rights reserved.
 */
package com.lipg.test.javaee;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.lipg.test.javaee.resource.GameResource;

@ApplicationPath("restapi")
public class MyApplication extends Application {

    public MyApplication() {

    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(ApiDocDataResource.class);
        resources.add(GameResource.class);

        return resources;
    }

   

}
