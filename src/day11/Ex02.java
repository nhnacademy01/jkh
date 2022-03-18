package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex02 {
    private static Object StreamLine;

    public static void main(String[] args) {
        Ex02 e = new Ex02();
        try {
            e.filesLines();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void  filesLines() throws IOException {
            String dir =  "/programming_java/nhnintelljver/src/day10";
            Path path = Paths.get(dir);
        //  Path path = Paths.get("/programming_java/nhnintelljver/src/day10");
            Stream<Path> fileStream = Files.list(path);

            fileStream.flatMap(this::getLines)
                    .forEach(System.out::println);
        }


    private Stream<String> getLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
