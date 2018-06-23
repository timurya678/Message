import java.util.HashMap;
import java.util.Stack;
import java.util.regex.*;

interface IMessage {


    public int countWords();        // возвращает количество слов
    public String reverse();
    public int count(char c);
    public boolean isValid();
}

class Message implements IMessage {
    private HashMap<Character, Character> couples = new HashMap<>();

    {
        couples.put('<','>');
        couples.put('{','}');
        couples.put('[',']');
        couples.put('(',')');
    }

    private Stack<Character> stack = new Stack<>();

    private String message;

    public Message(String message) {
        this.message = message;
    }

    // реализовать все методы интерфейса IMessage...
    @Override
    public int countWords() {
        return message.trim().split("\\s+").length;
    }

    @Override
    public String reverse() {
        return new StringBuilder(message).reverse().toString();
    }

    @Override
    public int count(char c) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i)==c)
                count++;
        }
        return count;
    }

    @Override
    public boolean isValid() {
        stack.clear();
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (couples.containsKey(character))
                stack.push(character);
            if (couples.containsValue(character)) {
                if (stack.empty()||couples.get(stack.pop())!=character) {
                    return false;
                }
            }
        }
            return (stack.empty());

    }



}


public class Main {
    public static void main(String[] args) {
        Message msg = new Message("{s<  Te[st, 123  m>es]sage}?  s)");
        System.out.println(msg.countWords());
        System.out.println(msg.reverse());
        System.out.println(msg.count('e'));
        System.out.println(msg.isValid());
    }
}
