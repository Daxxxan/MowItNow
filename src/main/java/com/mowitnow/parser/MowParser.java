package com.mowitnow.parser;

import com.mowitnow.enums.Directions;
import com.mowitnow.enums.Moves;
import com.mowitnow.exception.InvalidMowerInstructions;
import com.mowitnow.ground.Cell;
import com.mowitnow.exception.InvalidFileContentException;
import com.mowitnow.mow.Mower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MowParser {
    private String filePath;

    public MowParser(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getFileContent() throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public Cell getTopRightCell(List<String> mowerInstructions) throws InvalidFileContentException {
        if(mowerInstructions.size() > 0) {
            String firstLine = mowerInstructions.get(0);
            String[] dividedLine = divideLine(firstLine);
            return new Cell(Integer.parseInt(dividedLine[0]), Integer.parseInt(dividedLine[1]));
        } else {
            throw new InvalidFileContentException("The first line of the file is not valid.");
        }
    }

    private String[] divideLine(String firstLine) throws InvalidFileContentException {
        String[] dividedLine = firstLine.split(" ");
        if(dividedLine.length == 2) {
            return dividedLine;
        } else {
            throw new InvalidFileContentException("The first line of the file is not valid.");
        }
    }

    public ArrayList<Mower> getMowers(List<String> mowerInstructions) throws InvalidMowerInstructions {
        ArrayList<Mower> mowers = new ArrayList<>();
        boolean isFirstLine = true;

        if(mowerInstructions.size() > 1) {
            Mower mower = null;
            for(int i = 1; i < mowerInstructions.size(); i++) {
                if(isFirstLine) {
                    mower = new Mower();
                    mower.setInitialPosition(getInitialCell(mowerInstructions.get(i)));
                    mower.setDirection(getDirection(mowerInstructions.get(i)));
                    isFirstLine = false;
                } else {
                    mower.setMowerMoves(getMowerMoves(mowerInstructions.get(i)));
                    mowers.add(mower);
                    isFirstLine = true;
                }
            }
        } else {
            throw new InvalidMowerInstructions("No mower instructions");
        }

        return mowers;
    }

    private Cell getInitialCell(String firstLine) throws InvalidMowerInstructions {
        String[] dividedLine = firstLine.split(" ");
        if(dividedLine.length >= 2) {
            try {
                return new Cell(Integer.parseInt(dividedLine[0]), Integer.parseInt(dividedLine[1]));
            } catch (NumberFormatException e) {
                throw new InvalidMowerInstructions("Invalid initial mower position");
            }
        } else {
            throw new InvalidMowerInstructions("Invalid initial mower position");
        }
    }

    private Directions getDirection(String firstLine) throws InvalidMowerInstructions {
        String[] dividedLine = firstLine.split(" ");
        if(dividedLine.length >= 3) {
            for(Directions direction : Directions.values()) {
                if(dividedLine[2].equals(direction.name())) {
                    return direction;
                }
            }
        }
        throw new InvalidMowerInstructions("Invalid initial direction");
    }

    private ArrayList<Moves> getMowerMoves(String secondLine) throws InvalidMowerInstructions {
        String[] dividedLine = secondLine.split("");
        ArrayList<Moves> moves = new ArrayList<>();

        for(int i = 0; i < secondLine.length(); i++) {
            moves.add(getMowerMove(Character.toString(secondLine.charAt(i))));
        }
        return moves;
    }

    private Moves getMowerMove(String stringMove) throws InvalidMowerInstructions {
        for(Moves move : Moves.values()) {
            if(stringMove.equals(move.name())) {
                return move;
            }
        }

        throw new InvalidMowerInstructions("Invalid moves");
    }
}
