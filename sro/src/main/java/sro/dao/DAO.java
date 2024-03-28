/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sro.dao;

import java.util.List;
import java.util.Optional;


public interface DAO<T> {

    Boolean guardar(T t);

    Boolean modificar(T t);

    Boolean eliminar(T t);

    List<T> listarTodos();

    T pesquisaPorId(int id);

}
