package br.com.torugo.resource;

import br.com.torugo.domain.Person;
import br.com.torugo.domain.User;
import br.com.torugo.service.UserService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class UserResource {
    @Inject
    private UserService service;

    @Query
    @Name("listAllUsers")
    @Description("Retorna a lista com todos os usuarios")
    public List<User> listAllUsers(){
        return this.service.listAllUsers();
    }

    @Mutation
    @Description("Salva no banco de dados uma entidade do tipo Usuario e outra do tipo Pessoa que se refere ao usuário")
    public User addUser(User user, Person person){
        return this.service.addUser(user, person);
    }

}
