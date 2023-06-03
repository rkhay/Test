package ru.rkhayrit.computershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rkhayrit.computershop.exception.RecordNotFoundException;
import ru.rkhayrit.computershop.model.NoteBook;
import ru.rkhayrit.computershop.repository.NoteBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteBookService {

    @Autowired
    NoteBookRepository repository;

    public List<NoteBook> getAllNoteBooks() {
        Optional<List<NoteBook>> NoteBookList = Optional.of(repository.findAll());
        return NoteBookList.orElseGet(ArrayList::new);
    }

    public NoteBook getNoteBookById(Long id) {
        Optional<NoteBook> NoteBook = repository.findById(id);

        if (NoteBook.isPresent()) {
            return NoteBook.get();
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }

    public NoteBook addNoteBook(NoteBook entity) {
        entity = repository.save(entity);
        return entity;
    }

    public NoteBook updateNoteBook(NoteBook entity) {
        Optional<NoteBook> NoteBook = repository.findById(entity.getId());

        if(NoteBook.isPresent()) {
            NoteBook newEntity = NoteBook.get();
            newEntity.setSerialNumber(entity.getSerialNumber());
            newEntity.setManufacturer(entity.getManufacturer());
            newEntity.setPrice(entity.getPrice());
            newEntity.setAvailableOnTheStock(entity.getAvailableOnTheStock());
            newEntity.setSize(entity.getSize());

            newEntity = repository.save(newEntity);

            return newEntity;
        }

        throw new RecordNotFoundException("There is no such a record for updating");
    }

    public void deleteNoteBookById(Long id) {
        Optional<NoteBook> noteBook = repository.findById(id);

        if(noteBook.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }

}
