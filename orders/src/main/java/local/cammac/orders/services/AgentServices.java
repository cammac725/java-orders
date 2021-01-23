package local.cammac.orders.services;

import local.cammac.orders.models.Agent;

public interface AgentServices {
    Agent save(Agent agent);

    Agent findAgentById(long id);
}
