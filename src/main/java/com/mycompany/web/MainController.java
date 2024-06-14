package com.mycompany.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.domain.Appointment;
import com.mycompany.domain.Client;
import com.mycompany.domain.Department;
import com.mycompany.domain.Doctor;
import com.mycompany.domain.Specialization;
import com.mycompany.service.iService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/** 
 * Controller class handling web requests related to CRUD operations on every entity in the application.
 */

@Controller
@Slf4j
public class MainController {
	
	/** 
	 * Service instances:
	 */
	
	@Autowired
	private iService<Client> clientService;
	
	@Autowired
	private iService<Doctor> doctorService;
	
	@Autowired
	private iService<Appointment> appointmentService;
	
	@Autowired
	private iService<Department> departmentService;
	
	@Autowired
	private iService<Specialization> specializationService;
	
	/**
	 * Logs the currently logged-in user and returns the index page.
	 * @param user The currently logged-in user.
	 * @return The index page. 
	 */
	
	/*
	@GetMapping("/")
	public String index(Model model, @AuthenticationPrincipal User user) {
		
		log.info("login: " + user);
		return "index";
		
	}
	*/
	
	@GetMapping("/index")
    public String indexRedirect(Model model, @AuthenticationPrincipal User user) {
		
        log.info("login: " + user);
        return "index";
        
    }
	
	/** 
	 * The following methods redirects the user from index page to the main page of the selected entity,
	 * depending on the link clicked.
	 * @return The entity main page; here, the user can see the database list, insert, update and delete entities.
	 */
	
	@GetMapping("/clientsListRedirect")
	public String clientsListRedirect(Model model) {
		
		var clients = clientService.listEntity();
		model.addAttribute("clients", clients);
		model.addAttribute("totalClients", clients.size());
		
		return "clients/clientsList";
		
	}
	
	@GetMapping("/departmentsListRedirect")
	public String departmentsListRedirect(Model model) {
		
		var departments = departmentService.listEntity();
		model.addAttribute("departments", departments);
		model.addAttribute("totalDepartments", departments.size());
		
		return "departments/departmentsList";
		
	}
	
	@GetMapping("/specializationsListRedirect")
	public String specializationsListRedirect(Model model) {
		
		var specializations = specializationService.listEntity();
		model.addAttribute("specializations", specializations);
		model.addAttribute("totalSpecializations", specializations.size());
		
		return "departments/specializations/specializationsList";
		
	}
	
	@GetMapping("/doctorsListRedirect")
	public String doctorsListRedirect(Model model) {
		
		var doctors = doctorService.listEntity();
		model.addAttribute("doctors", doctors);
		model.addAttribute("totalDoctors", doctors.size());
		
		return "doctors/doctorsList";
		
	}
	
	@GetMapping("/appointmentsListRedirect")
	public String appointmentsListRedirect(Model model) {
		
		var appointments = appointmentService.listEntity();
		model.addAttribute("appointments", appointments);
		model.addAttribute("totalAppointments", appointments.size());
		
		return "appointments/appointmentsList";
		
	}
	
	/** 
	 * The following methods redirect the user to the update page of the specified entity.
	 * This pages are used to insert new entities and to update existing ones.
	 * @return The update page of the selected entity.
	 */
	
	@GetMapping("/insertClient")
	public String insertClient(Client client, Model model) {
		
		addInsurancesToModel(model);
		return "clients/updateClient";
		
	}
	
	@GetMapping("/insertDepartment")
	public String insertDepartment(Department department, Model model) {
		
		addSpecializationsToModel(model);
		return "departments/updateDepartment";
		
	}
	
	@GetMapping("/insertSpecialization")
	public String insertSpecialization(Specialization specialization, Model model) {
		return "departments/specializations/updateSpecialization";
	}
	
	@GetMapping("/insertDoctor")
	public String insertDoctor(Doctor doctor, Model model) {
		
		addDepartmentsToModel(model);
		return "doctors/updateDoctor";
		
	}
	
	@GetMapping("/insertAppointment")
	public String insertAppointment(Appointment appointment, Model model) {
		
		addClientsToModel(model);
		addDoctorsToModel(model);
		return "appointments/updateAppointment";
		
	}
	
	/** 
	 * The following methods save new entities to the database, with the information provided by the user.
	 * If there are any validation errors, the methods redirects to the update entity page again with error messages.
	 * @return root URL ("/") if the transaction was successful, or returns to the update entity page if errors occur.
	 */
	
	@PostMapping("/saveClient")
	public String saveClient(@Valid Client client, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			addInsurancesToModel(model);
			return "clients/updateClient";
		}
		
