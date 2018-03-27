package me.tylergrissom.pluginessentials.title;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
@AllArgsConstructor
@Builder
public class TitleData {

    @Getter @Setter
    private String title, subtitle;

    @Getter @Setter
    private int fadeIn = 20, stay = 80, fadeOut = 20;
}
