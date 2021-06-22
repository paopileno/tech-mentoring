/*
 * Copyright (c) 2021 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.frankmoley.lil.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frankmoley.lil.learningspring.business.service.GuestService;
import com.frankmoley.lil.learningspring.data.entity.Guest;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private final GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuest(Model model) {
        List<Guest> guests = this.guestService.getGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
