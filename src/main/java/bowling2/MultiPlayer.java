/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bowling.MultiPlayerGame;
import bowling.SinglePlayerGame;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author pedago
 */
public class MultiPlayer implements MultiPlayerGame {

    SinglePlayerGame games[];
    ArrayList<String> playerNames;
    int joueurCourant;
    
    public MultiPlayer(String[] playerName) throws Exception {
        startNewGame(playerName);
    }
    public String startNewGame(String[] playerName) throws Exception {
        joueurCourant=0;
        games = new SinglePlayerGame[playerName.length];
        
        for(int i = 0 ; i < games.length ; i++) {
            games[i] = new SinglePlayerGame();
        }
        
        playerNames = new ArrayList<>(Arrays.asList(playerName)); // On copie les noms dans une ArrayList pour faciliter la recherche du score d'un joueur avec la méthode indexOf()
        
        return getNomJoueurCourant();
    }
    

    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        games[joueurCourant].lancer(nombreDeQuillesAbattues);
        joueurCourant = (joueurCourant+1) % games.length;
        
        return getNomJoueurCourant();
    }

    public int scoreFor(String playerName) throws Exception {
        if(playerNames.contains(playerName)){
            int indiceJoueur = playerNames.indexOf(playerName);

            return games[indiceJoueur].score();
        } else {
            throw new Exception("Le joueur " + playerName + " ne joue pas.");
        }
    }
    
}
