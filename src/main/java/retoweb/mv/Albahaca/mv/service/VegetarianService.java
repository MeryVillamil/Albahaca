/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retoweb.mv.Albahaca.mv.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retoweb.mv.Albahaca.mv.model.Vegetarian;
import retoweb.mv.Albahaca.mv.repositori.VegetarianRepository;

/**
 *
 * @author Mery Villamil
 */
@Service
public class VegetarianService {

    @Autowired
    private VegetarianRepository repository;

    public List<Vegetarian> getAll() {
        return repository.getAll();
    }

    public Optional<Vegetarian> getProduct(String reference) {
        return repository.getproduct(reference);
    }

    public Vegetarian create(Vegetarian accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Vegetarian update(Vegetarian accesory) {

        if (accesory.getReference() != null) {
            Optional<Vegetarian> accesoryDb = repository.getproduct(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<Vegetarian> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}