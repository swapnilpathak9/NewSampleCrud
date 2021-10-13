package com.sample.sampleCRUD.service;
import com.sample.sampleCRUD.entity.Product;
import com.sample.sampleCRUD.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    ProductRepository repository;
    @InjectMocks
    ProductService productService;
    @Test
    public void testIfProductIsReturnedSuccess() {
        Product expected = new Product(1, "ABC");
        Mockito.when(repository.findByName(anyString())).thenReturn(expected);
        Optional<Product> Product = Optional.ofNullable(productService.getProductByName("ABC"));
        Assertions.assertTrue(Product.isPresent());
        Assertions.assertEquals(expected, Product.get());
    }
    @Test
    public void test_JUnit() {
        System.out.println("This is the testcase in this class");
        String str1="This is the testcase in this class";
        Assertions.assertEquals("This is the testcase in this class", str1);
    }
    @Test
    public void TestSaveProduct(){
        Product product = new Product(3, "Bat");
        Mockito.when(repository.save(product)).thenReturn(product);
        Assertions.assertEquals(product,productService.saveProduct(product));
    }
    @Test
    public void  TestDeleteProduct(){
        Product product = new Product(4, "Shoes");
        Assertions.assertEquals("product removed !!4",productService.deleteProduct(4));
    }
    @Test
    public void deleteProductTest(){
        Product product = new Product(1,"xyz");
        productService.deleteProduct(1);
    }
    @Test
    public void SaveuserTest() {
        Product product = new Product(212, "rhutvika");
        Mockito.when(repository.save(product)).thenReturn(product);
        Assertions.assertEquals(product, productService.saveProduct(product));
    }
    @Test
    public void getproductTest(){
        Mockito.when(repository.findAll()).thenReturn(Stream.of(new Product(1,"ABC")).collect(Collectors.toList()));
        Assertions.assertEquals(1,productService.getProducts().size());
    }
}