class Player {
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private int totalgames;

    Player(String name){
        this.name = name;
        if(LeaderboardReader.newPlayer(name)){
            wins = 0;
            losses = 0;
            totalgames = 0;
        }
        else{
            wins = LeaderboardReader.playerWins;
            losses = LeaderboardReader.playerLosses;
            totalgames = wins + losses;
        }
    }


    public String toString(){
        return name + "\t" + wins + "\t" + losses + "\t" + totalgames + "\n";
    }

    int increaseWins(){
        wins++;
        return wins;
    }

    int increaseLosses(){
        losses++;
        return losses;
    }

    int increaseTies(){
        ties++;
        totalgames++;
        return ties;
    }

    int getTotalGames(){
        return totalgames;
    }

    String getName(){
        return name;
    }
}
