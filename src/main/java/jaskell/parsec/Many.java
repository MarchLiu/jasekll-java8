package jaskell.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-03.
 * Many 算子匹配给定算子0到多次.
 */
public class Many<E, T, Status, Tran>
    implements Parsec<E, List<T>, Status, Tran> {
    private final Parsec<E, T, Status, Tran> parsec;

    @Override
    public  List<T> parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
        List<T> re = new ArrayList<>();
        try{
            while (true){
                re.add(this.parsec.parse(s));
            }
        } catch (Exception e){
            return re;
        }
    }

    public Many(Parsec<E, T, Status, Tran> parsec) {
        this.parsec = new Attempt<>(parsec);
    }
}
