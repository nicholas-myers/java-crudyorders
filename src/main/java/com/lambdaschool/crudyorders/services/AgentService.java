package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;

import java.util.List;

public interface AgentService
{
   List<Agent> findAllAgents();
   Agent findAgentByCode(long agentcode);
}
