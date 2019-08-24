package com.company.UlricTodmanU1M5Summative.dao;

import com.company.UlricTodmanU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {
    public Publisher addPublisher(Publisher publisher);
    public Publisher getPublisher(int publisherId);
    public List<Publisher> getAllPublishers();
    public void updatePublisher(Publisher publisher);
    public void deletePublisher(int publisherId);
}
