package com.notify.NotifyEgerton.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notify.NotifyEgerton.model.Groups;
import com.notify.NotifyEgerton.repository.GroupRepository;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public List<Groups> getAllGroups(String username) {

        List<Groups> groups = new ArrayList<>();
        groupRepository.findByUsers_Username(username)
                .forEach(groups::add);

        return groups;
    }

    public List<Groups> getAllGroups(Long groupId) {

        List<Groups> groups = new ArrayList<>();

        groupRepository.findAllBygroupId(groupId)
                .forEach(groups::add);

        return groups;
    }

    public List<Groups> getAllGroups() {

        List<Groups> group = new ArrayList<>();

        groupRepository.findAll().forEach(group::add);

        return group;
    }

    public void addGroup(Groups group) {
        groupRepository.save(group);
    }

    public Optional<Groups> getGroup(long id) {

        return groupRepository.findById(id);

    }

    public boolean isGroupPresent(String name) {

        return groupRepository.existsByName(name);
    }

}
