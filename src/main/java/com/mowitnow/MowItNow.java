package com.mowitnow;

import com.mowitnow.exception.InvalidFileContentException;
import com.mowitnow.exception.InvalidMowerInstructions;
import com.mowitnow.exception.ReadFileException;
import com.mowitnow.ground.Cell;
import com.mowitnow.ground.Field;
import com.mowitnow.mow.Mower;
import com.mowitnow.parser.MowParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MowItNow {
    public static void main (String[] args) {
        List<String> mowerInstructions;
        String filePath = args[0];

        try {
            MowParser mowParser = setMowerParser(filePath);
            mowerInstructions = getMowerInstructions(mowParser);
            Cell topRightCell = mowParser.getTopRightCell(mowerInstructions);
            ArrayList<Mower> mowers = mowParser.getMowers(mowerInstructions);
            Field field = new Field(topRightCell);
        } catch (ReadFileException | InvalidFileContentException | InvalidMowerInstructions e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<String> getMowerInstructions(MowParser mowParser) throws ReadFileException {
        try {
            return mowParser.getFileContent();
        } catch (IOException e) {
            throw new ReadFileException("Impossible to read file.");
        }
    }

    private static MowParser setMowerParser(String filePath) throws ReadFileException {
        if(Files.exists(Paths.get(filePath))) {
            return new MowParser(filePath);
        } else {
            throw new ReadFileException("File doesn't exist.");
        }
    }
}
