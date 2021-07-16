package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.ApplicationUserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The Class Usercontroller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ApplicationUserService applicationUserService;

    /**
     * Instantiates a new User controller.
     *
     * @param applicationUserRepository the application user repository
     * @param bCryptPasswordEncoder     the b crypt password encoder
     */
    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserService applicationUserService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.applicationUserService = applicationUserService;
    }



    /**
     * Gets all User.
     *
     * @return all User
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return applicationUserService.findAll();
    }


    /**
     * Gets all User.
     *
     * @return all User
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return applicationUserService.findAll();
    }


    /**
     * Create user.
     *
     * @param user the user
     * @return the entry
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return applicationUserService.createUser(user);
    }

    /**
     * Sign up.
     *
     * @param user the user
     */
    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    /**
     * Delete user by the id;
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        applicationUserService.deleteUser(id);
    }

    /**
     * Update user.
     * Change attributes of the User
     *
     * @param user the uSer
     * @return the user
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Valid @RequestBody User user) {
        return applicationUserService.updateUser(user);
    }
}
