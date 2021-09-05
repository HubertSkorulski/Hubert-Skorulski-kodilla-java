package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    void testInvoiceDaoSave() {

        //Given
        Product productOne = new Product("Apple");
        Product productTwo = new Product("Banana");
        Item itemOne = new Item(BigDecimal.valueOf(25.33),2,BigDecimal.valueOf(50.66));
        Item itemTwo = new Item(BigDecimal.valueOf(35.00),3,BigDecimal.valueOf(105.00));
        Item itemThree = new Item(BigDecimal.valueOf(25.00),3,BigDecimal.valueOf(75.00));
        productOne.getItemsProduct().add(itemOne);
        productTwo.getItemsProduct().add(itemTwo);
        productOne.getItemsProduct().add(itemThree);
        itemOne.setProduct(productOne);
        itemTwo.setProduct(productTwo);
        itemThree.setProduct(productOne);

        Invoice invoice = new Invoice("1234");
        invoice.getItems().add(itemOne);
        invoice.getItems().add(itemTwo);
        invoice.getItems().add(itemThree);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0,id);

    }
}
