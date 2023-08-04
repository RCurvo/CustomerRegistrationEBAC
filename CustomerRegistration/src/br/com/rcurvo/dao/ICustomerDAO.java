package br.com.rcurvo.dao;

import br.com.rcurvo.domain.Customer;

import java.util.Collection;

public interface ICustomerDAO {

    public Boolean register(Customer customer);

    public void delete(Long cpf);
    public void edit(Customer customer);
    public Customer search(Long cpf);
    public Collection<Customer> searchAll();
}
