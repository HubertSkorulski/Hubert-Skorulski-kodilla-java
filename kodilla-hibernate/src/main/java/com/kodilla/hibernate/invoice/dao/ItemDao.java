package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import org.springframework.data.repository.CrudRepository;

interface ItemDao extends CrudRepository<Item,Integer> {

}

