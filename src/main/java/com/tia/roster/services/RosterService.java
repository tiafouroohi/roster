package com.tia.roster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia.roster.models.Contact;
import com.tia.roster.models.Dorm;
import com.tia.roster.models.Student;
import com.tia.roster.repositories.ClassRepository;
import com.tia.roster.repositories.ClassStudentRepository;
import com.tia.roster.repositories.ContactRepository;
import com.tia.roster.repositories.DormRepository;
import com.tia.roster.repositories.StudentRepository;

@Service
public class RosterService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private ContactRepository contactRepository;
	
	private DormRepository dormRepository;
	
	private ClassRepository classRepository;
	
	private ClassStudentRepository classStudentRepository;
	
    public RosterService(StudentRepository studentRepository, ContactRepository contactRepository, DormRepository dormRepository, ClassStudentRepository classStudentRepository) {
        this.studentRepository = studentRepository;
        this.contactRepository = contactRepository;
        this.dormRepository = dormRepository;
        this.classStudentRepository = classStudentRepository;
    }
    // returns all the books
    public List<Student> allStudents() {
        return (List<Student>) studentRepository.findAll();
    }
    public List<Contact>allContacts(){
    	return (List<Contact>) contactRepository.findAll();
    }
    public List<Dorm>allDorms(){
    	return (List<Dorm>) dormRepository.findAll();
    }
    // creates a book
    public Student createStudent(Student b) {
        return studentRepository.save(b);
    }
    public Student save(Student b) {
    	return studentRepository.save(b);
    }
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
    
    public Contact createContact(Contact c) {
    	return contactRepository.save(c);
    }
    public Contact save(Contact c) {
    	return contactRepository.save(c);
    }
    
    public Contact findContact(Long id) {
    	Optional<Contact> optionalContact = contactRepository.findById(id);
    	if(optionalContact.isPresent()) {
    		return optionalContact.get();
    	} else {
    		return null;
    	}
    }
    public Dorm createDorm(Dorm b) {
        return dormRepository.save(b);
    }
    public Dorm saveDorm(Dorm b) {
        return dormRepository.save(b);
    }
    public Dorm findDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        } else {
            return null;
        }
    }
    
    public Class createClass(Class b) {
        return classRepository.save(b);
    }
    public Class save(Class b) {
        return classRepository.save(b);
    }

	
		
	
	

}
