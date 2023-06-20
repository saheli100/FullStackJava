package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		log.info("within create user method of service layer");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		userEntity.setUserId(UUID.randomUUID().toString());

		userRepository.save(userEntity);
		log.debug("done updating data");
		UserResponseModel responseModel = modelMapper.map(userEntity, UserResponseModel.class);
		return responseModel;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserResponseModel getuserById(int id) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<UserEntity> e=userRepository.findById(id);
		
		if(!e.isPresent())
		{
			return null;
		}
		else
		{
			return modelMapper.map(e, UserResponseModel.class);
		}
		
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserResponseModel findByUserId(String userId) {
		UserEntity entity=userRepository.findByUserId(userId);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(entity, UserResponseModel.class);
	}

	

	@Override
	public UserResponseModel updateUserById(int id, UserRequestModel requestModel) {
		// TODO Auto-generated method stub
		UserResponseModel responseModel = null;
		Optional<UserEntity> userEntityFromDb = userRepository.findById(id);
		if (userEntityFromDb.isPresent()) {
			UserEntity entity = userEntityFromDb.get();
			entity.setFirstName(requestModel.getFirstName());
			entity.setLastName(requestModel.getLastName());
			entity.setEmail(requestModel.getEmail());
			entity.setPassword(requestModel.getPassword());
			UserEntity user = userRepository.save(entity);
			responseModel = modelMapper.map(user, UserResponseModel.class);
		}
		return responseModel;
	}

}