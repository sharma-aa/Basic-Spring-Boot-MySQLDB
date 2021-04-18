package com.example.Mysqldb.FootballPlayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@ComponentScan
@RestController
public class Controller {
    @Autowired
    private Service service;

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String get_home(){
        return service.get_home();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPlayer")
    public @ResponseBody String addNewPlayer(@RequestBody Player new_player){
        service.addNewPlayer(new_player);
        return "Added!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Player/{id}")
    public Optional<Player> getPlayer(@PathVariable Integer id){
        return service.getPlayer(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allPlayers")
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/editPlayer/{id}")
    public String updatePlayer(@RequestBody Player update_player ,@PathVariable Integer id){
        service.updatePlayer(update_player, id);
        return "Updated!";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePlayer/{id}")
    public String deletePlayer(@PathVariable Integer id){
        String Name = service.deletePlayer(id);
        return Name + "Deleted";
    }
}
