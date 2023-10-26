package com.ty.hrms.constants;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.common.collect.Lists;
import com.ty.hrms.entity.Admin;
import com.ty.hrms.entity.AppUser;
import com.ty.hrms.entity.HrManager;
import com.ty.hrms.entity.Roles;
import com.ty.hrms.repository.AdminRepository;
import com.ty.hrms.repository.HrManagerRepository;
import com.ty.hrms.repository.RolesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class AppData implements CommandLineRunner {

	private final PasswordEncoder passwordEncoder;
	private final RolesRepository roleRepository;
	private final HrManagerRepository hrManagerRepository;
	private final AdminRepository adminRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Roles hrManager = Roles.builder().roleName("ROLE_HRMANAGER").appUsers(Lists.newArrayList()).build();
		Roles admin = Roles.builder().roleName("ROLE_ADMIN").appUsers(Lists.newArrayList()).build();
		Roles employee = Roles.builder().roleName("ROLE_EMPLOYEE").appUsers(Lists.newArrayList()).build();

		ArrayList<Roles> roles01 = Lists.newArrayList();
					  roles01.add(hrManager);
					  
		ArrayList<Roles> roles02 = Lists.newArrayList();
					  roles02.add(admin);

		HrManager hrManager_ = HrManager.builder()
								.hrManagerName("HRMANAGER01")
								.build();
		
		Admin admin_ = Admin.builder()
				.adminName("ADMIN01")
				.build();
		
		AppUser appUser01 = AppUser.builder()
							.username("hrmanager01@gmail.com")
							.password(passwordEncoder.encode("qwert"))
							.roles(roles01)
							.build();
		AppUser appUser02 = AppUser.builder()
				.username("admin01@gmail.com")
				.password(passwordEncoder.encode("qwert"))
				.roles(roles02)
				.build();
		
		
		hrManager.getAppUsers().add(appUser01);
		admin.getAppUsers().add(appUser02);
		
		roleRepository.save(hrManager);
		roleRepository.save(admin);
		roleRepository.save(employee);
		
		hrManagerRepository.save(hrManager_);
		adminRepository.save(admin_);
	}
}
