package com.org.factory;

import com.org.domain.Entity;

public class Factory {
    public static Entity getEntity() {
        Entity entity = new Entity();
        entity.setName("林黛玉");
        entity.setSex("女");
        return entity;
    }
}
