package net.woolgens.custom.block.resource;

import net.woolgens.custom.block.model.CustomBlock;
import net.woolgens.custom.block.repository.CustomBlockRepository;
import net.woolgens.library.microservice.exception.ServiceException;

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
    public CustomBlock get(@PathParam("id") String id) throws ServiceException {
        Optional<CustomBlock> customBlockOptional = repository.findByIdOptional(id);
        if(!customBlockOptional.isPresent()) {
            throw new ServiceException(404, "CustomBlock not found");
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

    @POST
    @Path("/delete")
    @RolesAllowed("Admin")
    public boolean deletePost(CustomBlock block) {
        return repository.deleteById(block.getId());
    }
}