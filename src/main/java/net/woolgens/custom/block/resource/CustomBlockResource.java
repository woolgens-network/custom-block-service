package net.woolgens.custom.block.resource;

import net.woolgens.custom.block.exception.CustomBlockException;
import net.woolgens.custom.block.exception.impl.CustomBlockNotFoundException;
import net.woolgens.custom.block.model.CustomBlock;
import net.woolgens.custom.block.repository.CustomBlockRepository;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;

@Path("/customblocks")
public class CustomBlockResource {

    @Inject
    CustomBlockRepository repository;

    @GET
    @RolesAllowed("Admin")
    public List<CustomBlock> getAll() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("Admin")
    public CustomBlock get(@PathParam("id") String id) throws CustomBlockException {
        Optional<CustomBlock> customBlockOptional = repository.findByIdOptional(id);
        if(!customBlockOptional.isPresent()) {
            throw new CustomBlockNotFoundException();
        }
        return customBlockOptional.get();
    }

    @PUT
    @RolesAllowed("Admin")
    public CustomBlock put(CustomBlock customBlock) {
        repository.persistOrUpdate(customBlock);
        return customBlock;
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Admin")
    public boolean delete(@PathParam("id") String id) {
        return repository.deleteById(id);
    }
}