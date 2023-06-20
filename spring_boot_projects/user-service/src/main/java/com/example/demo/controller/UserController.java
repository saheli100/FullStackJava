package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

	private final ModelMapper modelMapper;
	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel requestModel) {
		log.info("within createUser endpoint of User Controller...");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(requestModel, UserDto.class);

		StringBuffer sb = new StringBuffer();
		sb.append(requestModel.getPassword());
		userDto.setEncrytedPassword(sb.reverse().toString());

		UserResponseModel responseModel = userService.createUser(userDto);
		log.debug("called service layer..");
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);

	}

	@GetMapping

	public ResponseEntity<List<UserResponseModel>> getusers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> models = new ArrayList<UserResponseModel>();

		List<UserEntity> list = userService.getAllUsers();

		for (UserEntity entity : list) {
			models.add(modelMapper.map(entity, UserResponseModel.class));
		}

		return ResponseEntity.ok(models);

	}

	@GetMapping("/{id}")

	public ResponseEntity<UserResponseModel> getuserById(@PathVariable int id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserResponseModel responseModel = userService.getuserById(id);

		return ResponseEntity.ok(responseModel);

	}
	@DeleteMapping("/{id}")

	public String deleteuserById(@PathVariable int id) {
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		userService.deleteUserById(id);

		return "user with id"+id+"is deleted";

	}
	@DeleteMapping

	public String deleteusers() {
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		userService.deleteAllUsers();

		return "All users are deleted";

	}
	@PutMapping("/{id}")

	public ResponseEntity<UserResponseModel> updateuserById(@PathVariable int id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserResponseModel responseModel = userService.updateUserById(id);

		return ResponseEntity.ok(responseModel);

	}

}
