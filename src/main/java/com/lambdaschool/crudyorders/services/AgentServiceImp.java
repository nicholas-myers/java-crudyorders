package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service(value = "agentService")
public class AgentServiceImp implements AgentService
{
   @Autowired
   private AgentRepository agentrepos;

   @Override
   public List<Agent> findAllAgents()
   {
      List<Agent> list = new ArrayList<>();

      agentrepos.findAll()
              .iterator()
              .forEachRemaining(list::add);
      return list;
   }

   @Override
   public Agent findAgentByCode(long agentcode)
           throws EntityNotFoundException
   {
      return agentrepos.findById(agentcode)
              .orElseThrow(() -> new EntityNotFoundException("Agent " + agentcode + " Not Found"));
   }
}
