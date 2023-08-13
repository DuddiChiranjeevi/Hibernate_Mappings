package com.otma.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="scheme")
@Data
public class Scheme implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scheme_id")
	private int schemeId;
	@Column(name = "scheme_nm")
	private String schemeName;
	 @Column(name="introduced_dt")
	private LocalDate introducedDate;
	@Column(name = "eligible_amount")
	private double eligibleAmount;
	private String status;
	@OneToMany
	@JoinColumn(name = "scheme_id")
	Set<Benificer> benificers;

	
}
