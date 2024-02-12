package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import entidad.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
