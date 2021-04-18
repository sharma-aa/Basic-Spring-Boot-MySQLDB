package com.example.Mysqldb.FootballPlayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ComponentScan
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private PlayerRepository player_repo;

    public String get_home(){
        return "Welcome Home!";
    }

    public void addNewPlayer(Player new_player) {
        player_repo.save(new_player);
        return;
    }

    public Optional<Player> getPlayer(Integer Id) {
        return player_repo.findById(Id);
    }

    public List<Player> getAllPlayers() {
        ArrayList<Player> retVal = new ArrayList<>();
        player_repo.findAll().forEach(retVal::add);
        return retVal;
    }

    public void updatePlayer(Player update_player, Integer id) {
        Optional<Player> optional_p = player_repo.findById(id);
        Player p = optional_p.get();

        if (p != null){
            p.setName(update_player.getName());
            p.setClub(update_player.getClub());
            p.setCountry(update_player.getCountry());
            player_repo.save(p);
        }
        else{
            player_repo.save(update_player);
        }

        return;
    }

    public String deletePlayer(Integer id) {
        Optional<Player> optional_p = getPlayer(id);
        Player p = optional_p.get();

        String Name = p.getName();

        player_repo.deleteById(id);
        return Name;
    }
}
