package com.keo.restfulframework.controller;

import com.keo.restfulframework.model.User;
import com.keo.restfulframework.model.UserAccount;
import com.keo.restfulframework.model.request.UserRequest;
import com.keo.restfulframework.service.UserService;
import com.keo.restfulframework.utils.Response;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }
//Get ALL User
    @GetMapping("/allusers")
    public Response<List<User>> getAllUser(){
        try{
            List<User> response = userService.getAllUser();
            return Response.<List<User>>ok().setPayload(response).setMessage("Successfully retrieved all user!");

        }catch (Exception ex){
            return Response.<List<User>>exception().setMessage("Failed to retrieved the user ! Exception occured !");
        }
//        return userService.getAllUser();
    }

//Find By ID
    @GetMapping("/{id}")
    public Response<User> findByID(@PathVariable int id){
        try {
            User response = userService.findByID(id);
            if(response !=null){
                return  Response.<User>ok().setPayload(response).setSuccess(true).setMessage("Successfully retrieved user with id =  "+id);
            }
            return Response.<User>notFound().setMessage("User with ID = "+id+" doesn't exist").setSuccess(false);
        }catch (Exception ex){
            return Response.<User>exception().setMessage("Fail to retrieved user with id ="+id);
        }
//        return userService.findByID(id);
    }
//Create New User
    @PostMapping("/new-user")
    public Response<User> createUser(@Valid @RequestBody UserRequest request){
//        try{
//            int affectRow = userService.createNewUser(user);
//            System.out.println("Row :" +affectRow);
//            if(affectRow>0) {
//                return "Can create a new user !";
//            }
//            else
//                return "Cannot create a new user !";
//        }catch (Exception ex){
//            return ex.getMessage();
//        }
        try{
            int userID = userService.createNewUser(request);
            if(userID > 0){
                User response = new User().setName(request.getName())
                        .setAddress(request.getAddress())
                        .setGender(request.getGender())
                        .setUserID(userID);
                return Response.<User>createSuccess().setPayload(response).setMessage("Create User Successfully");
            }else{
                return Response.<User>badRequest().setMessage("Bad Request ! Failed to create User").setSuccess(false);
            }
        }catch (Exception ex){
            return Response.<User>exception().setMessage("Exception occeur! Failed to retrieved all User! ").setSuccess(false);
        }

    }

    @PostMapping ("/{id}")
    public Response<User> updateUserByID (@PathVariable int id , @RequestBody UserRequest request){
        try{
            int affectRow = userService.updateUser(request, id);
            if(affectRow > 0){
                User response = new User()
                        .setUserID(id)
                        .setName(request.getName())
                        .setAddress(request.getAddress())
                        .setGender(request.getGender());
                return Response.<User>updateSuccess().setMessage("Successfully update the user ").setPayload(response).setSuccess(true);
            }else {
                return Response.<User>notFound().setMessage("Cannot update , user with id = " +id+ "doesn't exits ! ").setSuccess(false);
            }
        }catch (Exception ex ){
            return Response.<User>exception().setMessage("Failed to update user , Exception Occurred!");
        }
    }

    @DeleteMapping("/{id}")
    public Response<?> deleteUser (@PathVariable int id){
        try{
            int affectRow = userService.removeUser(id);
            if(affectRow >0){
                //deletede success
                return Response.<Objects>deleteSuccess().setMessage("Successfullly remove the user !").setSuccess(true);
            }else{
                return Response.<Objects>notFound().setMessage("USer with id = "+id+" doesn't in our system");
            }

        }catch (Exception ex){
            return Response.<Objects>exception().setMessage("Exception occured @ ! Faied todeltethe user").setSuccess(false);
        }
    }


    @GetMapping("user-account")
    public Response<List<UserAccount>> getAllUserAccount(){
        try{
            List<UserAccount> data = userService.getAllUserAccount();
            return Response.<List<UserAccount>>ok().setPayload(data).setMessage("Successfully retrieved all user access");
        }catch(Exception ex){
            return Response.<List<UserAccount>>exception().setMessage("Exception Occurred! Failed to retrieved all user account! ").setSuccess(false);

        }
    }
}
