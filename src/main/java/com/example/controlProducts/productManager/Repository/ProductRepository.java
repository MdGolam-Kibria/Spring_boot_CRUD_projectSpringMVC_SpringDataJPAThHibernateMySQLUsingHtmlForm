package com.example.controlProducts.productManager.Repository;

import com.example.controlProducts.productManager.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /***
     * below:=
     * select p = here p means Product first latter p
     */
    @Query("select p from Product p where p.brand=?1")
    List<Product> getAllProductByBrand(String brand);

    @Query("select p from Product p where p.brand = :brand and p.madein = :madein")
    List<Product> getAllProductByBrandAndMadein(@Param("brand") String brand, @Param("madein") String madein);

    /***
     * Now i want to update something using query
     * below the update tricks
     * if i want to modify something like UPDATE,DELETE,DROP then must use this two annotation
     * @Transactional
     * @Modifying
     **/
    @Transactional
    @Modifying
    @Query("update Product p set p.brand=?2 where p.id=?1")
    void updateProductBrandByIdAndBrandName(Long id, String brand);//UPDATE brand name for a product
}
