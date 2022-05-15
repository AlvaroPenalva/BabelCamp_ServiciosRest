package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pais {
	@JsonProperty("name")
	String nombre;
	@JsonProperty("capital")
	String capital;
	@JsonProperty("region")
	String continente;
	@JsonProperty("population")
	long poblacion;
	@JsonProperty("flag")
	String bandera;
}