		clientService.saveEntity(client);
		return "redirect:/";
		
	}
	
	@PostMapping("/saveDepartment")
	public String saveDepartment(@Valid Department department, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			addSpecializationsToModel(model);
			return "departments/updateDepartment";
		}
		
		departmentService.saveEntity(department);
		return "redirect:/";
		
	}
	
	@PostMapping("/saveSpecialization")
	public String saveSpecialization(@Valid Specialization specialization, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			return "departments/specializations/updateSpecialization";
		}
		
		specializationService.saveEntity(specialization);
		return "redirect:/";
		
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@Valid Doctor doctor, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			addDepartmentsToModel(model);
			return "doctors/updateDoctor";
		}
		
		doctorService.saveEntity(doctor);
		return "redirect:/";
		
	}
	
	@PostMapping("/saveAppointment")
	public String saveAppointment(@Valid Appointment appointment, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			addClientsToModel(model);
			addDoctorsToModel(model);
			return "appointments/updateAppointment";
		}
		
		appointmentService.saveEntity(appointment);
		return "redirect:/";
		
	}
	
	/** 
	 * Following methods uses the same page form used for inserting new entities.
	 * If there is an existing onject in the database with the specified ID, Spring injects that object to the entity declared as paramater.
	 * @return update entity page with the entity object as attribute.
	 */
	
	@GetMapping("/editClient/{clientId}")
	public String editClient(Client client, Model model) {
		
		client = clientService.findEntity(client);
		model.addAttribute("client", client);
		addInsurancesToModel(model);
		
		return "clients/updateClient";
		
	}
	
	@GetMapping("/editDepartment/{departmentId}")
	public String editDepartment(Department department, Model model) {
		
		department = departmentService.findEntity(department);
		model.addAttribute("department", department);
		addInsurancesToModel(model);
		
		return "departments/updateDepartment";
		
	}
	
	@GetMapping("/editSpecialization/{specializationId}")
	public String editClient(Specialization specialization, Model model) {
		
		specialization = specializationService.findEntity(specialization);
		model.addAttribute("specialization", specialization);
		
		return "departments/specializations/updateSpecialization";
		
	}
	
	@GetMapping("/editDoctor/{doctorId}")
	public String editDoctor(Doctor doctor, Model model) {
		
		doctor = doctorService.findEntity(doctor);
		model.addAttribute("doctor", doctor);
		addDepartmentsToModel(model);
		
		return "doctors/updateDoctor";
		
	}
	
	@GetMapping("/editAppointment/{appointmentId}")
	public String editAppointment(Appointment appointment, Model model) {
		
		appointment = appointmentService.findEntity(appointment);
		addClientsToModel(model);
		addDoctorsToModel(model);
		model.addAttribute("appointment", appointment);
		
		return "appointments/updateAppointment";
		
	}
	
	/** 
	 * The following methods delete entities from the database.
	 * @return root URL ("/") if transaction was successful, or returns an error page if entity is still binded to another existing entity
	 * (for example, the user cannot delete a client if there is one or more appointments registered to it).
	 */
	
	@GetMapping("/deleteClient")
	public String deleteClient(Client client, Model model) {
		
		try {
			clientService.deleteEntity(client);
			return "redirect:/";
			
		} catch(DataIntegrityViolationException ex) {
			return "errors/existentAppointmentError";
		}
		
	}
	
	@GetMapping("/deleteDepartment")
	public String deleteDepartment(Department department, Model model) {
		
			try {
				departmentService.deleteEntity(department);
				return "redirect:/";
				
			} catch(DataIntegrityViolationException ex) {
				return "errors/existentDoctorError";
			}
		
	}
	
	@GetMapping("/deleteSpecialization")
	public String deleteSpecialization(Specialization specialization, Model model) {
		
		try {
			specializationService.deleteEntity(specialization);
			return "redirect:/";
			
		} catch(DataIntegrityViolationException ex) {
			return "errors/existentDepartmentError";
		}
		
	}
	
	@GetMapping("/deleteDoctor")
	public String deleteDoctor(Doctor doctor, Model model) {
		
			try {
				doctorService.deleteEntity(doctor);
				return "redirect:/";
				
			} catch(DataIntegrityViolationException ex) {
				return "errors/existentAppointmentError";
			}
		
	}
	
	@GetMapping("/deleteAppointment")
	public String deleteAppointment(Appointment appointment, Model model) {
		
		appointmentService.deleteEntity(appointment);
		return "redirect:/";
		
	}
	
	/** 
	 * Util methods for the controller class; most of them load database elements for the management
	 * of other entities.
	 */
	
	private void addInsurancesToModel(Model mod) {
		
		String[] insurances = {"Basic", "Standard", "Premium", "Gold"};
		mod.addAttribute("insurances", insurances);
		
	}
	
	private void addSpecializationsToModel(Model mod) {
		
		var specializations = specializationService.listEntity();
		mod.addAttribute("specializations", specializations);
		
	}
	
	private void addDepartmentsToModel(Model mod) {
		
		var departments = departmentService.listEntity();
		mod.addAttribute("departments", departments);
		
	}
	
	private void addClientsToModel(Model mod) {
		
		var clients = clientService.listEntity();
		mod.addAttribute("clients", clients);
		
	}

	private void addDoctorsToModel(Model mod) {
	
		var doctors = doctorService.listEntity();
		mod.addAttribute("doctors", doctors);
	
	}

}
