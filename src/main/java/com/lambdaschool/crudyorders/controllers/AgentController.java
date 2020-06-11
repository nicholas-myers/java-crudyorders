package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentController
{
   @Autowired
   private AgentService agentService;


   @GetMapping(value = "/agents",
           produces = {"application/json"})
   public ResponseEntity<?> listAllAgents() {
      List<Agent> allAgents = agentService.findAllAgents();
      return new ResponseEntity<>(allAgents, HttpStatus.OK);
   }

   @GetMapping(value = "/agents/agent/{agentcode}",
           produces = {"application/json"})
   public ResponseEntity<?> getCustomerByCode(@PathVariable Long agentcode) {
      Agent a = agentService.findAgentByCode(agentcode);
      return new ResponseEntity<>(a, HttpStatus.OK);
   }
}
