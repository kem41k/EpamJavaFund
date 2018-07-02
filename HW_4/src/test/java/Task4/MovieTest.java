package Task4;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    Actor actorBruce;
    Actor actorSchwarz;
    Actor actorVanDamme;
    Movie movie5el;
    Movie movieDieHard;
    Movie movieExp2;

    @BeforeEach
    @SneakyThrows
    void setUp() {
        actorBruce = new Actor("Bruce Willis", new SimpleDateFormat("yyyy-MM-dd").parse("1955-05-19"), "Germany");
        actorSchwarz = new Actor("Arnold Schwarzenegger", new SimpleDateFormat("yyyy-MM-dd").parse("1947-07-30"), "Austria");
        actorVanDamme = new Actor("Jean-Claude Van Damme", new SimpleDateFormat("yyyy-MM-dd").parse("1960-10-18"), "Belgium");

        movie5el = new Movie("The Fifth Element", 1997, new ArrayList<>());
        movie5el.addActor(actorBruce);

        movieDieHard = new Movie("Die Hard", 1988, new ArrayList<>());
        movieDieHard.addActor(actorBruce);

        movieExp2 = new Movie("The Expendables 2", 2012, new ArrayList<>());
        movieExp2.addActor(actorBruce);
        movieExp2.addActor(actorSchwarz);
        movieExp2.addActor(actorVanDamme);
    }

    @Test
    void addActor() {
        ArrayList<Actor> actors1 = new ArrayList<>();
        actors1.add(actorBruce);
        assertEquals(actors1, movie5el.getActors());

        assertEquals(actors1, movieDieHard.getActors());

        ArrayList<Actor> actors2 = new ArrayList<>();
        actors2.add(actorBruce);
        actors2.add(actorSchwarz);
        actors2.add(actorVanDamme);
        assertEquals(actors2, movieExp2.getActors());
    }

    @Test
    void removeActor() {
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(actorSchwarz);

        movieExp2.removeActor(actorBruce);
        movieExp2.removeActor(actorVanDamme);
        assertEquals(actors, movieExp2.getActors());
    }

    @Test
    @SneakyThrows
    void serializeAndDeserialize() {
        ArrayList<Movie> moviesBeforeSer = new ArrayList<>();
        moviesBeforeSer.add(movie5el);
        moviesBeforeSer.add(movieDieHard);
        moviesBeforeSer.add(movieExp2);

        Movie.serialize(moviesBeforeSer);
        ArrayList<Movie> moviesAfterDeser = Movie.deserialize();
        assertEquals(moviesBeforeSer, moviesAfterDeser);
    }
}