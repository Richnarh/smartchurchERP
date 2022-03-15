package com.khoders.smartchurch.entities;
import com.khoders.resource.enums.Title;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "membership")
public class Membership extends UserAccountRecord
{
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "lastname")
	private String lastname;

	@Column(name = "fullname")
	private String fullname = firstname +" "+surname +" "+lastname;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "address_location")
	private String addressLocation;

	@Column(name = "title")
	@Enumerated(EnumType.STRING)
	private Title title;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "occupation")
	private String occupation;

	@JoinColumn(name = "position", referencedColumnName = "id")
	@ManyToOne
	private Position position;

	@Column(name = "emergency_number")
	private String emergencyNumber;

//    @Column(name = "profile_photo")
//	private byte[] profileImage;

	@Lob
	@Column(name = "description")
	private String description;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddressLocation() {
		return addressLocation;
	}

	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
