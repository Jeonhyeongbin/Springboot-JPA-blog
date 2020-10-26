package com.blog.blogtest.controller.api;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogtest.config.auth.PrincipalDetail;
import com.blog.blogtest.dto.ResponseDto;
import com.blog.blogtest.model.RoleType;
import com.blog.blogtest.model.User;
import com.blog.blogtest.service.UserService;

@RestController
public class UserApiController {
	@Autowired
	private UserService userService; //di
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){
		userService.회원수정(user);
		//트랜잭션 종료 db값은 변경 
		//세션
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		
	}
	/*@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user)
	{
		System.out.println("save!");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}*/
	
	/*@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user,HttpSession session){
		System.out.println("userapi login");
		User principal = userService.로그인(user); //principal 접근주체.
		if(principal!= null)
		{
			session.setAttribute("principal", principal);
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	} */
	
	
	
	
}
