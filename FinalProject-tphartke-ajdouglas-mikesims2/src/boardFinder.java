class boardFinder {
    static int findVerticalCoordinate(int verticalLocation){
        int verticalBoardLocation;
        switch(verticalLocation){
            case 0:
                verticalBoardLocation = 0;
                break;
            case 1:
                verticalBoardLocation = 0;
                break;
            case 2:
                verticalBoardLocation = 0;
                break;
            case 3:
                verticalBoardLocation = 3;
                break;
            case 4:
                verticalBoardLocation = 3;
                break;
            case 5:
                verticalBoardLocation = 3;
                break;
            case 6:
                verticalBoardLocation = 6;
                break;
            case 7:
                verticalBoardLocation = 6;
                break;
            case 8:
                verticalBoardLocation = 6;
                break;
            default:
                verticalBoardLocation = -1;
                UI.outputField.append("Error\n");
        }
        return verticalBoardLocation;
    }
}
