package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "productos")
@Entity
public class Producto {
	@Id
	private int id;
	private String nombre;
	private String seccion;
	private double precio;
	private int stock;
}
