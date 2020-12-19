package com.epam.shape.main;

import com.epam.shape.exception.ReaderException;
import com.epam.shape.model.entity.comparator.TriangleComparator;

import com.epam.shape.model.initializer.InitRepository;
import com.epam.shape.model.repository.TriangleRepository;
import com.epam.shape.reader.TriangleReader;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ReaderException {
        String path = "data\\triangles.txt";
        TriangleReader reader = new TriangleReader();
        List<String> lines;
        lines = reader.readDataFromFile(path);
        InitRepository initializer = new InitRepository();
        initializer.initializeTriangleRepository(lines);

        System.out.println(
                TriangleRepository.getRepository().sort(TriangleComparator.FIRST_POINT_X_COORDINATE));
    }
}
