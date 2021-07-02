/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.techmentoring.roomwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Room {
    private long id;
    private String name;
    private String number;
    private String info;
}
