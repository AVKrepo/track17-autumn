package ru.track.cypher;

import java.util.*;

import org.jetbrains.annotations.NotNull;

/**
 * Вспомогательные методы шифрования/дешифрования
 */
public class CypherUtil {

    public static final String SYMBOLS = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Генерирует таблицу подстановки - то есть каждой буква алфавита ставится в соответствие другая буква
     * Не должно быть пересечений (a -> x, b -> x). Маппинг уникальный
     *
     * @return таблицу подстановки шифра
     */
    @NotNull
    public static Map<Character, Character> generateCypher() {
        Map<Character, Character> map = new HashMap<>();
        List<Character> cypherSymbols = new ArrayList<>();
        for (int i = 0; i < SYMBOLS.length(); ++i) {
            cypherSymbols.add(SYMBOLS.charAt(i));
        }
        Collections.shuffle(cypherSymbols);
        for (int i = 0; i < SYMBOLS.length(); ++i) {
            char symbol = SYMBOLS.charAt(i);
//            char cipher = SYMBOLS.charAt((i + 1) % SYMBOLS.length());
            char cipher = cypherSymbols.get(i);
            map.put(symbol, cipher);
        }
        return map;
    }

}