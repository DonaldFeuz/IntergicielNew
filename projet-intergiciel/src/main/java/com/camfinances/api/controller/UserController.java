package com.camfinances.api.controller;

import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.camfinances.api.model.User;
import com.camfinances.api.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create - Add a new user
     * 
     * @param user An object user
     * @return The user object saved
     */
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) 
    public User createUser(@ModelAttribute User user) {
        return userService.saveUser(user);
    }

    /**
     * Read - Get one user
     * 
     * @param id The id of the user
     * @return An user object full filled
     */
    @GetMapping("/user/{id}")
    public User getuser(@PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @PostMapping(value ="/user/exist", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getuser(@RequestParam ("email") String email, @RequestParam ("mdp") String mdp) {
        Optional<User> user = userService.getUser(email, mdp);
        if (user.isPresent()) {
            return (user.get()).getNom();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all users
     * 
     * @return - An Iterable object of user full filled
     */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }


    /**
	 * Update - Update an existing user
	 * @param id - The id of the user to update
	 * @param user - The user object updated
	 * @return
	 */
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") final Long id, @RequestBody User user) {
		Optional<User> u = userService.getUser(id);
		if(u.isPresent()) {
			User currentUser = u.get();
			
			String nom = user.getNom();
			if(nom != null) {
				currentUser.setNom(nom);
			}
			String prenom = user.getPrenom();
			if(prenom != null) {
				currentUser.setPrenom(prenom);
			}
			String email = user.getEmail();
			if(email != null) {
				currentUser.setEmail(email);
			}
			String mdp = user.getMdp();
			if(mdp != null) {
				currentUser.setMdp(mdp);
			}
            String role = user.getRole();
			if(role != null) {
				currentUser.setRole(role);
			}
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}

    @DeleteMapping("/user")
	public void deleteUser(@RequestParam("id") Long id) {
		userService.deleteUser(id);
	}

}
