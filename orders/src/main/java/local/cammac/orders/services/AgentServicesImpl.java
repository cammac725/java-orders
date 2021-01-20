package local.cammac.orders.services;

import local.cammac.orders.models.Agent;
import local.cammac.orders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices{

    @Autowired
    AgentsRepository agentrepos;

    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }
}
