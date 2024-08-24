package same.code.hopital.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import same.code.hopital.entity.UserEntity;
import same.code.hopital.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 60;
	 @Autowired
	 UserRepository repository;
		

//	 @Autowired
//	 private JavaMailSender mailSender;
	 
		public List<UserEntity> getAll() {
			System.out.println("Get all Users 11111...");
	    	return repository.findAll(Sort.by("username").ascending());	    	
	    }
		
	    public Optional<UserEntity> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(UserEntity User) {
	    	System.out.println("save  all Users 11111...");
	          return repository.save(User)
		                             .getId();	    	
	    }
	    
	    public void update(long id, UserEntity user) {
		        user.setFileName(user.getFileName());
	            repository.save(user);
	        }
	    
	
	    public Optional<UserEntity> login(String name) {
	    	System.out.println(name);
	        return repository.findByUsername(name);
	    }

	    public void delete(long id) {
	        Optional<UserEntity> user = repository.findById(id);
	        user.ifPresent(repository::delete);
	    }
	    


		
//		public Optional <UserEntity> findUserByResetToken(String resetToken) {
//			return repository.findByResetToken(resetToken);
//		}
		
		/*@Async
		public void sendEmail(SimpleMailMessage email) {
			mailSender.send(email);
		}*/
}