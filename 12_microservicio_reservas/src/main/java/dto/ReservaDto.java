package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaDto {

	String nombre;
	String dni;
	int hotel;
	int vuelo;
	int plazas;
}