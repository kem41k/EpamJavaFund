package Task2.cp;

// https://www.jetbrains.com/help/idea/nullable-and-notnull-annotations.html
import org.jetbrains.annotations.NotNull;
import lombok.Cleanup;
import lombok.val;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public interface JDBCDao<T extends Identifiable<T>> {

    @NotNull
    <U extends T> U save(@NotNull U t);

    @NotNull
    default <U extends T> Optional<U> findById(long id) {
        //noinspection unchecked
        return (Optional<U>) mapAll(all -> all
                .filter(t -> t.getId() == id)
                .findAny());
    }

    @NotNull
    <U extends T> Stream<U> findAll();

    default <R> R mapAll(Function<Stream<T>,R> mapper) {
        @Cleanup val stream = findAll();
        return mapper.apply(stream);
    }

    default void withAll(Consumer<Stream<T>> mapper) {
        @Cleanup val stream = findAll();
        mapper.accept(stream);
    }

    @NotNull
    <U extends T> U update(@NotNull U t);

    @NotNull
    <U extends T> JDBCDao<T> delete(@NotNull U u);

    @NotNull
    default JDBCDao<T> clear() {
        withAll(all -> all.forEach(this::delete));
        return this;
    }

    default long count() {
        return mapAll(Stream::count);
    }

    default boolean existsById(long id) {
        return findById(id).isPresent();
    }
}