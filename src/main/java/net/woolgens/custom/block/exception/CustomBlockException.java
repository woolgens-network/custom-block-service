package net.woolgens.custom.block.exception;

import lombok.Getter;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Getter
public class CustomBlockException extends Exception {

    private int status;

    public CustomBlockException(int status, String message) {
        super(message);
        this.status = status;
    }
}
