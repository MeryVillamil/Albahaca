/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package retoweb.mv.Albahaca.mv.repository.crud;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retoweb.mv.Albahaca.mv.model.Vegetarian;

/**
 *
 * @author Mery Villamil
 */
  public interface VegetarianCrudRepository extends MongoRepository<Vegetarian, String> {
    //Reto 5
    public List<Vegetarian> findByPriceLessThanEqual(double precio);
    
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Vegetarian> findByDescriptionLike(String description);
}  

