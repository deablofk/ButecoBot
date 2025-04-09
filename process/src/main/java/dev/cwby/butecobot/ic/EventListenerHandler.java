package dev.cwby.butecobot.ic;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.hooks.EventListener;

/**
 * EventListenerHandler
 */
public class EventListenerHandler {

	private static List<EventListener> eventListeners = new ArrayList<>();

	static {
		try {
			Class.forName("dev.cwby.butecobot.ic.initializer.AOTInitializer");
		} catch (ClassNotFoundException e) {
			System.out.println("[ANNOTATION_PROCESSOR] Cant initialize the class AOTInitializer: " + e.getMessage());
		}
	}

	private EventListenerHandler() {
	}

	public static void registerEventListener(EventListener listener) {
		eventListeners.add(listener);
	}

	public static List<EventListener> getEventListeners() {
		return eventListeners;
	}
}
