package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    SpeakerService speakerService;

    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable Long id)
    {
        return speakerService.getSpeakerById(id);
    }

    @GetMapping("/all")
    public List<Speaker> getAllSpeakers()
    {
        return speakerService.getAllSpeakers();
    }

    @GetMapping("/eventCount/{eventCount}/experience/{experience}")
    public List<Speaker> getAllSpeakersByEventCountAndExperience(@PathVariable Long eventCount, @PathVariable Long experience)
    {
        return speakerService.getAllSpeakersByEventCountAndExperience(eventCount,experience);
    }

    @PostMapping("/id/{speakerId}/eventId/{eventId}")
    public void addSpeakerToEvent(@PathVariable("eventId") Long eventId, @PathVariable("speakerId") Long speakerId) {
        speakerService.addSpeakerToEvent(eventId, speakerId);
    }

    @PostMapping("/save")
    public  String saveSpeaker(@RequestBody Speaker speaker)
    {
        return speakerService.saveSpeaker(speaker);
    }
}

/*
 * package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpeakerService {

	@Autowired
	private SpeakerDAL speakerDAL;

	public Speaker getSpeakerById(Long id) {
		Speaker speaker = speakerDAL.findById(id);
		if (speaker == null) {
			throw new RuntimeException("Speaker not found with id: " + id);
		}
		return speaker;
	}

	public List<Speaker> getAllSpeakers() {
		return speakerDAL.findAll();
	}

	public List<Speaker> getSpeakersByEventCountAndExperience(Long eventCount, Long experience) {
		List<Speaker> speakers = speakerDAL.findByEventCountAndExperience(eventCount, experience);
		if (speakers.isEmpty()) {
			throw new RuntimeException("No speakers found with the given filters.");
		}
		return speakers;
	}

	public void saveSpeaker(Speaker speaker) {
		speakerDAL.save(speaker);
	}

	public void associateSpeakerWithEvent(Long speakerId, Long eventId) {
		// Implement logic to associate Speaker with Event
		speakerDAL.associateSpeakerWithEvent(speakerId, eventId);
	}
}
*/
