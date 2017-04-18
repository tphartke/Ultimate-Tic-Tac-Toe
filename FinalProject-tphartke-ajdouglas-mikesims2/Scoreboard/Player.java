class Player {
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private int totalgames;

    Player(String name, int wins, int losses, int ties, int totalgames){
        name = this.name;
        wins = this.wins;
        losses = this.losses;
        ties = this.ties;
        totalgames = this.totalgames;
    }

    Player(String name){
        name = this.name;
        wins = 0;
        losses = 0;
        ties = 0;
        totalgames = 0;
    }


    public String toString(){
        return name + "\t" + wins + "\t" + losses + "\t" + ties + "\t" + totalgames;
    }

    int increaseWins(){
        wins++;
        totalgames++;
        return wins;
    }

    int increaseLosses(){
        losses++;
        totalgames++;
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
