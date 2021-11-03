package hu.forestwolf.service;

import hu.forestwolf.domain.Country;
import hu.forestwolf.domain.Wolf;
import hu.forestwolf.exceptions.MethodNotAllowedException;
import hu.forestwolf.exceptions.WolfAlreadyExistsException;
import hu.forestwolf.exceptions.WolfIdNotFoundException;
import hu.forestwolf.exceptions.WolfNotFoundException;
import hu.forestwolf.repository.WolfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class WolfService {

    private WolfRepository repository;

    public WolfService(WolfRepository repository) {
        this.repository = repository;
    }

    /** Request method  = GET
    *   Request path    = /wolfs
    *   Response status = 200 (OK) - default
    */
    public List<Wolf> getWolfs() {
        return repository.findAllByOrderByRankAsc();
    }

    /** Request method  = GET
    *   Request path    = /wolf/{id}
    *   Response status = 200 (OK), -default
    *                     404 (NOT_FOUND) id not found or invalid
    */
    public Wolf getWolf(int id){
        Optional<Wolf> wolf = repository.findById(id);
        if(!wolf.isPresent()) {
            // throw new WolfNotFoundException("wolf not found by this id: " + id);  // ez is jó
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // ez egyszerűbb
        }
        return wolf.get();
    }

    /**  Request method  = POST
     *   Request path    = /wolfs
     *   Response status = 201 (CREATED), - in controller method
     *                     409 (CONFLICT) the resource is already exists
     */

    public Wolf addWolf(Wolf newWolf){
        if(notUnique(newWolf.getName()))
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        return repository.save(newWolf);
    }

    public Wolf addNewWolf(String name, String rank){
        if(notUnique(name)) {
            // throw new WolfAlreadyExistsException("already exitst name: "+name); // ez is jó
            throw new ResponseStatusException(HttpStatus.CONFLICT); // ez egyszerűbb
        }
        return repository.save(new Wolf(name, Integer.parseInt(rank) ));
    }

    private boolean notUnique(String name) {
        List<Wolf> wolfs = repository.findAll();
        for (Wolf wolf : wolfs) {
            if(wolf.getName().equals(name))
                return true;
        }
        return false;
    }
    /**  Request method  = POST
     *   Request path    = /wolfs/{id}
     *   Response status = 405 (METHOD_NOT_ALLOWED) - in controller method
     */


    /**  Request method  = PUT
     *   Request path    = /wolfs
     *   Response status = 405 (METHOD_NOT_ALLOWED) - in controller method
     */

    /**  Request method  = PUT
     *   Request path    = /wolfs/{id}
     *   Response status = 200 (OK), - in controller method
     *                   = 204 (NO_CONTENT), missing RequestBody
     *                   = 404 (NOT_FOUND) id not found or invalid
     */
    public Wolf replaceWolf(int id, Wolf wolf){
        if(wolf==null)
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        Optional<Wolf> optionalWolf = repository.findById(id);
        if(!optionalWolf.isPresent()) {
            // throw new WolfIdNotFoundException("Wolf doesn't extist with id: " + wolf.getId()); // ez is jó
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // ez egyszerűbb
        }
        return repository.save(wolf);
    }

    /**  Request method  = PATCH
     *   Request path    = /wolfs
     *   Response status = 405 (METHOD_NOT_ALLOWED) - in controller method
     */

    /**  Request method  = PATCH replaced PUT because of java.net.HttpURLConnection -> methods[]
     *   Request path    = /wolfs/{id}
     *   Response status = 200 (OK), - in controller method
     *                   = 404 (NOT_FOUND) id not found or invalid
     */

    public Wolf updateWolf(int id, int rank){
        Optional<Wolf> optionalWolf = repository.findById(id);
        if(!optionalWolf.isPresent()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Wolf wolf = optionalWolf.get();
        wolf.setRank(rank);
        return repository.save(wolf);
    }

    /**  Request method  = DELETE
     *   Request path    = /wolfs
     *   Response status = 405 (METHOD_NOT_ALLOWED) - in controller method
     */

    /**  Request method  = DELETE
     *   Request path    = /wolfs/{id}
     *   Response status = 200 (OK), - in controller method
     *                   = 404 (NOT_FOUND) id not found or invalid
     */

    public void deleteWolf(int id){
        Optional<Wolf> optionalWolf = repository.findById(id);
        if(!optionalWolf.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

}
