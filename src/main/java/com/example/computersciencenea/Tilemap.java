package com.example.computersciencenea;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Tilemap {
    private Image[][] tiles;
    private LinkedList sprites;

    public Tilemap(int width, int height) {
        tiles = new Image[width][height];
        sprites = new LinkedList();
    }

    public int getWidth() {
        return tiles.length;
    }

    public int getHeight() {
        return tiles[0].length;
    }

    public Image getTile(int x, int y) {
        if (x < 0 || x >= getWidth() ||
                y < 0 || y >= getHeight()) {
            return null;
        } else {
            return tiles[x][y];
        }
    }

    public void setTile(int x, int y, Image tile) {
        tiles[x][y] = tile;
    }

    private Tilemap loadmap(String filename) throws IOException {
        ArrayList lines = new ArrayList();
        int width = 0
        int height = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                break;
            }
            if (!line.startsWith("#")) {
                lines.add(line);
                width = Math.max(width, line.length());
            }
        }
        height = lines.size();
        Tilemap newMap = new Tilemap(width, height);
        for (int y = 0; y < height; y++) {
            String line = (String) lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                char ch = line.charAt(x);
                int tile = ch - 'A';
                if (tile >= 0 && tile < tiles.size) {
                    newMap.setTile(x, y, (Image) tiles.get(tile));
                }


            }
        }
        return newMap;
    }
}
