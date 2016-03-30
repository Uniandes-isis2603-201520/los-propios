/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.api;

/**
 *
 * @author jg.murillo10
 */
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import java.util.List;

public interface IItinerarioLogic {

    public List<ItinerarioEntity> getItinerarios();

//    public BookEntity getBook(Long id) throws BusinessLogicException;

//    public BookEntity createBook(BookEntity entity) throws BusinessLogicException;
//
//    public BookEntity updateBook(BookEntity entity) throws BusinessLogicException;
//
//    public void deleteBook(Long id);
//
//    public List<AuthorEntity> getAuthors(Long bookId);
//
//    public AuthorEntity getAuthor(Long bookId, Long authorId);
//
//    public AuthorEntity addAuthor(Long authorId, Long bookId) throws BusinessLogicException;
//
//    public void removeAuthor(Long authorId, Long bookId);
//
//    public List<AuthorEntity> replaceAuthors(List<AuthorEntity> authors, Long bookId) throws BusinessLogicException;

}
