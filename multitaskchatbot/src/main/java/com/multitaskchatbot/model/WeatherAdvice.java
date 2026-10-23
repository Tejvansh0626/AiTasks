package com.multitaskchatbot.model;


import java.util.List;

public record WeatherAdvice(String city,
                            String weatherCondition,
                            List<String> advice) {
}
