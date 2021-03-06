package br.com.namaste.dsmovie.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TITLE", length = 100)
	private String title;
	
	@Column(name = "SCORE")
	private Double score;
	
	@Column(name = "COUNT")
	private Integer count;
	
	@Column(name = "IMAGE")
	private String image;
	
	@OneToMany(mappedBy = "id.movie")
	private Set<Score> scores = new HashSet<>();
}
