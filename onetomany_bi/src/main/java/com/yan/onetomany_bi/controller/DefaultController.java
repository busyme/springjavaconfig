package com.yan.onetomany_bi.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.onetomany_bi.model.Person;
import com.yan.onetomany_bi.model.Phone;
import com.yan.onetomany_bi.service.PersonService;

@Controller
public class DefaultController {

	private static final Logger LOGGER = Logger
			.getLogger(DefaultController.class);

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	private void savePerson(@RequestBody String string) {

		LOGGER.debug("Inside Saving Person");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		try {
			jsonNode = objectMapper.readTree(string);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Person person = objectMapper.convertValue(jsonNode.get("person"),
				Person.class);

		if (jsonNode.path("phones").path("phone").isArray()) {
			for (JsonNode node : jsonNode.path("phones").path("phone")) {
				LOGGER.debug("setting phone objects now");
				person.setPhones(objectMapper.convertValue(node, Phone.class));
			}
		}

		LOGGER.debug("Saving Person Ojbect Now");
		personService.save(person);

	}

	@RequestMapping(value = "/getAllPerson", method = RequestMethod.GET)
	@ResponseBody
	private List<Person> getAllPerson() {

		return (List<Person>) personService.findAll();
	}

}
