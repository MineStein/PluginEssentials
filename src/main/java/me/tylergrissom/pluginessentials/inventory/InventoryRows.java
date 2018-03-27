package me.tylergrissom.pluginessentials.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
@AllArgsConstructor
public enum InventoryRows {

    NO_ROWS(0),
    ONE_ROW(9),
    TWO_ROWS(18),
    THREE_ROWS(27),
    FOUR_ROWS(36),
    FIVE_ROWS(45),
    SIX_ROWS(54);

    @Getter private int slotCount;

    public static InventoryRows getRowCount(int slotCount) {
        for (InventoryRows rows :
                values()) {
            if (rows.getSlotCount() == slotCount) return rows;
        }

        return null;
    }
}
