package com.multitaskchatbot.model;

import java.util.List;

public record TravelPlan(
        String destination,
        int days,
        String estimatedBudget,
        List<String> activities,
        List<String> tips
) {
}
