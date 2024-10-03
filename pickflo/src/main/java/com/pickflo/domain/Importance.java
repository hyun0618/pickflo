package com.pickflo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor 
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString 
@EqualsAndHashCode
@Entity
@Table(name="IMPORTANCE")
public class Importance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMPORTANCE_ID")
	private Long id;
	
	@Basic(optional = false)
	private String importanceType;
	
	@Basic(optional = false)
	private Integer importanceValue;
	
	
	
}