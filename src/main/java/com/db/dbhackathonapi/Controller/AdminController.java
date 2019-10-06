package com.db.dbhackathonapi.Controller;


import com.db.dbhackathonapi.Repository.AdminRepository;
import com.db.dbhackathonapi.Tables.Admin;
import com.db.dbhackathonapi.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.db.dbhackathonapi.StatusCodeEnum.*;


/*
either you can use
 */

@RestController    // This means that this class is a Controller
@RequestMapping(path="/admin") // This means URL's start with /demo (after Application path)
public class AdminController {

	@Autowired // This means to get the bean called AdminRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private AdminRepository adminRepository;

	 @CrossOrigin //Todo:
 	@PostMapping("/login")
	public Response login(@RequestBody Admin admin){

		Optional<Admin>u=adminRepository.findById(admin.getEmail());

		if(u.isPresent()){
			if(u.get().getPassword().equals(admin.getPassword()))
		        return new Response(OK.getCode(),"Logged In.","You have successfully Signed In",u);
			else
				return new Response(WARNING.getCode(),"Wrong Password","Please re-enter password",null);
		}
		else
			return new Response(ERROR.getCode(),"Admin Not Found","Please enter again",null);
	}
}