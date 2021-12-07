package de.tekup.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.User;
import de.tekup.data.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository ur;

	@Transactional
	@Override
	public MessageResponse save(User user) {
		
		boolean exist = ur.existsByEmail(user.getEmail());

		if (exist) {return new MessageResponse(false, "Attention", "Email existe déjà!!");}

		exist = ur.existsByPrenom(user.getPrenom());

		if (exist) {
			exist = ur.existsByNom(user.getNom());
			if (exist) {return new MessageResponse(false, "Attention", "Le Nom Complet d'utilisateur existe déjà!!");}
		}
		
		ur.save(user);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse update(User user) {
		User us = findById(user.getId());
		if (us == null) {return new MessageResponse(false, "Attention", "Utilisteaur introuvable!!");}
		boolean exist = ur.existsByEmailAndId(user.getEmail(), user.getId());

		if (!exist) {
			exist = ur.existsByEmail(user.getEmail());
			if (exist) {return new MessageResponse(false, "Attention", "Email existe déjà!!");}
		}

		exist = ur.existsByNomAndId(user.getNom(), user.getId());
		if (!exist) {
			exist = ur.existsByNom(user.getNom());
			if (exist) {return new MessageResponse(false, "Attention", "Nom d'utilisateur existe déjà!!");}
		}

		ur.save(user);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		User user = findById(id);
		if (user == null) {
			return new MessageResponse(false, "Attention", "Utilisteaur introuvable!!");
		}

		ur.delete(user);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		return ur.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public User findById(Long id) {
		return ur.findById(id).orElse(null);
	}


	
//	private UserRepository userRepository;
//	private MessageRepository messageRepository;
//	private ModelMapper mapper;
//	
//	@Autowired
//	public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, MessageRepository messageRepository) {
//		super();
//		this.userRepository = userRepository;
//		this.messageRepository=messageRepository;
//		this.mapper=mapper;
//	}
//	
//	@Override
//	public UserResponse save(UserRequest request) {
//		// Mappage entre UserRequest -> User
//				User entity = mapper.map(request, User.class);
//		//saving User
//		User newUser = userRepository.save(entity);
//		//saving msgs
//		if(entity.getMsgs()!=null) {
//			for (Message msg : entity.getMsgs()) {
//				msg.setUser(newUser);
//				messageRepository.save(msg);
//			}}
//		return mapper.map(newUser, UserResponse.class);
//	}
//
//	@Override
//	public List<User> getAllUsers() {
//		
//		return userRepository.findAll();
//	}
//  
//	@Override
//	public UserResponse getUserById(long id) {
//		
//		User entity;
//		Optional<User> opt = userRepository.findById(id);
//		if(opt.isPresent())
//			entity = opt.get();
//		else
//			throw new NoSuchElementException("Person with this id is not found");
//		
//		
//		UserResponse user = new UserResponse(entity.getNom(), entity.getPrenom(),entity.getEmail(),entity.getRole(),entity.getEtat(), null);
//		return user;
//	}
//	
//	//update User 
//	@Override
//	public User modifyUser(long id, User newUser) {
//		// is there a better way ? 
//		UserResponse oldUser = this.getUserById(id);
//		if(newUser.getNom() != null)
//			oldUser.setNom(newUser.getNom());
//			
//		if(newUser.getPrenom() != null)
//			oldUser.setPrenom(newUser.getPrenom());
//		return newUser;
//	}
//		
//	@Override
//	public User deleteUserById(long id) {
//		userRepository.deleteById(id);
//		return null;
//	}

		}
