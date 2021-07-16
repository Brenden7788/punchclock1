package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * The type Application user service.
 */
@Service
public class ApplicationUserService implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    /**
     * Instantiates a new Application user service.
     *
     * @param applicationUserRepository the application user repository
     */
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = applicationUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), emptyList());
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<User> findAll() {
        return applicationUserRepository.findAll();
    }

    /**
     * Create  user.
     *
     * @param user the user
     * @return the user
     */
    public User createUser(User user) {
        return applicationUserRepository.saveAndFlush(user);
    }

    /**
     * Delete user.
     *
     * @param id the id
     */
    public void deleteUser(long id) { applicationUserRepository.deleteById(id); }

    /**
     * Update  user.
     * Changes User
     *
     * @param user the user
     * @return the user
     */
    public User updateUser(User user) {
        return applicationUserRepository.save(user);
    }

}