package com.application.firststep.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Lob
	@Column(name = "photo",columnDefinition = "longblob")
	private byte[] photo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", photo=" + Arrays.toString(photo) + ", user=" + user + "]";
	}


}
