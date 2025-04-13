package dev.cwby.butecobot.cooldown;

import java.time.Instant;

/**
 * CooldownEntry
 */
public record CooldownEntry(int count, Instant expiresAt) {
}
