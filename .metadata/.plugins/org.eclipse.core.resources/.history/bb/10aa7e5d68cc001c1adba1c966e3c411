package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import model.Producto;
import service.productService;

@CrossOrigin(origins = "*")
@Controller
public class ProductController {

	@Autowired
	productService productService;
	
	
	@GetMapping(value = "Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Producto> buscar(@RequestParam("seccion") String seccion) {
       return productService.read(seccion);
        
    }

    @PostMapping(value = "Alta")
    public String añadirProducto(@ModelAttribute Producto product) {
        productService.create(product);
        return "datos";
    }

    @GetMapping(value = "Eliminar")
    public String eliminarProducto(@RequestParam("nombre") String nombre) {
        productService.delete(nombre);
        return "datos";
    }

    @GetMapping(value = "Modificar")
    public String modificarProducto(@RequestParam("nombre") String nombre, @RequestParam("precio") String precio) {
        productService.update(new Producto(0, nombre, "", Double.parseDouble(precio), -1));
        return "datos";
    }
	
}
