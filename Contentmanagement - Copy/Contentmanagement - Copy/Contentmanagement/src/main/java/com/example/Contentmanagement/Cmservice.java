package com.example.Contentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Cmservice {
    @Autowired
    private Cmrepository repo;

    public List<Content> listAll() {
        return repo.findAll();
    }

    public void save(Content content) {
        repo.save(content);
    }

    public Content get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
