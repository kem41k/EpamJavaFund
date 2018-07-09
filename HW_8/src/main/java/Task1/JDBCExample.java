package Task1;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Value;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Value
public class JDBCExample {
    static String DB_URL = "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1";

    static String CREATE_TABLE_SQL = "create table movies (id identity, title varchar not null, director varchar not null, year int)";
    static String INSERT_MOVIE_SQL = "insert into movies (title, director, year) values (?,?,?)";
    static String GET_ALL_MOVIES_SQL = "select id, title, director, year from movies";
    static String GET_MOVIE_SQL = "select title, director, year from movies where id = ?";
    static String UPDATE_MOVIE_SQL = "update movies set title = ?, director = ?, year = ? where id = ?";
    static String DELETE_TABLE_SQL = "drop table movies";

    static String ID_FIELD = "id";
    static String TITLE_FIELD = "title";
    static String DIRECTOR_FIELD = "director";
    static String YEAR_FIELD = "year";

    @SneakyThrows
    public static void dbInit() {
        @Cleanup var connection = DriverManager.getConnection(DB_URL);
        @Cleanup var statement = connection.createStatement();
        statement.executeUpdate(CREATE_TABLE_SQL);

        PreparedStatement prepStat = connection.prepareStatement(INSERT_MOVIE_SQL);
        prepStat.setString(1, "The Terminator");
        prepStat.setString(2, "James Francis Cameron");
        prepStat.setInt(3, 1984);
        prepStat.executeUpdate();
        prepStat.setString(1, "The Fifth Element");
        prepStat.setString(2, "Luc Besson");
        prepStat.setInt(3, 1997);
        prepStat.executeUpdate();
        prepStat.setString(1, "Independence Day");
        prepStat.setString(2, "Roland Emmerich");
        prepStat.setInt(3, 1996);
        prepStat.executeUpdate();

        System.out.println(getAllMovies());
    }

    @SneakyThrows
    public static String getAllMovies() {
        StringBuilder res = new StringBuilder("");
        @Cleanup var connection = DriverManager.getConnection(DB_URL);
        @Cleanup var statement = connection.createStatement();
        @Cleanup var resultSet = statement.executeQuery(GET_ALL_MOVIES_SQL);
        while (resultSet.next())
            res.append(String.format("%d) \"%s\", %s (%d)%n",
                    resultSet.getInt(ID_FIELD),
                    resultSet.getString(TITLE_FIELD),
                    resultSet.getString(DIRECTOR_FIELD),
                    resultSet.getInt(YEAR_FIELD)));
        return res.toString();
    }

    @SneakyThrows
    public static String getMovie(int id) {
        String res = "no info";
        @Cleanup var connection = DriverManager.getConnection(DB_URL);
        PreparedStatement prepStat = connection.prepareStatement(GET_MOVIE_SQL);
        prepStat.setInt(1, id);
        @Cleanup var resultSet = prepStat.executeQuery();
        if (resultSet.next())
            res = String.format("\"%s\", %s (%d)",
                    resultSet.getString(TITLE_FIELD),
                    resultSet.getString(DIRECTOR_FIELD),
                    resultSet.getInt(YEAR_FIELD));
        return res;
    }

    @SneakyThrows
    public static void updateMovie(int id, String title, String director, int year) {
        @Cleanup var connection = DriverManager.getConnection(DB_URL);
        PreparedStatement prepStat = connection.prepareStatement(UPDATE_MOVIE_SQL);
        prepStat.setString(1, title);
        prepStat.setString(2, director);
        prepStat.setInt(3, year);
        prepStat.setInt(4, id);
        prepStat.executeUpdate();
    }

    @SneakyThrows
    public static void deleteTable() {
        @Cleanup var connection = DriverManager.getConnection(DB_URL);
        @Cleanup var statement = connection.createStatement();
        statement.executeUpdate(DELETE_TABLE_SQL);
    }
}
