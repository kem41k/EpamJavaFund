package Task4;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Movie implements Serializable {
    private final String title;
    private final int releaseYear;
    private ArrayList<Actor> actors;

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    public static void serialize(ArrayList<Movie> movies) throws IOException {
        @Cleanup FileOutputStream outStream = new FileOutputStream("src/main/resources/ser_movies.txt");
        @Cleanup ObjectOutputStream serializer = new ObjectOutputStream(outStream);
        for(Movie movie : movies)
            serializer.writeObject(movie);
    }

    public static ArrayList<Movie> deserialize() throws Exception {
        @Cleanup FileInputStream inStream = new FileInputStream("src/main/resources/ser_movies.txt");
        @Cleanup ObjectInputStream deserializer = new ObjectInputStream(inStream);
        ArrayList<Movie> movies = new ArrayList<>();
        while (inStream.available() > 0)
           movies.add((Movie)deserializer.readObject());
        return movies;
    }
}
