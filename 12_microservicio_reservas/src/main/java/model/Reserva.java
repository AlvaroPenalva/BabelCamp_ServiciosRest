package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="reservas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idreserva;
	String nombre;
	String dni;
	int hotel;
	int vuelo;
	
}
