package net.woolgens.custom.block.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Map;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@MongoEntity(collection = "custom_blocks")
@Data
public class CustomBlock {

    @BsonId
    private String id;
    private String type;
    private Map<String, Object> properties;
}
