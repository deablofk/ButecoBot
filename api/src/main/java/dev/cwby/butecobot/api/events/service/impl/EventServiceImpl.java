package dev.cwby.butecobot.api.events.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.events.domain.Event;
import dev.cwby.butecobot.api.events.repository.EventRepository;
import dev.cwby.butecobot.api.events.service.IEventService;
import lombok.AllArgsConstructor;

/**
 * EventServiceImpl
 */
@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService {

    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setName(event.getName());
        existingEvent.setStatus(event.getStatus());
        existingEvent.setWinnerChoiceId(event.getWinnerChoiceId());
        existingEvent.setUpdatedAt(LocalDateTime.now());
        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }
}
