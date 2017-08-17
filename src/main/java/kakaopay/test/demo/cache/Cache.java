package kakaopay.test.demo.cache;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * 단축 URL을 담기 위한 캐시 정의
 * @param <T>
 */
public class Cache<T> {
    Stack<T> cache = new Stack<T>();


    public int getCount() {
        return cache.size();
    }

    public Stack<T> getCache() {
        return cache;
    }

    public void put(T item) {
        cache.push(item);
    }

    public T get() {
        return null;
    }

    public Stream<T> getStream() {
        return cache.stream();
    }
}
