package net.woolgens.custom.block.exception.impl;

import net.woolgens.custom.block.exception.CustomBlockException;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
public class CustomBlockNotFoundException extends CustomBlockException {

    public CustomBlockNotFoundException() {
        super(404, "Custom block not found");
    }
}
