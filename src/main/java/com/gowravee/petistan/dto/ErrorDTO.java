package com.gowravee.petistan.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDTO(String message, HttpStatus error, Integer status, LocalDateTime timeStamp) {
}
