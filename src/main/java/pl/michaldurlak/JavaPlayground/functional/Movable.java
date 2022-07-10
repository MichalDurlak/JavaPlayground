package pl.michaldurlak.JavaPlayground.functional;

@FunctionalInterface //adnotacja głównie dla czytającego kod ale również gdy dorzucimy do kodu kolejną funkcję to adnotacja podkresli się na czerwono
public interface Movable {

    int move(String direction);

}
