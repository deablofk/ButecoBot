package dev.cwby.butecobot.cooldown;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * CooldownManager
 */
public class CooldownManager {

	private CooldownManager() {
	}

	private static final Cache<String, CooldownEntry> cache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.HOURS)
			.maximumSize(1000).build();

	public static synchronized boolean isAllowed(String discordId, int seconds, int threshold) {
		CooldownEntry entry = cache.getIfPresent(discordId);
		Instant now = Instant.now();
		Instant expiresAt = now.plusSeconds(seconds);

		if (entry == null || entry.expiresAt().isBefore(now)) {
			cache.put(discordId, new CooldownEntry(1, expiresAt));
			return true;
		}

		if (entry.count() < threshold) {
			cache.put(discordId, new CooldownEntry(entry.count() + 1, entry.expiresAt()));
			return true;
		}

		return false;
	}

	public static synchronized boolean isOnCooldown(String discordId) {
		return !isAllowed(discordId, 60, 5);
	}

}
