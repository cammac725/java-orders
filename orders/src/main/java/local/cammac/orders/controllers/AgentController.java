package local.cammac.orders.controllers;

import local.cammac.orders.models.Agent;
import local.cammac.orders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentServices agentServices;

    // http://localhost:2021/agents/agent/{id}
    @GetMapping(value = "/agent/{agentId}", produces = "application/json")
    public ResponseEntity<?> findAgentById(@PathVariable long agentId) {
        Agent agent = agentServices.findAgentById(agentId);
        return new ResponseEntity<Object>(agent, HttpStatus.OK);
    }

}
